
public class WorkerBee extends QueenBee{
    private int productivity;
    private int speed;
    public WorkerBee() {
        productivity = 5;
        speed = 5;
    }
    
    public int getProductivity() {
        return productivity;
    }
    
    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }
    
    public int getSpeed() {
        return speed;
    }
    
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
