package main;

public class WorkerBeeRestState implements WorkerBeeState {

    @Override
    public void doAction(WorkerBeeContext context) {
        System.out.println("Worker bee is resting");
        context.setState(this); 
    }
    
    public String toString(){
        return "Resting";
     }
}
