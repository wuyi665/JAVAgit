package ReflectTest;

import java.lang.reflect.Constructor;

public class ConstructorTest {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        //获取字节码文件对象
        Class clazz = Class.forName("ReflectTest.Student");
        //获取构造方法
        Constructor[] constructors = clazz.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
    }
}
