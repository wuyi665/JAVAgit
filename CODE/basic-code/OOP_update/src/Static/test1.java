package Static;

//static修饰的变量和方法为静态,不会因为调用对象而改变,非静态方法jvm在调用时自动进行this赋值
/*
在类中用static对变量进行修饰时所有的对象共享这样一个变量的值,可用类名.调用直接对变量进行赋值修改,这样的变量调用时存储在堆内存的静态区节省内存
除了javabean类和测试类,还有一个工具类,可用类名.方法名()进行调用,方便我们定义方法对特殊情况进行处理,用private static定义这种方法

oop特征有:封装(使代码模块化) 继承(提升代码复用性) 多态(提升接口复用性)

继承方法用法:public 类名1 extends 类名2{} 表示类名1为子类 类名2为父类
子类可以继承父类的成员变量(private类的用set和get方法继承调用)和public成员方法
多级继承会产生一个虚方法表,在继承中父类不断传递给子类(该表也包含自己的方法 非private非static非finals),虚方法表在方法区(元空间)
 调用变量,this.为找本类成员变量 super.为找父类成员变量,最多只能写一个super.
 */
/*
当父类方法不能满足子类需求时,可以在子类中进行重写,用@override注解表示,这时调用方法根据就近原则会使用子类中的方法,重写时格式命名都要一致
重写之后会覆盖虚方法表,只有添加到虚方法表中的方法才能重写

在运行子类构造方法之前会先运行父类的无参构造,保证变量的初始化
 */
public class test1 {
    public static void main(String[] args) {
//        Dog d = new Dog();
//        System.out.println(d.getName());
//        Hashiqi dog1 = new Hashiqi();
//        dog1.eat();
//        dog1.drink();
//        dog1.look();
//        dog1.breakhome();
//        Shapi dog2 = new Shapi();
//        dog2.eat();
//        dog2.drink();
//        dog2.look();
//        Manager p1 = new Manager();
//        p1.eat();
//        p1.work();
//        Cook p2=new Cook();
//        p2.eat();
//        p2.work();
        Teacher p1 = new Teacher("001", "张三");
        p1.work();
        AdminStaff p2 = new AdminStaff("002", "李四");
        p2.work();
        Lecturer p3 = new Lecturer("003", "王五");
        p3.work();
        Tutor p4 = new Tutor("004", "赵六");
        p4.work();
        Maintainer p5 = new Maintainer("005", "周七");
        p5.work();
        Buyer p6 = new Buyer("007", "吴八");
        p6.work();


    }
}

