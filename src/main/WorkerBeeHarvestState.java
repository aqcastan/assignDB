package main;

public class WorkerBeeHarvestState implements WorkerBeeState {

    public void doAction(WorkerBeeContext context) {
        System.out.println("Worker bee is harvesting");
        context.setState(this);
    }
    
    public String toString(){
        return "Harvesting";
     }

}
