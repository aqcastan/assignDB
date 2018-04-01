package main;
import java.util.ArrayList;

import main.Hive.HiveBuilder;

public class Beehive {

    private int resources;
    private ArrayList<Hive> hives;
    private ArrayList<WorkerBee> workerBees;
    HiveBuilder hiveBuilder;
    
    public Beehive() {
        hives = new ArrayList<Hive>();
        workerBees = new ArrayList<WorkerBee>();
        hiveBuilder = new Hive.HiveBuilder(10, 10).setBuilt(true);
        
        hives.add(hiveBuilder.build());
        hiveBuilder.setBuilt(false);
        resources = 0;
    }    
    
    /**
     * Updates all workers. Priority for workers goes building, harvesting, resting, idling
     * This should only be run once per tick.
     * Also adds a hive to be constructed if there are no hives under construction
     */
    public void updateBeehiveWorkers() {
        int hiveSpace = hives.size() * 10;  //See how much room there is to rest
        if (!hives.get(hives.size()-1).isBuilt()){
            hiveSpace -= 10;  //Remove ten spaces if the last hive is not done being built
        } else {
            hives.add(hiveBuilder.build());
        }
        System.out.println("Beehive has " + hiveSpace + " hivespace");
        System.out.println("Beehive has " + resources + " resources");
        
        for (int i = 0; i < workerBees.size(); i++) {
            WorkerBee wb = workerBees.get(i);
            System.out.println("Bee " + i);
            if (wb.getEnergy() == 0) {  //Make the bee rest if it has no energy.
                System.out.println("I am tired");
                if (resources > 0) {
                    System.out.println("There's stuff for me to rest with");
                    if (hiveSpace > 0) {
                        wb.Rest();
                        System.out.println("Resting, Energy: " + wb.getEnergy());
                        resources--;
                        continue;
                    }
                } else {
                    System.out.println("There's no stuff for me to rest with");
                    if (hiveSpace > 0) {
                        wb.RestWithoutResources();
                        System.out.println("Resting, Energy: " + wb.getEnergy());
                        continue;
                    }
                }
            }
            
            if (resources < workerBees.size()) {    //Harvest resources until there are at least as many resources as worker bees
                if (wb.Harvest()) { 
                    System.out.println("Harvesting, Energy: " + wb.getEnergy());
                    addResource();
                    continue;
                }
            }
            
            if (hives.get(hives.size()-1).isBuilt()) hives.add(hiveBuilder.build()); //Add new hive for construction if needed
            if (!hives.get(hives.size()-1).enoughResources()) addConstructionWork();    //Add resource to hive
            if (addTickWork() && wb.Build()) {  //Do construction work
                System.out.println("Building hive, Energy: " + wb.getEnergy());
                continue;
            }
            
            
            
            wb.Idle();
            System.out.println("Idling, Energy: " + wb.getEnergy());
        }
    }
    
    /**
     * Increments the resources for this hive by 1. 
     */
    public void addResource() {
        resources++;
        System.out.println("Beehive now has " + resources + " resources");
    }
    
    /**
     * Decrements the resources for this hive by 1
     */
    public void subtractResouces() {
        resources--;
        System.out.println("Beehive now has " + resources + " resources");
    }
    
    /**
     * Allocates a resource to hive construction if possible
     * @return true if successful, false otherwise
     */
    private boolean addConstructionWork() {
        if (hives.get(hives.size() - 1).addResource()) {
            resources--;
            return true;
        }
        return false;
    }
    
    
    /**
     * Allocates a tick of work to hive construction if possible
     * @return true if successful, false otherwise
     */
    private boolean addTickWork() {
        if (hives.get(hives.size() - 1).addTick()) {
            return true; 
        }
        return false;
    }
    
    /**
     * Queues a new hive for construction
     * @return true if new hive is queued, false otherwise
     */
    public void addHiveConstuctionJob() {
        if (hives.get(hives.size()-1).isBuilt()){
            hives.add(hiveBuilder.build());
        }
    }

    /**
     * Spawn a worker bee for testing purposes
     * @return
     */
    public WorkerBee spawnWorkerBeeTest() {
        WorkerBee wb = new WorkerBee(this);
        workerBees.add(wb);
        return wb;
    }
    
    /**
     * Getter for resources
     * @return  Number of resources available for use
     */
    public int getResources() {
        return resources;
    }
}
