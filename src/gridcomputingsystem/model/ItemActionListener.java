/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.model;

/**
 *
 * @author Filippo-TheAppExpert
 */
public interface ItemActionListener {

    public interface JobActionListener {

        void onJobAdded(Job job, int addedIndex);

        int getJobCount();

        void onJobEdited(Job job, int jobCount);
    }

    public interface ResourceActionListener {

        void onResourceAdded(Resource resource, int addedIndex);

        int getResourceCount();

        void onResourceEdited(Resource resource, int resourceCount);
    }
}
