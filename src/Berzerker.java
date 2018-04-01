
public class Berzerker extends Species{
    
 
    public Berzerker(Bee bee) {
        super(bee);
        this.bee = bee;
    }
    
    @Override
    public int boost() {
        super.boost();
        return attackBoost();
    }

    @Override
    public void rest() {
        // TODO Auto-generated method stub
    
    }

    @Override
    public void idle() {
        // TODO Auto-generated method stub
    
    }
    private int attackBoost() {
        return 10;
    }

   
}
