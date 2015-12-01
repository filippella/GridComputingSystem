/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class Resource implements Comparable<Resource> {

    private String resourceId;
    private int priority, allocationPolicyNumerically;
    private String name, architecture, operatingSystem, allocationPolicy;
    private double baudRate, peakLoad, offPeakLoad, holidayLoad, timezone, gridApplicationOperation, deadline;
    private List<Machine> machines = new ArrayList<>();

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the architecture
     */
    public String getArchitecture() {
        return architecture;
    }

    /**
     * @param architecture the architecture to set
     */
    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

    /**
     * @return the operatingSystem
     */
    public String getOperatingSystem() {
        return operatingSystem;
    }

    /**
     * @param operatingSystem the operatingSystem to set
     */
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    /**
     * @return the allocationPolicy
     */
    public String getAllocationPolicy() {
        return allocationPolicy;
    }

    /**
     * @param allocationPolicy the allocationPolicy to set
     */
    public void setAllocationPolicy(String allocationPolicy) {
        this.allocationPolicy = allocationPolicy;
    }

    /**
     * @return the baudRate
     */
    public double getBaudRate() {
        return baudRate;
    }

    /**
     * @param baudRate the baudRate to set
     */
    public void setBaudRate(double baudRate) {
        this.baudRate = baudRate;
    }

    /**
     * @return the peakLoad
     */
    public double getPeakLoad() {
        return peakLoad;
    }

    /**
     * @param peakLoad the peakLoad to set
     */
    public void setPeakLoad(double peakLoad) {
        this.peakLoad = peakLoad;
    }

    /**
     * @return the offPeakLoad
     */
    public double getOffPeakLoad() {
        return offPeakLoad;
    }

    /**
     * @param offPeakLoad the offPeakLoad to set
     */
    public void setOffPeakLoad(double offPeakLoad) {
        this.offPeakLoad = offPeakLoad;
    }

    /**
     * @return the holidayLoad
     */
    public double getHolidayLoad() {
        return holidayLoad;
    }

    /**
     * @param holidayLoad the holidayLoad to set
     */
    public void setHolidayLoad(double holidayLoad) {
        this.holidayLoad = holidayLoad;
    }

    /**
     * @return the timezone
     */
    public double getTimezone() {
        return timezone;
    }

    /**
     * @param timezone the timezone to set
     */
    public void setTimezone(double timezone) {
        this.timezone = timezone;
    }

    /**
     * @return the gridApplicationOperation
     */
    public double getGridApplicationOperation() {
        return gridApplicationOperation;
    }

    /**
     * @param gridApplicationOperation the gridApplicationOperation to set
     */
    public void setGridApplicationOperation(double gridApplicationOperation) {
        this.gridApplicationOperation = gridApplicationOperation;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * @return the machines
     */
    public List<Machine> getMachines() {
        return machines;
    }

    /**
     * @param machines the machines to set
     */
    public void setMachines(List<Machine> machines) {
        this.machines = machines;
    }

    /**
     * @return the resourceId
     */
    public String getResourceId() {
        return resourceId;
    }

    /**
     * @param resourceId the resourceId to set
     */
    public void setResourceId(String resourceId) {
        this.resourceId = resourceId;
    }

    /**
     * @return the priority
     */
    public int getPriority() {
        return priority;
    }

    /**
     * @param priority the priority to set
     */
    public void setPriority(int priority) {
        this.priority = priority;
    }

    /**
     * @return the deadline
     */
    public double getDeadline() {
        return deadline;
    }

    /**
     * @param deadline the deadline to set
     */
    public void setDeadline(double deadline) {
        this.deadline = deadline;
    }

    /**
     * @return the allocationPolicyNumerically
     */
    public int getAllocationPolicyNumerically() {
        return allocationPolicyNumerically;
    }

    /**
     * @param allocationPolicyNumerically the allocationPolicyNumerically to set
     */
    public void setAllocationPolicyNumerically(int allocationPolicyNumerically) {
        this.allocationPolicyNumerically = allocationPolicyNumerically;
    }

    @Override
    public int compareTo(Resource o) {
        if (this.getMachines().size() == o.getMachines().size() || this.getGridApplicationOperation() == o.getGridApplicationOperation()) {
            return 0;
        } else if (this.getMachines().size() > o.getMachines().size() || this.getGridApplicationOperation() > o.getGridApplicationOperation()) {
            return -1;
        } else {
            return 1;
        }
    }
}
