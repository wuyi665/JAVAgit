package Package;

public class Tabletennisplayer extends Player implements English{
    public Tabletennisplayer(){}

    public Tabletennisplayer(int age, String name) {
        super(age, name);
    }

    @Override
    public void learn() {
        System.out.println(name+"学习打乒乓球");
    }

    @Override
    public void english() {
        System.out.println(name+"会说英语");
    }
}
