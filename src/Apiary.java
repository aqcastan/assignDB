import java.util.ArrayList;

public class Apiary {

    Apiary apiary = null;
    ArrayList<Beehive> beehives;
    
    private Apiary() {
        beehives = new ArrayList<Beehive>();
    }
    
    /**
     * Singleton design pattern for Apiary
     * @return
     */
    public Apiary getApiary() {
        if (apiary != null) {
            return apiary;
        }
        return new Apiary();
    }    
}
