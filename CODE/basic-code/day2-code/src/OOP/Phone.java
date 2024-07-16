package OOP;

/*
类是共同特征的描述,对象是具体存在的实例
类中一般包括代表成员属性的名词(成员变量)和代表成员行为的动词(成员方法)
类名 对象名 = new 类名();
描述某一事物的类叫做javabean类,一般不写main方法,定义成员变量和构造方法和成员方法
编写main方法的叫做测试类
 */
/*
一个方法该写在哪个类中,要看这个方法需要什么数据,这个数据要尽可能地存在于写的类中
封装:对象代表什么,就要封装相应的数据,并提供数据对应的行为
private表示只能在本类中访问,不能被其他类引用
成员变量表示类中方法外的变量  局部变量表示类中方法外的变量
 */
public class Phone {
    //属性
    //变量1
    private String brand;
    //变量2
    private double price;

    //    无参构造,构造方法由JVM调用给成员变量初始化
    public Phone() {
        System.out.println("这是无参构造");
    }

    //    有参构造方法,初始化值
    public Phone(String brand, double price) {
        if (!brand.equals("小米")) {
            System.out.println("非法名称");
        } else {
            this.brand = brand;
            System.out.println(brand);
        }
        if (price > 10000 || price < 0) {
            System.out.println("价格不合理");
        } else {
            this.price = price;
            System.out.println(price);
        }
    }

    //提供给其他类调用初始化值的方法
    public void setBrand(String brand) {
        if (!brand.equals("小米")) {
            System.out.println("非法名称");
        } else {
            this.brand = brand;
            System.out.println(brand);
        }
    }

    public void setPrice(double price) {
        if (price > 10000 || price < 0) {
            System.out.println("价格不合理");
        } else {
            this.price = price;
            System.out.println(price);
        }
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    //成员方法
    public void call() {
        System.out.println("打电话");
    }

    public void playgame() {
        System.out.println("玩游戏");
    }
}
