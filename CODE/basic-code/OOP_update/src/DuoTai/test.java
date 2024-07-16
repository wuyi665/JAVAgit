package DuoTai;

/*
多态指的是一个对象可以有多种形态,例如student继承person,
student p=new student();
person p=new student();也就是同类型的对象可以有多种形态  父类 对象名=子类对象
多态的前提是有继承/实现关系,有方法重写

多态的好处是:使用父类类型作为方法的形参,可以接收所有的子类对象
     弊端是:不能使用子类的独有功能,只能使用父类功能或子类重写的功能
     要想使用子类独有的功能要进行类型转换 Dog d=(Dog) d;
     或者  a instanceof Dog d(判断a是否为Dog数据类型,如果是,将a转为Dog类型的d对象);但这个第二类方法为jdk14的新特性
多态调用成员变量时:编译看左边,运行也看左边
         方法时:编译看左边,运行看右边
         如果左边空,编译会失败
 */
public class test {
    public static void main(String[] args) {
    Person p = new Person(18,"张三");
    Cat a1= new Cat("绿",3);
    Dog a2= new Dog("蓝",2);
    p.keeppet(a2,"骨头");
    p.keeppet(a1,"鱼干");
    }
}
