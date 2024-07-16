package Package;

public abstract class Player extends Person {
    public Player() {

    }

    public Player(int age, String name) {
        super(age, name);
    }
    public abstract void learn();
}
