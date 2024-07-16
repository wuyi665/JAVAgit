package DuoTai;

public class Dog extends Animals {
    public Dog() {
    }

    public Dog(String color, int age) {
        super(color, age);
    }

    public void lookhome() {
        System.out.println("正在看家");
    }

    @Override
    public void eat(String food) {
        System.out.println(getAge() + "岁的" + getColor() + "颜色的狗两条前腿抱着" + food + "猛吃");
    }
}

