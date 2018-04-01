
public abstract class Species implements Bee {
    protected Bee bee;
    
    public Species(Bee bee) {
        this.bee = bee;
    }
    
    public int boost() {
        return bee.boost();
    }
}
