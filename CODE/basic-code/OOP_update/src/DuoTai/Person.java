package DuoTai;

public class Person {
    private String name;
    private int age;

    public Person() {
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public void keeppet(Dog dog, String food) {
//        System.out.println("年龄为" + age + "的" + name + "养了一只" + dog.getColor() + "颜色的" + dog.getAge() + "岁的宠物");
//        dog.eat(food);
//    }
//
//    public void keeppet(Cat cat, String food) {
//        System.out.println("年龄为" + age + "的" + name + "养了一只" + cat.getColor() + "颜色的" + cat.getAge() + "岁的宠物");
//        cat.eat(food);
//    }
    public void keeppet(Animals a, String food) {
        if(a instanceof Dog d ) {
            d.lookhome();
            System.out.println("年龄为" + age + "的" + name + "养了一只" + d.getColor() + "颜色的" + d.getAge() + "岁的狗");
            d.eat(food);
        } else if (a instanceof Cat d) {
            d.catchmouse();
            System.out.println("年龄为" + age + "的" + name + "养了一只" + d.getColor() + "颜色的" + d.getAge() + "岁的狗");
            d.eat(food);
        }else{
            System.out.println("没有这种动物!");
        }
    }
}
