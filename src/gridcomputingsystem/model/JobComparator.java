/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.model;

import java.util.Comparator;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class JobComparator implements Comparator<Job> {

    @Override
    public int compare(Job o1, Job o2) {
        if (o1.getPriority() == o2.getPriority()) {
            return 0;
        } else if (o1.getPriority() > o2.getPriority()) {
            return -1;
        } else {
            return 1;
        }
    }
}
