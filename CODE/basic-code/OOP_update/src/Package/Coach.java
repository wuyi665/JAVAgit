package Package;

public abstract class Coach extends Person {
    public Coach() {

    }

    public Coach(int age, String name) {
        super(age, name);
    }
    public abstract void teach();
}
