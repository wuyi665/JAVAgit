package Package;

public class Sheep extends Animal{
    public Sheep(){}

    public Sheep(int age, String name) {
        super(age, name);
    }
    public void eat(){
        System.out.println("吃艹");
    }
}
