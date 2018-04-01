package main;

public class WorkerBee extends Bee {

    private int energy;
    private int maxEnergy;
    private Beehive beehive;

    public WorkerBee(Beehive beehive) {
        this.beehive = beehive;
        this.energy = 10;
        this.maxEnergy = 10;
    }

    /**
     * Does nothing.
     * @return  true. Always
     */
    public boolean Idle() {
        return true;
    }

    /**
     * Gain all energy
     * @return true if able to gain energy, false otherwise
     */
    public boolean Rest() {
        if (energy < maxEnergy){
            energy = maxEnergy;
            return true;
        }
        return false;
    }
    
    /**
     * Gain energy using no resources
     * @return true if able to gain energy, false otherwie
     */
    public boolean RestWithoutResources() {
        if (energy < maxEnergy) {
            energy++;
            return true;
        }
        return false;
    }

    /**
     * Spend energy to harvest
     * @return  true is there was energy to harvest with, false otherwise
     */
    public boolean Harvest() {
        if (energy > 0){
            energy--;
            return true;
        }
        return false;
    }

    /**
     * Spend energy to build
     * @return  true if there was energy to build with, false otherwise
     */
    public boolean Build() {
        if (energy > 0){
            energy--;
            return true;
        }
        return false;
    }
    
    /**
     * Getter for energy available
     * @return amount of energy available
     */
    public int getEnergy() {
        return energy;
    }

}
