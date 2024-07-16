package DuoTai;

public class Animals {
    private String color;
    private int age;

    public Animals() {
    }

    public Animals(String color, int age) {
        this.color = color;
        this.age = age;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void eat(String food) {
        System.out.println("正在吃" + food);
    }
}
