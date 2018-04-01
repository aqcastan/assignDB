
public class BeeDemo {
    public static void main(String[] args) {
        Bee bee = new Berzerker(new WarriorBee());
        Bee bee2 = new Builder(new WorkerBee());
        System.out.println("Attack = " + bee.boost());
        System.out.println("Productivity = " + bee2.boost());
    }
}
