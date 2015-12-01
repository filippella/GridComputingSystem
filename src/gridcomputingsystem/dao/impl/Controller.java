/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.dao.impl;

import gridcomputingsystem.model.ItemActionListener;
import gridcomputingsystem.model.Job;
import gridcomputingsystem.model.Resource;
import gridcomputingsystem.view.About;
import gridcomputingsystem.view.JobDialog;
import gridcomputingsystem.view.SchedulerInputView;
import gridcomputingsystem.view.MainView;
import gridcomputingsystem.view.ResourceDialog;
import gridcomputingsystem.view.SchedulerInputView.SchedulerInputListener;
import gridcomputingsystem.view.custom.TabHeaderView;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;

/**
 *
 * @author Filippo-TheAppExpert
 */
public abstract class Controller implements SchedulerInputListener, ItemActionListener.JobActionListener, ItemActionListener.ResourceActionListener {

    private int tabCounter;
    private int currentTabCount;
    private final GridScheduleManager scheduleManager;
    private int jobAddedIndex, resourceAddedIndex;

    private final TabHeaderView.TabActionListener tabListener = () -> {
        tabCounter--;
    };

    public Controller() {
        this.scheduleManager = new GridScheduleManager(getMainView());
    }

    public void newMenuEvent() {

        SchedulerInputView inputView = new SchedulerInputView(Controller.this);

        getTab().addTab("New File", inputView);
        currentTabCount++;
        getTab().setTabComponentAt(tabCounter, new TabHeaderView(tabListener, inputView, "New File " + currentTabCount));
        tabCounter++;

        populateJobsFromDB(inputView);
        populateResourcesFromDB(inputView);
    }

    public void exitMenuEvent() {
        System.exit(0);
    }

    public void openMenuEvent() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.showOpenDialog(getMainView());
    }

    public void preferenceMenuEvent() {
    }

    public void cutMenuEvent() {
    }

    public void copyMenuEvent() {
    }

    public void pasteMenuEvent() {
    }

    public void aboutMenuEvent() {
        About about = new About(getMainView(), true);
        if (!about.isVisible()) {
            about.setVisible(true);
        }
    }

    public abstract MainView getMainView();

    public abstract JTabbedPane getTab();

    @Override
    public void onJobAddDialog(String job, int addedIndex) {
        this.jobAddedIndex = addedIndex;
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.decrementJobCounter();

        JobDialog jobDialog = new JobDialog(getMainView(), true, Controller.this);
        jobDialog.initializeJobPropertiesRandomly();
        jobDialog.setEditMode(false);
        jobDialog.setTitle("Job Property Dialog");
        jobDialog.setLocationRelativeTo(getMainView());
        jobDialog.setVisible(true);
    }

    @Override
    public void onViewJob(Job job, int selectedIndex) {
        JobDialog jobDialog = new JobDialog(getMainView(), true, Controller.this);
        jobDialog.setEditMode(true);
        jobDialog.setJob(job);
        jobDialog.setJobCount(selectedIndex);
        jobDialog.setTitle("View Job Property Dialog");
        jobDialog.setLocationRelativeTo(getMainView());
        jobDialog.setVisible(true);
    }

    @Override
    public void onJobAdded(Job job, int addedIndex) {
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.addJob(job, addedIndex);
        inputView.incrementJobCounter();
        
        this.scheduleManager.getJobScheduler().addItem(job);

        System.out.println("Job added");
    }

    @Override
    public void onJobEdited(Job job, int jobCount) {
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.editJob(job, jobCount);
    }

    @Override
    public void onJobRemove(Job job, int removedIndex) {
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.removeJob(job.getName(), removedIndex);
        this.scheduleManager.getJobScheduler().removeItem(job);
        System.out.println("onJobRemoved");
    }

    @Override
    public int getJobCount() {
        return this.jobAddedIndex;
    }

    @Override
    public void onResourceAddDialog(String resource, int addedIndex) {
        this.resourceAddedIndex = addedIndex;
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.decrementResourceCounter();

        ResourceDialog resourceDialog = new ResourceDialog(getMainView(), true, Controller.this);
        resourceDialog.initializeResourcePropertiesRandomly();
        resourceDialog.setEditMode(false);
        resourceDialog.setTitle("Resource Property Dialog");
        resourceDialog.setLocationRelativeTo(getMainView());
        resourceDialog.setVisible(true);
    }

    @Override
    public void onResourceRemove(Resource resource, int removedIndex) {
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.removeResource(resource.getName(), removedIndex);
        System.out.println("onResourceRemoved");
        this.scheduleManager.getResourceScheduler().removeItem(resource);
    }

    @Override
    public void onResourceAdded(Resource resource, int addedIndex) {
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.addResource(resource, addedIndex);
        inputView.incrementResourceCounter();

        this.scheduleManager.getResourceScheduler().addItem(resource);

        System.out.println("Resource Added");
    }

    @Override
    public void onResourceEdited(Resource resource, int resourceCount) {
        SchedulerInputView inputView = (SchedulerInputView) getTab().getSelectedComponent();
        inputView.editResource(resource, resourceCount);
    }

    @Override
    public void onViewResource(Resource resource, int selectedIndex) {
        ResourceDialog resourceDialog = new ResourceDialog(getMainView(), true, Controller.this);
        resourceDialog.setEditMode(true);
        resourceDialog.setResource(resource);
        resourceDialog.setResourceCount(selectedIndex);
        resourceDialog.setTitle("View Resource Property Dialog");
        resourceDialog.setLocationRelativeTo(getMainView());
        resourceDialog.setVisible(true);
    }

    @Override
    public int getResourceCount() {
        return this.resourceAddedIndex;
    }

    /**
     * This method is responsible to initiate the scheduling and allocating job
     * and resources using the grid computing algorithm
     */
    public void generateSchedule() {
        //String algorithmClassName = JOptionPane.showInputDialog(null, "Please specify a java class name for the algorithm to be generated!", "Class Name *.java is required!", JOptionPane.INFORMATION_MESSAGE);
        this.scheduleManager.generateSchedule("");
    }

    private void populateJobsFromDB(SchedulerInputView inputView) {
        List<Job> allItems = this.scheduleManager.getJobScheduler().getAllItems();

        for (int i = 0; i < allItems.size(); i++) {
            Job job = allItems.get(i);
            inputView.addJob(job, i);
            inputView.incrementJobCounter();
        }
    }

    private void populateResourcesFromDB(SchedulerInputView inputView) {

        List<Resource> allItems = this.scheduleManager.getResourceScheduler().getAllItems();

        for (int i = 0; i < allItems.size(); i++) {
            Resource resource = allItems.get(i);
            inputView.addResource(resource, i);
            inputView.incrementResourceCounter();
        }
    }
}
