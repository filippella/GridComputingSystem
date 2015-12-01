/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.dao.impl;

import gridcomputingsystem.dao.ItemDAO;
import gridcomputingsystem.model.Job;
import gridcomputingsystem.model.Machine;
import gridcomputingsystem.model.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class ResourceSchedulerBroker {

    private GridInformationServiceDB<Resource> resourceDB;
    private final ItemDAO.ItemType type = ItemDAO.ItemType.RESOURCE;

    public ResourceSchedulerBroker() {
        this.resourceDB = new GridInformationServiceDB<>();
    }

    public void addItem(Resource item) {
        this.resourceDB.addItem(item);
    }

    public void removeItem(Resource item) {
        this.resourceDB.removeItem(item);
    }

    public List<Resource> getAllItems() {
        return this.resourceDB.getAllItems(this.type);
    }

    public void updateItem(Resource item) {
        this.resourceDB.updateItem(item);
    }

    public boolean searchItem(String keyword) {
        return this.resourceDB.searchItem(this.type, keyword);
    }

    public void emptyItems() {
        this.resourceDB.emptyItems(this.type);
    }

    protected String generateCode(String indent) {
        String code = "\n" + indent + "LinkedList Weekends = new LinkedList();";
        code += "\n" + indent + "Weekends.add(new Integer(Calendar.SATURDAY));";
        code += "\n" + indent + "Weekends.add(new Integer(Calendar.SUNDAY));";
        code += "\n" + indent + "LinkedList Holidays = new LinkedList();";
        code += "\n" + indent + "PEList peList;";
        code += "\n" + indent + "MachineList mList;";
        code += "\n" + indent + "ResourceCharacteristics resConfig;";
        code += "\n" + indent + "GridResource gridRes;";
        code += "\n";

        List<Resource> allItems = getAllItems();

        Vector vector = this.getAllResourceName(allItems);
        Object[] array = vector.toArray();
        code += "\n" + indent + "String[] resourceNameList = { ";

        for (int n = 0; n < array.length; n++) {
            if (n % 3 == 0) {
                code += "\n" + indent + indent + indent;
            }

            code += "\"" + array[n] + "\",  ";
        }

        code += "\n" + indent + "};";  // closing bracket for the array

        // loop to generate each individual resource property code
        for (int i = 0; i < allItems.size(); i++) {
            Resource resource = allItems.get(i);
            int id = i + 1;
            code += generateMachineCode(id, resource, indent);
        }

        return code;
    }

    private String generateMachineCode(int id, Resource resource, String indent) {
        String archName = "\"" + resource.getArchitecture() + "\"";
        String osName = "\"" + resource.getOperatingSystem() + "\"";
        String resName = "\"" + resource.getName().replace(" ", "") + "\"";
        double price = new Random().nextDouble() * 10;

        String code = "";
        code += "\n" + indent + "///////// Create " + resource.getName();
        code += "\n" + indent + "mList = new MachineList();";

        List<Machine> machines = resource.getMachines();

        for (int i = 0; i < machines.size(); i++) {
            Machine machine = machines.get(i);
            code += generateMachinePropertyCode(machine, indent);
        }

        code += "\n" + indent + "resConfig = new ResourceCharacteristics(";
        code += archName + ", " + osName + ", mList, " + resource.getAllocationPolicyNumerically() + ", ";
        code += resource.getTimezone() + ", " + price + ");";

        code += "\n" + indent + "gridRes = new GridResource(" + resName;
        code += ", " + resource.getBaudRate() + ", seed*(" + id + "+1)+1, resConfig, ";
        code += resource.getPeakLoad() + ", " + resource.getOffPeakLoad() + ", " + resource.getHolidayLoad();
        code += ", Weekends, Holidays);";
        code += "\n";

        return code;
    }

    private String generateMachinePropertyCode(Machine machine, String indent) {
        String code = "\n" + indent + "peList = new PEList();";
        Integer obj = null;

        HashMap<Integer, Integer> mipsRating = machine.getMipsRating();

        for (int i = 0; i < mipsRating.size(); i++) {
            obj = mipsRating.get(i);

            code += "\n" + indent + "peList.add(new PE(" + i + ", ";
            code += obj + "));";
        }

        // TODO: this is wrong place to put
        //code += "\n\n" + indent + "mList = new MachineList();";
        code += "\n" + indent + "mList.add(new Machine(" + machine.getMachineId() + ", peList));\n";
        code += "\n";

        return code;
    }

    private Vector getAllResourceName(List<Resource> allItems) {
        Vector name = new Vector();
        String str;
        for (int i = 0; i < allItems.size(); i++) {
            str = allItems.get(i).getName();
            name.add(str);
        }
        return name;
    }
}
