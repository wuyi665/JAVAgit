package Package;

public class Basketballcoach extends Coach {
    public Basketballcoach() {

    }

    public Basketballcoach(int age, String name) {
        super(age, name);
    }

    @Override
    public void teach() {
        System.out.println(name+"教打篮球");
    }

}
