package main;

public class WorkerBeeBuildState implements WorkerBeeState {

    @Override
    public void doAction(WorkerBeeContext context) {
        System.out.println("Worker bee is building");
        context.setState(this);
    }
    
    public String toString(){
        return "Building";
     }

}
