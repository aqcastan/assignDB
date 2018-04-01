
public class Builder extends Species{
    
    public Builder(Bee bee) {
        super(bee);
    }
    
    @Override
    public int boost() {
        super.boost();
        return productivityBoost();
    }

    @Override
    public void rest() {
             
    }

    @Override
    public void idle() {
        
    }
    
    private int productivityBoost() {
        return 15;
    }
  
}
