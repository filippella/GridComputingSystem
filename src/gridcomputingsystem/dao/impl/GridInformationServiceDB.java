/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.dao.impl;

import gridcomputingsystem.dao.ItemDAO;
import gridcomputingsystem.model.Job;
import gridcomputingsystem.model.Resource;
import gridcomputingsystem.model.utilities.Constants;
import static gridcomputingsystem.model.utilities.Constants.Job.*;
import static gridcomputingsystem.model.utilities.Constants.Resource.*;
import static gridcomputingsystem.model.utilities.Constants.Resource.Machine.*;
import static gridcomputingsystem.model.utilities.Constants.Resource.Machine.MachineProperty.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author Filippo-TheAppExpert
 * @param <T>
 */
public class GridInformationServiceDB<T> implements ItemDAO<T> {

    private Connection connection;
    private Statement stmt;
    private PreparedStatement preparedStatement;

    public GridInformationServiceDB() {
        openConnection();
    }

    /**
     * This method is used to open the connection of the database based on the
     * credentials configured in {@link Constants} class
     */
    private void openConnection() {
        try {
            Class.forName(Constants.JDBC_DRIVER);
            connection = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USERNAME, Constants.DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
        }
        createTable();
    }

    /**
     * This method creates the tables needed to store all the information that
     * user generates through new item creation button clicks
     */
    private void createTable() {
        try {
            stmt = connection.createStatement();
            stmt.execute(CREATE_JOB_TABLE);
            stmt.execute(CREATE_RESOURCES_TABLE);
            stmt.execute(CREATE_MACHINE_TABLE);
            stmt.execute(CREATE_MACHINE_PROPERTY_TABLE);
        } catch (SQLException ex) {
        }
    }

    @Override
    public void addItem(T item) {
        if (item instanceof Job) {
            Job job = (Job) item;
            saveJob(job);
        } else if (item instanceof Resource) {
            Resource resource = (Resource) item;
            saveResource(resource);
        }
    }

    @Override
    public void removeItem(T item) {
        if (item instanceof Job) {
            Job job = (Job) item;
            try {
                String sql = "DELETE FROM " + JOB + "  where " + JOB_ID + " =  '" + job.getJobId() + "'";
                stmt.execute(sql);
            } catch (SQLException ex) {
                System.err.println("Error -> " + ex.getMessage());
            }
        } else if (item instanceof Resource) {
            Resource resource = (Resource) item;
            try {
                String sql = "DELETE FROM " + RESOURCE + "  where " + RESOURCE_ID + " =  '" + resource.getResourceId() + "'";
                stmt.execute(sql);
            } catch (SQLException ex) {
                System.err.println("Error -> " + ex.getMessage());
            }
        }
    }

    @Override
    public List<T> getAllItems(ItemType type) {
        switch (type) {
            case JOB:
                return getSavedJobs();
            case RESOURCE:
                return getSavedResources();
        }
        return null;
    }

    @Override
    public void updateItem(T item) {
        if (item instanceof Job) {
            Job job = (Job) item;
            try {
                String sql = "UPDATE " + JOB + " set job_deadline = '" + item.toString() + "', job_priority = '" + item.toString() + "' where " + JOB_ID + " =  '" + job.getJobId() + "'";
                stmt.execute(sql);
            } catch (SQLException ex) {
                System.err.println("Error -> " + ex.getMessage());
            }
        } else if (item instanceof Resource) {
            Resource resource = (Resource) item;
            try {
                String sql = "UPDATE " + RESOURCE + " set job_deadline = '" + item.toString() + "', job_priority = '" + item.toString() + "' where " + RESOURCE_ID + " =  '" + resource.getResourceId() + "'";
                stmt.execute(sql);
            } catch (SQLException ex) {
                System.err.println("Error -> " + ex.getMessage());
            }
        }
    }

    @Override
    public void emptyItems(ItemType type) {
        switch (type) {
            case JOB:
                emptyJobTable();
                break;
            case RESOURCE:
                emptyResourceTable();
                break;
            default:
                System.err.println("Invalid type!");
        }
    }

    @Override
    public boolean searchItem(ItemType type, String keyword) {
        switch (type) {
            case JOB:
                return searchFromJobs(keyword);
            case RESOURCE:
                return searchFromResources(keyword);
            default:
                return false;
        }
    }

    /**
     * This method is responsible to retrieve all the values from database and
     * assign into an {@link ArrayList<T>} object which T stands for {@link Job}
     * or {@link Resource}
     *
     * @return in this case {@link ArrayList<T>} of an object T {@link Job}
     */
    private List<T> getSavedJobs() {
        ArrayList<T> items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + JOB;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Job job = new Job();
                job.setJobId(rs.getString(1));
                job.setName(rs.getString(2));
                job.setDeadline(Double.parseDouble(rs.getString(3)));
                job.setPriority(Integer.parseInt(rs.getString(4)));
                job.setBudget(Double.parseDouble(rs.getString(5)));
                String schedulingStrategy = rs.getString(6);
                job.setSchedulingStrategy(schedulingStrategy);

                switch (schedulingStrategy) {
                    case "No Optimisation":
                        job.setSchedulingStrategyNumber(0);
                        break;
                    case "Optimise Cost":
                        job.setSchedulingStrategyNumber(1);
                        break;
                    case "Optimise Cost Plus":
                        job.setSchedulingStrategyNumber(2);
                        break;
                    case "Optimise Cost and Time":
                        job.setSchedulingStrategyNumber(3);
                        break;
                    default:
                        job.setSchedulingStrategyNumber(4);
                        break;
                }

                String jobApproach = rs.getString(7);
                job.setApproach(jobApproach);

                switch (jobApproach) {
                    case "Factor-Based":
                        job.setApproachNumber(0);
                        break;
                    default:
                        job.setApproachNumber(1);
                        break;
                }

                job.setBaudRate(Double.parseDouble(rs.getString(8)));
                job.setMaxSimulationTimeHour(Double.parseDouble(rs.getString(9)));
                job.setMaxSimulationTimeMinute(Double.parseDouble(rs.getString(10)));
                job.setMaxSimulationTimeSecond(Double.parseDouble(rs.getString(11)));
                job.setSuccessiveExperimentDelaySecond(Double.parseDouble(rs.getString(12)));
                job.setGridletSize(Double.parseDouble(rs.getString(13)));
                job.setGridletMinDeviation(Double.parseDouble(rs.getString(14)));
                job.setGridletMaxDeviation(Double.parseDouble(rs.getString(15)));
                job.setLengthSize(Double.parseDouble(rs.getString(16)));
                job.setLengthMinDeviation(Double.parseDouble(rs.getString(17)));
                job.setLengthMaxDeviation(Double.parseDouble(rs.getString(18)));
                job.setFileSize(Double.parseDouble(rs.getString(19)));
                job.setFileMinDeviation(Double.parseDouble(rs.getString(20)));
                job.setFileMaxDeviation(Double.parseDouble(rs.getString(21)));
                job.setOutputSize(Double.parseDouble(rs.getString(22)));
                job.setOutputMinDeviation(Double.parseDouble(rs.getString(23)));
                job.setOutputMaxDeviation(Double.parseDouble(rs.getString(24)));
                items.add((T) job);
            }
        } catch (SQLException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }
        return items;
    }

    /**
     * This method is responsible to iterate through the list of saved records
     * of resource from the database
     *
     * @return {@link List<T>} which T stands for an object of {@link Resource}
     */
    private List<T> getSavedResources() {
        ArrayList<T> items = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + RESOURCE;
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Resource resource = new Resource();
                String resourceId = rs.getString(1);
                resource.setResourceId(resourceId);
                resource.setDeadline(Double.parseDouble("50"));
                resource.setPriority(resource.getPriority());
                resource.setName(rs.getString(4));
                resource.setArchitecture(rs.getString(5));
                resource.setOperatingSystem(rs.getString(6));

                String allocationPolicy = rs.getString(7);
                resource.setAllocationPolicy(allocationPolicy);
                if ("Time-Shared".equals(allocationPolicy)) {
                    resource.setAllocationPolicyNumerically(0);
                } else {
                    resource.setAllocationPolicyNumerically(1);
                }
                resource.setBaudRate(Double.parseDouble(rs.getString(8)));
                resource.setPeakLoad(Double.parseDouble(rs.getString(9)));
                resource.setOffPeakLoad(Double.parseDouble(rs.getString(10)));
                resource.setHolidayLoad(Double.parseDouble(rs.getString(11)));
                resource.setTimezone(Double.parseDouble(rs.getString(12)));
                resource.setGridApplicationOperation(Double.parseDouble(rs.getString(13)));

                resource.setMachines(getMachines(resourceId));

                items.add((T) resource);
            }
        } catch (SQLException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }
        return items;
    }

    /**
     * This method is responsible for getting the list of saved machines based
     * on a specific resource Id
     *
     * @param resourceId
     * @return {@link List<>} {@link gridcomputingsystem.model.Machine}
     */
    private List<gridcomputingsystem.model.Machine> getMachines(String resourceId) {
        List<gridcomputingsystem.model.Machine> machines = new ArrayList<>();
        try {
            String sql = "SELECT * FROM " + MACHINE + " where " + RESOURCE_ID + " = '" + resourceId + "'";
            Statement machineStatemet = connection.createStatement();
            ResultSet rs = machineStatemet.executeQuery(sql);

            while (rs.next()) {
                Integer machineId = Integer.parseInt(rs.getString(1));
                String machineName = rs.getString(3);
                gridcomputingsystem.model.Machine machine = new gridcomputingsystem.model.Machine(machineId, machineName, null, false);
                machine.setMipsRating(getMachineProperties(machineId, resourceId));
                machines.add(machine);
            }
        } catch (SQLException ex) {
            System.err.println("Error1 -> " + ex.getMessage());
        }
        return machines;
    }

    /**
     * This method takes machine Id and resource Id and provides machine
     * property information saved from database
     *
     * @param machineId the actual machine Id
     * @param resourceId the actual resource Id
     *
     * @return {@link HashMap<Integer, Integer>}
     */
    private HashMap<Integer, Integer> getMachineProperties(Integer machineId, String resourceId) {
        HashMap<Integer, Integer> machineProperties = new HashMap<>();
        try {
            String sql = "SELECT * FROM " + MACHINE_PROPERTY + " where " + MACHINE_ID + " = " + machineId + " and " + RESOURCE_ID + " = '" + resourceId + "'";
            Statement machinePropertyStatemet = connection.createStatement();
            ResultSet rs = machinePropertyStatemet.executeQuery(sql);

            while (rs.next()) {
                Integer peId = Integer.parseInt(rs.getString(3));
                Integer mipsRating = Integer.parseInt(rs.getString(4));
                machineProperties.put(peId, mipsRating);
            }
        } catch (SQLException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }
        return machineProperties;
    }

    /**
     * This method is used to search a job item from the database based on a
     * given keyword
     *
     * @param keyword
     * @return true if a job content with the specified keyword matches
     */
    private boolean searchFromJobs(String keyword) {
        try {
            String sql = "SELECT * FROM " + JOB + " WHERE " + JOB_ID + " = '" + keyword + "' or " + JOB_NAME + " = '" + keyword + "'";
            ResultSet rs = stmt.executeQuery(sql);
            int size = 0;
            if (rs != null) {
                rs.beforeFirst();
                rs.last();
                size = rs.getRow();
            }
            return size > 0;
        } catch (SQLException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }
        return false;
    }

    private boolean searchFromResources(String keyword) {
        return true;
    }

    /**
     * This method is used to delete all the entries of the jobs table from the
     * database
     */
    private void emptyJobTable() {
        try {
            String sql = "TRUNCATE TABLE " + JOB;
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }
    }

    /**
     * This method is used to delete all the entries of the resources table from
     * the database
     */
    private void emptyResourceTable() {
        try {
            String sql = "TRUNCATE TABLE " + RESOURCE;
            stmt.execute(sql);
        } catch (SQLException ex) {
            System.err.println("Error -> " + ex.getMessage());
        }
    }

    /**
     * This method takes a job object and saves it into the database
     *
     * @param job the job to be saved inside the database
     */
    private void saveJob(Job job) {
        try {
            this.preparedStatement = this.connection.prepareCall(Constants.Job.INSERT_JOB_PREPARED_STATEMENT);
            this.preparedStatement.setString(1, job.getJobId());
            this.preparedStatement.setString(2, job.getName());
            this.preparedStatement.setString(3, Double.toString(job.getDeadline()));
            this.preparedStatement.setString(4, Integer.toString(job.getPriority()));
            this.preparedStatement.setString(5, Double.toString(job.getBudget()));
            this.preparedStatement.setString(6, job.getSchedulingStrategy());
            this.preparedStatement.setString(7, job.getApproach());
            this.preparedStatement.setString(8, Double.toString(job.getBaudRate()));
            this.preparedStatement.setString(9, Double.toString(job.getMaxSimulationTimeHour()));
            this.preparedStatement.setString(10, Double.toString(job.getMaxSimulationTimeMinute()));
            this.preparedStatement.setString(11, Double.toString(job.getMaxSimulationTimeSecond()));
            this.preparedStatement.setString(12, Double.toString(job.getSuccessiveExperimentDelaySecond()));
            this.preparedStatement.setString(13, Double.toString(job.getGridletSize()));
            this.preparedStatement.setString(14, Double.toString(job.getGridletMinDeviation()));
            this.preparedStatement.setString(15, Double.toString(job.getGridletMaxDeviation()));
            this.preparedStatement.setString(16, Double.toString(job.getLengthSize()));
            this.preparedStatement.setString(17, Double.toString(job.getLengthMinDeviation()));
            this.preparedStatement.setString(18, Double.toString(job.getLengthMaxDeviation()));
            this.preparedStatement.setString(19, Double.toString(job.getFileSize()));
            this.preparedStatement.setString(20, Double.toString(job.getFileMinDeviation()));
            this.preparedStatement.setString(21, Double.toString(job.getFileMaxDeviation()));
            this.preparedStatement.setString(22, Double.toString(job.getOutputSize()));
            this.preparedStatement.setString(23, Double.toString(job.getOutputMinDeviation()));
            this.preparedStatement.setString(24, Double.toString(job.getOutputMaxDeviation()));
            this.preparedStatement.executeUpdate();
            System.out.println("Job saved successfully to Database.");
        } catch (SQLException ex) {
            System.err.println("Error in saving job with id -> " + ex.getMessage());
        }
    }

    /**
     * This method takes a resource object and stores it into the database
     *
     * @param resource the resource to be saved into the database
     */
    private void saveResource(Resource resource) {
        String resourceId = resource.getResourceId();
        try {
            this.preparedStatement = this.connection.prepareCall(Constants.Resource.INSERT_RESOURCE_PREPARED_STATEMENT);
            this.preparedStatement.setString(1, resourceId);
            this.preparedStatement.setString(2, "empty deadline resource");
            this.preparedStatement.setString(3, "empty priority resource");
            this.preparedStatement.setString(4, resource.getName());
            this.preparedStatement.setString(5, resource.getArchitecture());
            this.preparedStatement.setString(6, resource.getOperatingSystem());
            this.preparedStatement.setString(7, resource.getAllocationPolicy());
            this.preparedStatement.setString(8, Double.toString(resource.getBaudRate()));
            this.preparedStatement.setString(9, Double.toString(resource.getPeakLoad()));
            this.preparedStatement.setString(10, Double.toString(resource.getOffPeakLoad()));
            this.preparedStatement.setString(11, Double.toString(resource.getHolidayLoad()));
            this.preparedStatement.setString(12, Double.toString(resource.getTimezone()));
            this.preparedStatement.setString(13, Double.toString(resource.getGridApplicationOperation()));
            this.preparedStatement.executeUpdate();

            this.preparedStatement = this.connection.prepareCall(Constants.Resource.Machine.INSERT_RESOURCE_MACHINE_PREPARED_STATEMENT);
            int machineLength = resource.getMachines().size();

            for (int i = 0; i < machineLength; i++) {
                gridcomputingsystem.model.Machine machine = resource.getMachines().get(i);
                this.preparedStatement.setString(1, Integer.toString(machine.getMachineId()));
                this.preparedStatement.setString(2, resource.getResourceId());
                this.preparedStatement.setString(3, machine.getName());
                this.preparedStatement.executeUpdate();

                HashMap<Integer, Integer> mipsRating = machine.getMipsRating();

                for (Map.Entry<Integer, Integer> mips : mipsRating.entrySet()) {
                    PreparedStatement ps = connection.prepareCall(Constants.Resource.Machine.MachineProperty.INSERT_RESOURCE_MACHINE_PROPERTY_PREPARED_STATEMENT);
                    ps.setString(1, Integer.toString(machine.getMachineId()));
                    ps.setString(2, resourceId);
                    ps.setString(3, Integer.toString(mips.getKey()));
                    ps.setString(4, Integer.toString(mips.getValue()));
                    ps.executeUpdate();
                }
            }
            System.out.println("Resource successfully saved into database.");

        } catch (SQLException ex) {
            System.err.println("Error in saving resource into Database -> " + ex.getMessage());
        }
    }
}
