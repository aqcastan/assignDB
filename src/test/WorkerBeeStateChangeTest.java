package test;

import java.util.Scanner;

import main.Beehive;
import main.WorkerBee;

public class WorkerBeeStateChangeTest {
    
    /**
     * Manually test worker bee states
     * @param args
     */
    public static void main(String[] args) {
        Beehive beehive = new Beehive();
        Scanner keyboard = new Scanner(System.in);
        
        for (int i = 0; i <10; i++) beehive.spawnWorkerBeeTest();
        String in = keyboard.nextLine();
        while (!in.equals("x")) {
            beehive.updateBeehiveWorkers();
            in = keyboard.nextLine();
        }
        keyboard.close();
    }

}
