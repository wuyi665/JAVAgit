package Package;

public class Tabletenniscoach extends Coach implements English{
    public Tabletenniscoach(){

    }

    public Tabletenniscoach(int age, String name) {
        super(age, name);
    }

    @Override
    public void teach() {
        System.out.println(name+"教打乒乓球");
    }
    @Override
    public void english() {
        System.out.println(name+"会说英语");
    }
}
