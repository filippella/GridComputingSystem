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
public class Job implements Comparable<Job> {

    private String jobId;
    private int priority, schedulingStrategyNumber, approachNumber;
    private String name, schedulingStrategy, approach;
    private double baudRate, maxSimulationTimeHour, maxSimulationTimeMinute, maxSimulationTimeSecond,
            successiveExperimentDelaySecond, gridletSize, gridletMinDeviation, gridletMaxDeviation,
            lengthSize, lengthMinDeviation, lengthMaxDeviation, fileSize, fileMinDeviation, fileMaxDeviation,
            outputSize, outputMinDeviation, outputMaxDeviation, budget, deadline;

    /**
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
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
     * @return the schedulingStrategy
     */
    public String getSchedulingStrategy() {
        return schedulingStrategy;
    }

    /**
     * @param schedulingStrategy the schedulingStrategy to set
     */
    public void setSchedulingStrategy(String schedulingStrategy) {
        this.schedulingStrategy = schedulingStrategy;
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
     * @return the maxSimulationTimeHour
     */
    public double getMaxSimulationTimeHour() {
        return maxSimulationTimeHour;
    }

    /**
     * @param maxSimulationTimeHour the maxSimulationTimeHour to set
     */
    public void setMaxSimulationTimeHour(double maxSimulationTimeHour) {
        this.maxSimulationTimeHour = maxSimulationTimeHour;
    }

    /**
     * @return the maxSimulationTimeMinute
     */
    public double getMaxSimulationTimeMinute() {
        return maxSimulationTimeMinute;
    }

    /**
     * @param maxSimulationTimeMinute the maxSimulationTimeMinute to set
     */
    public void setMaxSimulationTimeMinute(double maxSimulationTimeMinute) {
        this.maxSimulationTimeMinute = maxSimulationTimeMinute;
    }

    /**
     * @return the maxSimulationTimeSecond
     */
    public double getMaxSimulationTimeSecond() {
        return maxSimulationTimeSecond;
    }

    /**
     * @param maxSimulationTimeSecond the maxSimulationTimeSecond to set
     */
    public void setMaxSimulationTimeSecond(double maxSimulationTimeSecond) {
        this.maxSimulationTimeSecond = maxSimulationTimeSecond;
    }

    /**
     * @return the successiveExperimentDelaySecond
     */
    public double getSuccessiveExperimentDelaySecond() {
        return successiveExperimentDelaySecond;
    }

    /**
     * @param successiveExperimentDelaySecond the
     * successiveExperimentDelaySecond to set
     */
    public void setSuccessiveExperimentDelaySecond(double successiveExperimentDelaySecond) {
        this.successiveExperimentDelaySecond = successiveExperimentDelaySecond;
    }

    /**
     * @return the gridletSize
     */
    public double getGridletSize() {
        return gridletSize;
    }

    /**
     * @param gridletSize the gridletSize to set
     */
    public void setGridletSize(double gridletSize) {
        this.gridletSize = gridletSize;
    }

    /**
     * @return the gridletMinDeviation
     */
    public double getGridletMinDeviation() {
        return gridletMinDeviation;
    }

    /**
     * @param gridletMinDeviation the gridletMinDeviation to set
     */
    public void setGridletMinDeviation(double gridletMinDeviation) {
        this.gridletMinDeviation = gridletMinDeviation;
    }

    /**
     * @return the gridletMaxDeviation
     */
    public double getGridletMaxDeviation() {
        return gridletMaxDeviation;
    }

    /**
     * @param gridletMaxDeviation the gridletMaxDeviation to set
     */
    public void setGridletMaxDeviation(double gridletMaxDeviation) {
        this.gridletMaxDeviation = gridletMaxDeviation;
    }

    /**
     * @return the lengthSize
     */
    public double getLengthSize() {
        return lengthSize;
    }

    /**
     * @param lengthSize the lengthSize to set
     */
    public void setLengthSize(double lengthSize) {
        this.lengthSize = lengthSize;
    }

    /**
     * @return the lengthMinDeviation
     */
    public double getLengthMinDeviation() {
        return lengthMinDeviation;
    }

    /**
     * @param lengthMinDeviation the lengthMinDeviation to set
     */
    public void setLengthMinDeviation(double lengthMinDeviation) {
        this.lengthMinDeviation = lengthMinDeviation;
    }

    /**
     * @return the lengthMaxDeviation
     */
    public double getLengthMaxDeviation() {
        return lengthMaxDeviation;
    }

    /**
     * @param lengthMaxDeviation the lengthMaxDeviation to set
     */
    public void setLengthMaxDeviation(double lengthMaxDeviation) {
        this.lengthMaxDeviation = lengthMaxDeviation;
    }

    /**
     * @return the fileSize
     */
    public double getFileSize() {
        return fileSize;
    }

    /**
     * @param fileSize the fileSize to set
     */
    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    /**
     * @return the fileMinDeviation
     */
    public double getFileMinDeviation() {
        return fileMinDeviation;
    }

    /**
     * @param fileMinDeviation the fileMinDeviation to set
     */
    public void setFileMinDeviation(double fileMinDeviation) {
        this.fileMinDeviation = fileMinDeviation;
    }

    /**
     * @return the fileMaxDeviation
     */
    public double getFileMaxDeviation() {
        return fileMaxDeviation;
    }

    /**
     * @param fileMaxDeviation the fileMaxDeviation to set
     */
    public void setFileMaxDeviation(double fileMaxDeviation) {
        this.fileMaxDeviation = fileMaxDeviation;
    }

    /**
     * @return the outputSize
     */
    public double getOutputSize() {
        return outputSize;
    }

    /**
     * @param outputSize the outputSize to set
     */
    public void setOutputSize(double outputSize) {
        this.outputSize = outputSize;
    }

    /**
     * @return the outputMinDeviation
     */
    public double getOutputMinDeviation() {
        return outputMinDeviation;
    }

    /**
     * @param outputMinDeviation the outputMinDeviation to set
     */
    public void setOutputMinDeviation(double outputMinDeviation) {
        this.outputMinDeviation = outputMinDeviation;
    }

    /**
     * @return the outputMaxDeviation
     */
    public double getOutputMaxDeviation() {
        return outputMaxDeviation;
    }

    /**
     * @param outputMaxDeviation the outputMaxDeviation to set
     */
    public void setOutputMaxDeviation(double outputMaxDeviation) {
        this.outputMaxDeviation = outputMaxDeviation;
    }

    /**
     * @return the budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }

    /**
     * @return the approach
     */
    public String getApproach() {
        return approach;
    }

    /**
     * @param approach the approach to set
     */
    public void setApproach(String approach) {
        this.approach = approach;
    }

    /**
     * @return the schedulingStrategyNumber
     */
    public int getSchedulingStrategyNumber() {
        return schedulingStrategyNumber;
    }

    /**
     * @param schedulingStrategyNumber the schedulingStrategyNumber to set
     */
    public void setSchedulingStrategyNumber(int schedulingStrategyNumber) {
        this.schedulingStrategyNumber = schedulingStrategyNumber;
    }

    /**
     * @return the approachNumber
     */
    public int getApproachNumber() {
        return approachNumber;
    }

    /**
     * @param approachNumber the approachNumber to set
     */
    public void setApproachNumber(int approachNumber) {
        this.approachNumber = approachNumber;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int compareTo(Job job) {
        if (this.getPriority() == job.getPriority()) {
            return 0;
        } else if (this.getPriority() > job.getPriority()) {
            return -1;
        } else {
            return 1;
        }
    }
}
