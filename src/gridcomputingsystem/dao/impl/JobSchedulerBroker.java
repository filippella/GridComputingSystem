/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.dao.impl;

import gridcomputingsystem.dao.ItemDAO;
import gridcomputingsystem.model.Job;
import java.util.List;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class JobSchedulerBroker {

    private final GridInformationServiceDB<Job> jobDB;
    private final ItemDAO.ItemType type = ItemDAO.ItemType.JOB;

    public JobSchedulerBroker() {
        this.jobDB = new GridInformationServiceDB<>();
    }

    public void addItem(Job item) {
        this.jobDB.addItem(item);
    }

    public void removeItem(Job item) {
        this.jobDB.removeItem(item);
    }

    public List<Job> getAllItems() {
        return this.jobDB.getAllItems(this.type);
    }

    public int size() {
        return this.jobDB.getAllItems(this.type).size();
    }

    public void updateItem(Job item) {
        this.jobDB.updateItem(item);
    }

    public boolean searchItem(String keyword) {
        return this.jobDB.searchItem(this.type, keyword);
    }

    public void emptyItems() {
        this.jobDB.emptyItems(this.type);
    }

    protected String generateCode(String indent) {
        String code = "\n" + indent + "//------------------------------";
        code += "\n" + indent + "GridletList glList;";
        code += "\n" + indent + "Experiment expt;";
        code += "\n" + indent + "JobEntity jobEntity;";
        code += "\n" + indent + "int count = 0;";
        code += "\n";

        List<Job> allItems = getAllItems();

        for (int i = 0; i < allItems.size(); i++) {
            Job job = allItems.get(i);
            int id = i + 1;
            code += generateGridletCode(id, job, indent);
        }

        return code;
    }

    private String generateGridletCode(int id, Job job, String indent) {
        String code = "";
        String seed = "seed*997*(1+" + id + ")+1";
        final int VAL = 100;

        // do the init
        code += "\n" + indent + "///////// Create " + job.getName();
        code += "\n" + indent;
        code += "random = new Random(" + seed + ");";
        code += "\n" + indent + "glList = new GridletList();";
        code += "\n";

        // Create the gridlets
        code += "\n" + indent;
        code += "count = (int) GridSimRandom.real(" + job.getGridletSize() + ", ";
        code += (job.getGridletMinDeviation() / VAL) + ", " + (job.getGridletMaxDeviation() / VAL);
        code += ", random.nextDouble());";

        // loop to add one gridlet at the time to the linked-list
        code += "\n" + indent;
        code += "for (int i = 0; i < count; i++) {";
        code += "\n" + indent + "    ";
        code += "double len = GridSimRandom.real(" + job.getLengthSize() + ", ";
        code += (job.getLengthMinDeviation() / VAL) + ", " + (job.getLengthMaxDeviation() / VAL);
        code += ", random.nextDouble());";

        code += "\n" + indent + "    ";
        code += "long file = (long) GridSimRandom.real(" + job.getFileSize() + ", ";
        code += (job.getFileMinDeviation() / VAL) + ", " + (job.getFileMaxDeviation() / VAL);
        code += ", random.nextDouble());";

        code += "\n" + indent + "    ";
        code += "long out = (long) GridSimRandom.real(" + job.getOutputSize() + ", ";
        code += (job.getOutputMinDeviation() / VAL) + ", " + (job.getOutputMaxDeviation() / VAL);
        code += ", random.nextDouble());";

        code += "\n" + indent + "    ";
        code += "Gridlet gl = new Gridlet(i, len, file, out);";

        code += "\n" + indent + "    glList.add(gl);";
        code += "\n" + indent + "}";

        // create the experiment
        code += "\n" + indent + "expt = new Experiment(" + id + ", glList, ";
        code += job.getSchedulingStrategyNumber()+ ", " + job.getApproachNumber()+ ", ";
        code += job.getDeadline() + ", " + job.getBudget() + ", " + "\"report" + id + ".txt\", ";
        code += "resourceNameList);";

        // create the user entity
        code += "\n" + indent;
        code += "jobEntity = new JobEntity(\"Job" + id + "\", expt, ";
        code += job.getBaudRate() + ", " + seed + ", " + job.getSuccessiveExperimentDelaySecond() + ", false);";
        code += "\n";

        return code;
    }
}
