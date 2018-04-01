package main;

public class Hive {

    private int resourcesRequired;  //Amount of resources required to build hive
    private int constructionTickProgress;   //Amount of ticks invested so far
    private int constructionResourceProgress;   //Amount of resources invested so far
    private int ticksPerResource;   //Amount of ticks needed to add resource to hive
    private boolean built;  //Determines whether the hive is built or not.
    
    public Hive() {
        this.resourcesRequired = 10;
        this.constructionTickProgress = 0;
        this.constructionResourceProgress = 0;
        this.ticksPerResource = 10;
        this.built = false;
    }
    
    public Hive(boolean built) {
        this.built = true;
    }
    
    /**
     * Add resource to the construction of this hive. 
     * @return false if no more resources are required, true otherwise
     */
    public boolean addResource() {
        if (constructionResourceProgress == resourcesRequired) {
            return false;
        }
        constructionResourceProgress++;
        return true;
    }
    
    /**
     * Add tick to the construction of this hive
     * @return false if no ticks can be added, true otherwise
     */
    public boolean addTick() {
        if (built == true) {
            return false;   //Already built
        } else if (constructionTickProgress == ticksPerResource * constructionResourceProgress) {
            return false;   //Need to add resources before more work can be done
        }
        constructionTickProgress++;
        System.out.println("Hive construction tick progrsess: " + constructionTickProgress);
        System.out.println("Hive construction resource progrsess: " + constructionResourceProgress);
        if (constructionTickProgress == ticksPerResource * resourcesRequired) {
            built = true;   //Construction finished
        }
        return true;
    }
    
    /**
     * 
     * @return true if the hive is built, false otherwise
     */
    public boolean isBuilt() {
        return built;
    }
    
    /**
     * 
     * @return true if there are enough resources for this hive, false otherwise
     */
    public boolean enoughResources() {
        return resourcesRequired == constructionResourceProgress;
    }
}
