package ReflectTest;

public class ClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        /*
         *字节码文件的对象找到的都是一个
         * */
        Class clazz1 = Class.forName("ReflectTest.Student");
        Class clazz2 = Student.class;
        Student student = new Student();
        Class clazz3 = student.getClass();
        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);
    }
}
