/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gridcomputingsystem.model;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Filippo-TheAppExpert
 */
public class Machine {

    private String name;
    private int machineId;
    private HashMap<Integer, Integer> mipsRating;

    public Machine(int machineId, String name, Random random, boolean shouldGenerate) {
        this.machineId = machineId;
        this.name = name;
        this.mipsRating = new HashMap<>();
        if (shouldGenerate) {
            generateRandomMachineValues(random);
        }
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
     * @return the machineId
     */
    public int getMachineId() {
        return machineId;
    }

    /**
     * @param machineId the machineId to set
     */
    public void setMachineId(int machineId) {
        this.machineId = machineId;
    }

    /**
     * @return the mipsRating
     */
    public HashMap<Integer, Integer> getMipsRating() {
        return mipsRating;
    }

    /**
     * @param mipsRating the mipsRating to set
     */
    public void setMipsRating(HashMap<Integer, Integer> mipsRating) {
        this.mipsRating = mipsRating;
    }

    /**
     * This method is used to generate random machine values
     *
     * @param random
     */
    private void generateRandomMachineValues(Random random) {
        int total = random.nextInt(21 - 2) + 2;
        for (int i = 0; i < total; i++) {
            this.getMipsRating().put(i, random.nextInt(51));
        }
    }

    @Override
    public String toString() {
        return this.name;
    }
}
