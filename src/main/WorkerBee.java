package main;

import java.util.ArrayList;

public class WorkerBee extends Bee {

    private int productivity;
    private int speed;

    public WorkerBee() {
        productivity = 5;
        speed = 5;
    }
    
    @Override
    public ArrayList<String> getSpecies() {
        //if ()
        return null;
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
