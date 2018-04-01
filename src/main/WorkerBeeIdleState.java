package main;

public class WorkerBeeIdleState implements WorkerBeeState {

    @Override
    public void doAction(WorkerBeeContext context) {
        System.out.println("Worker bee is idling");
        context.setState(this);      
    }
 
    public String toString(){
        return "Idling";
     }
    
}
