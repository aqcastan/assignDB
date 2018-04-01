package main;

public class WorkerBeeContext {

        private WorkerBeeState state;
        
        public WorkerBeeContext() {
            state = null;
        }
        
        public void setState(WorkerBeeState state) {
            System.out.println("Set state");
            this.state = state;
        }
        
        public WorkerBeeState getState() {
            return state;
        }
    
}
