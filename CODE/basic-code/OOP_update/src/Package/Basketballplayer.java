package Package;

public class Basketballplayer extends Player{
    public Basketballplayer(){

    }

    public Basketballplayer(int age, String name) {
        super(age, name);
    }

    @Override
    public void learn() {
        System.out.println(name+"学打篮球");
    }
}
