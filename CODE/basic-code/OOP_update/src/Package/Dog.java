package Package;

public class Dog extends Animal implements Swim{
    public Dog() {}

    public Dog(int age, String name) {
        super(age, name);
    }
    public void eat() {
        System.out.println("吃骨头");
    }

    @Override
    public void swim() {
        System.out.println("狗刨");
    }
}
