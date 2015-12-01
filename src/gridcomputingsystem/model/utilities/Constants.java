/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.model.utilities;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class Constants {

    public static final String JDBC_DRIVER = "org.h2.Driver";
    public static final String DB_URL = "jdbc:h2:~/computingGridDB";
    public static final String DB_USERNAME = "test";
    public static final String DB_PASSWORD = "test";

    public static class Job {

        public static final String JOB = "job";
        public static final String JOB_ID = "job_id";
        public static final String JOB_NAME = "job_name";
        public static final String JOB_DEADLINE = "job_deadline";
        public static final String JOB_PRIORITY = "job_priority";
        public static final String JOB_BUDGET = "job_budget";
        public static final String JOB_SCHEDULING_STRATEGY = "job_schedulingStrategy";
        public static final String JOB_APPROACH = "job_approach";
        public static final String JOB_BAUD_RATE = "job_baudRate";
        public static final String JOB_SIMULATION_TIME_HOUR = "job_maxSimulationTimeHour";
        public static final String JOB_SIMULATION_TIME_MINUTE = "job_maxSimulationTimeMinute";
        public static final String JOB_SIMULATION_TIME_SECOND = "job_maxSimulationTimeSecond";
        public static final String JOB_SUCCESSIVE_EXPERIMENT_DELAY_SECOND = "job_successiveExperimentDelaySecond";
        public static final String JOB_GRIDLET_SIZE = "job_gridletSize";
        public static final String JOB_GRIDLET_MIN_DEVATION = "job_gridletMinDeviation";
        public static final String JOB_GRIDLET_MAX_DEVIATION = "job_gridletMaxDeviation";
        public static final String JOB_LENGTH_SIZE = "job_lengthSize";
        public static final String JOB_LENGTH_MIN_DEVIATION = "job_lengthMinDeviation";
        public static final String JOB_LENGTH_MAX_DEVIATION = "job_lengthMaxDeviation";
        public static final String JOB_FILE_SIZE = "job_fileSize";
        public static final String JOB_FILE_MIN_DEVIATION = "job_fileMinDeviation";
        public static final String JOB_FILE_MAX_DEVIATION = "job_fileMaxDeviation";
        public static final String JOB_OUTPUT_SIZE = "job_outputSize";
        public static final String JOB_OUTPUT_MIN_DEVIATION = "job_outputMinDeviation";
        public static final String JOB_OUTPUT_MAX_DEVIATION = "job_outputMaxDeviation";

        public static final String CREATE_JOB_TABLE = "CREATE TABLE " + JOB
                + " (" + JOB_ID + "  VARCHAR(255) NOT NULL PRIMARY KEY, "
                + " " + JOB_NAME + " VARCHAR(255) NOT NULL, "
                + " " + JOB_DEADLINE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_PRIORITY + " VARCHAR(255) NOT NULL, "
                + " " + JOB_BUDGET + " VARCHAR(255) NOT NULL, "
                + " " + JOB_SCHEDULING_STRATEGY + " VARCHAR(255) NOT NULL, "
                + " " + JOB_APPROACH + " VARCHAR(255) NOT NULL, "
                + " " + JOB_BAUD_RATE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_SIMULATION_TIME_HOUR + " VARCHAR(255) NOT NULL, "
                + " " + JOB_SIMULATION_TIME_MINUTE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_SIMULATION_TIME_SECOND + " VARCHAR(255) NOT NULL, "
                + " " + JOB_SUCCESSIVE_EXPERIMENT_DELAY_SECOND + " VARCHAR(255) NOT NULL, "
                + " " + JOB_GRIDLET_SIZE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_GRIDLET_MIN_DEVATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_GRIDLET_MAX_DEVIATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_LENGTH_SIZE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_LENGTH_MIN_DEVIATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_LENGTH_MAX_DEVIATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_FILE_SIZE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_FILE_MIN_DEVIATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_FILE_MAX_DEVIATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_OUTPUT_SIZE + " VARCHAR(255) NOT NULL, "
                + " " + JOB_OUTPUT_MIN_DEVIATION + " VARCHAR(255) NOT NULL, "
                + " " + JOB_OUTPUT_MAX_DEVIATION + " VARCHAR(255) NOT NULL)";

        public static final String INSERT_JOB_PREPARED_STATEMENT = "INSERT INTO " + JOB + " (" + JOB_ID + ", " + JOB_NAME + ", " + JOB_DEADLINE + ", " + JOB_PRIORITY
                + ", " + JOB_BUDGET + "," + JOB_SCHEDULING_STRATEGY + "," + JOB_APPROACH
                + "," + JOB_BAUD_RATE + "," + JOB_SIMULATION_TIME_HOUR + "," + JOB_SIMULATION_TIME_MINUTE + ""
                + "," + JOB_SIMULATION_TIME_SECOND + "," + JOB_SUCCESSIVE_EXPERIMENT_DELAY_SECOND + ""
                + "," + JOB_GRIDLET_SIZE + "," + JOB_GRIDLET_MIN_DEVATION + "," + JOB_GRIDLET_MAX_DEVIATION + ""
                + "," + JOB_LENGTH_SIZE + "," + JOB_LENGTH_MIN_DEVIATION + "," + JOB_LENGTH_MAX_DEVIATION + ""
                + "," + JOB_FILE_SIZE + "," + JOB_FILE_MIN_DEVIATION + "," + JOB_FILE_MAX_DEVIATION + ""
                + "," + JOB_OUTPUT_SIZE + "," + JOB_OUTPUT_MIN_DEVIATION + "," + JOB_OUTPUT_MAX_DEVIATION + ") VALUES "
                + " (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    }

    public static class Resource {

        public static final String RESOURCE = "resource";
        public static final String RESOURCE_ID = "resource_id";
        public static final String RESOURCE_DEADLINE = "resource_deadline";
        public static final String RESOURCE_PRIORITY = "resource_priority";
        public static final String RESOURCE_NAME = "resource_name";
        public static final String RESOURCE_ARCHITECTURE = "resource_architecture";
        public static final String RESOURCE_OPERATING_SYSTEM = "resource_operatingSystem";
        public static final String RESOURCE_ALLOCATION_POLICY = "resource_allocationPolicy";
        public static final String RESOURCE_BAUD_RATE = "resource_baudRate";
        public static final String RESOURCE_PEAK_LOAD = "resource_peakLoad";
        public static final String RESOURCE_OFF_PEAK_LOAD = "resource_offPeakLoad";
        public static final String RESOURCE_HOLIDAY_LOAD = "resource_holidayLoad";
        public static final String RESOURCE_TIMEZONE = "resource_timezone";
        public static final String RESOURCE_GRID_APPLICATION_OPERATION = "resource_gridApplicationOperation";

        public static final String CREATE_RESOURCES_TABLE = "CREATE TABLE " + RESOURCE
                + " (" + RESOURCE_ID + " VARCHAR(255) NOT NULL PRIMARY KEY, "
                + " " + RESOURCE_DEADLINE + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_PRIORITY + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_NAME + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_ARCHITECTURE + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_OPERATING_SYSTEM + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_ALLOCATION_POLICY + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_BAUD_RATE + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_PEAK_LOAD + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_OFF_PEAK_LOAD + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_HOLIDAY_LOAD + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_TIMEZONE + " VARCHAR(255) NOT NULL, "
                + " " + RESOURCE_GRID_APPLICATION_OPERATION + " VARCHAR(255) NOT NULL)";

        public static final String INSERT_RESOURCE_PREPARED_STATEMENT = "INSERT INTO " + RESOURCE + " (" + RESOURCE_ID + ""
                + ", " + RESOURCE_DEADLINE + ", " +RESOURCE_PRIORITY + "," + RESOURCE_NAME + ""
                + ", " + RESOURCE_ARCHITECTURE + ", " + RESOURCE_OPERATING_SYSTEM + ""
                + ", " + RESOURCE_ALLOCATION_POLICY + "," + RESOURCE_BAUD_RATE + ""
                + "," + RESOURCE_PEAK_LOAD + "," + RESOURCE_OFF_PEAK_LOAD + "," + RESOURCE_HOLIDAY_LOAD + ""
                + "," + RESOURCE_TIMEZONE + "," + RESOURCE_GRID_APPLICATION_OPERATION + ") VALUES "
                + " (?,?,?,?,?,?,?,?,?,?,?,?,?)";

        public static class Machine {

            public static final String MACHINE = "machine";
            public static final String MACHINE_ID = "machine_id";
            public static final String MACHINE_NAME = "machine_name";

            public static final String CREATE_MACHINE_TABLE = "CREATE TABLE " + MACHINE
                    + " (" + MACHINE_ID + "  VARCHAR(255) NOT NULL, "
                    + " " + RESOURCE_ID + " VARCHAR(255) NOT NULL, "
                    + " " + MACHINE_NAME + " VARCHAR(255) NOT NULL,"
                    + " FOREIGN KEY (" + Resource.RESOURCE_ID + ") REFERENCES " + Resource.RESOURCE + " (" + Resource.RESOURCE_ID + ") ON DELETE CASCADE)";

            public static final String INSERT_RESOURCE_MACHINE_PREPARED_STATEMENT = "INSERT INTO " + MACHINE + " (" + MACHINE_ID + ","
                    + RESOURCE_ID + "," + MACHINE_NAME + ") VALUES  (?,?,?)";

            public static class MachineProperty {

                public static final String MACHINE_PROPERTY = "machine_property";
                public static final String MACHINE_PROPERTY_ID = "machine_property_id";

                public static final String MACHINE_PROPERTY_PE_ID = "machine_property_pe_id";
                public static final String MACHINE_PROPERTY_MIPS_RATING = "machine_property_mips";
                
                public static final String CREATE_MACHINE_PROPERTY_TABLE = "CREATE TABLE " + MACHINE_PROPERTY
                        + " (" + MACHINE_ID + " VARCHAR(255) NOT NULL, "
                        + " " + RESOURCE_ID + " VARCHAR(255) NOT NULL, "
                        + " " + MACHINE_PROPERTY_PE_ID + " VARCHAR(255) NOT NULL, "
                        + " " + MACHINE_PROPERTY_MIPS_RATING + " VARCHAR(255) NOT NULL,"
                        + " FOREIGN KEY (" + RESOURCE_ID + ") REFERENCES " + RESOURCE + " (" + RESOURCE_ID + ") ON DELETE CASCADE)";

                public static final String INSERT_RESOURCE_MACHINE_PROPERTY_PREPARED_STATEMENT = "INSERT INTO " + MACHINE_PROPERTY + " (" + MACHINE_ID + ","
                        + RESOURCE_ID + ","+ MACHINE_PROPERTY_PE_ID + "," + MACHINE_PROPERTY_MIPS_RATING + ") VALUES  (?,?,?,?)";
            }
        }
    }
}
