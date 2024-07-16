package Package;

public class AbstractTest {
    public static void main(String[] args) {
//
//        Animal animal=new Dog();
//        animal.eat();
//        Animal animal1=new Frog();
//        animal1.eat();
//        Animal animal2=new Sheep();
//        animal2.eat();
//        animal.drink();
//        animal1.drink();
//        animal2.drink();
//        ((Dog)animal).swim();
//        ((Frog)animal1).swim();

        Tabletennisplayer p1 = new Tabletennisplayer(18, "张三");
        Basketballplayer p2 = new Basketballplayer(19, "李四");
        Tabletenniscoach c1 = new Tabletenniscoach(38, "王五");
        Basketballcoach c2 = new Basketballcoach(39, "赵六");
        p1.learn();
        p1.english();
        p2.learn();
        c1.teach();
        c1.english();
        c2.teach();
    }
}
