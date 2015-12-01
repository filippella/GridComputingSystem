/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.algorithm;

import gridcomputingsystem.model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class AlgorithmPUDCERS {

    private final List<Job> jobs;
    private final List<Resource> resources;
    private PriorityQueue<Resource> resourcesPrioritized;
    private final JobResourceAllocationMapping allocationMapping = new JobResourceAllocationMapping();

    public AlgorithmPUDCERS(List<Job> jobs, List<Resource> resources) {
        this.jobs = jobs;
        this.resources = resources;
    }

    public void schedule() {
        PriorityQueue<Job> jobPrioritized = prioritizeJobs();
        resourcesPrioritized = prioritizeResource();
        System.out.println("All Jobs :: " + jobPrioritized.toString());

        int jobSize = jobPrioritized.size();

        for (int i = 0; i < jobSize; i++) {
            mapJobToResource(jobPrioritized.poll(), resourcesPrioritized);
        }
        
        for (int i = 0; i < allocationMapping.getAllocationList().size(); i++) {
            Allocation allocation = allocationMapping.getAllocationList().get(i);
            
            System.out.println("Allocation " +(i+1) + " -> Job Name ::-> " + allocation.getJob() + ", Job Priority  ::-> [ "+allocation.getJob().getPriority() +" ] - " + allocation.getResource());
        }
    }

    private PriorityQueue<Job> prioritizeJobs() {
        //Collections.sort(jobs, new JobComparator());
        PriorityQueue<Job> priorityQueue = new PriorityQueue<>();
        this.jobs.stream().forEach((job) -> {
            priorityQueue.offer(job);
        });
        return priorityQueue;
    }


    private PriorityQueue<Resource> prioritizeResource() {
        PriorityQueue<Resource> priorityQueue = new PriorityQueue<>();
        this.resources.stream().forEach((resource) -> {
            priorityQueue.offer(resource);
        });
        return priorityQueue;
    }

    private void mapJobToResource(Job job, PriorityQueue<Resource> resourcesPrioritized) {
        if(resourcesPrioritized.isEmpty()) {
            resourcesPrioritized = prioritizeResource();
        }
        allocationMapping.addIntoAllocation(new Allocation(job, resourcesPrioritized.poll()));
    }

    public class JobResourceAllocationMapping {

        private List<Allocation> allocationList = new ArrayList<>();

        public void addIntoAllocation(Allocation allocation) {
            this.allocationList.add(allocation);
        }

        public List<Allocation> getAllocationList() {
            return allocationList;
        }
    }

    public class Allocation {

        private Job job;
        private Resource resource;

        public Allocation(Job job, Resource resource) {
            this.job = job;
            this.resource = resource;
        }

        public Job getJob() {
            return job;
        }

        public Resource getResource() {
            return resource;
        }
    }
}
