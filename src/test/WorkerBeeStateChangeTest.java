package test;

import java.util.Scanner;

import main.WorkerBeeBuildState;
import main.WorkerBeeContext;
import main.WorkerBeeHarvestState;
import main.WorkerBeeIdleState;
import main.WorkerBeeRestState;

public class WorkerBeeStateChangeTest {
    
    /**
     * Manually test worker bee states
     * @param args
     */
    public static void main(String[] args) {
        WorkerBeeContext wbContext = new WorkerBeeContext();
        WorkerBeeIdleState wbIdle = new WorkerBeeIdleState();
        WorkerBeeRestState wbRest = new WorkerBeeRestState();
        WorkerBeeBuildState wbBuild = new WorkerBeeBuildState();
        WorkerBeeHarvestState wbHarvest = new WorkerBeeHarvestState();
        wbContext.setState(wbIdle);

        Scanner keyboard = new Scanner(System.in);
        System.out.println("enter character");
        String in = keyboard.nextLine();
        char step = in.charAt(0);
        while (step != 'x') {
            switch (step) {
                case 'i':
                    wbIdle.doAction(wbContext); //Set worker bee to idle state
                    break;
                case 'b':
                    wbBuild.doAction(wbContext);    //set worker bee to build state
                    break;
                case 'h':
                    wbHarvest.doAction(wbContext);  //set worker to harvest state
                    break;
                case 'r':
                    wbRest.doAction(wbContext); //set worker to rest state
                    break;
                case 'n':
                    wbContext.getState().doAction(wbContext);;   //Set worker to its current state
                    break;
                default:
                    System.out.println("Choose i, b, h, r, or n");
            }
            in = keyboard.nextLine();
            step = in.charAt(0);                
        }
    }

}
