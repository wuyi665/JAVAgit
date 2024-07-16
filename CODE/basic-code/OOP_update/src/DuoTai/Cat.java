package DuoTai;

public class Cat extends Animals {
    public Cat() {
    }

    public Cat(String color, int age) {
        super(color, age);
    }

    public void catchmouse() {
        System.out.println("正在抓老鼠");
    }

    @Override
    public void eat(String food) {
        System.out.println(getAge() + "岁的" + getColor() + "颜色的猫眯着眼睛侧着头吃" + food);
    }
}
