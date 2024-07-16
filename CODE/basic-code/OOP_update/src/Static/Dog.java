package Static;

public class Dog {
    String name;

    public Dog() {
        this("大黄");//给一个默认值
    }

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat() {
        System.out.println("吃狗粮");
    }

    public void drink() {
        System.out.println("喝水");
    }

    public void look() {
        System.out.println("看家");
    }
}
