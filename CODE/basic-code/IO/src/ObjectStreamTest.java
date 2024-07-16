import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ObjectStreamTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /*
         * Serializable接口没有抽象方法,是一个标记型接口
         *一旦实现了这个接口,表示当前对象可以被序列化
         * */
        class Student implements Serializable {
            private static final long serialVersionUID = 1L;
            private String name;
            private int age;
            //transient:瞬态关键字,不会序列化到本地
            private transient String address;

            public Student(int age, String name, String address) {
                this.age = age;
                this.name = name;
                this.address = address;
            }

            @Override
            public String toString() {
                return "Student{" +
                        "address='" + address + '\'' +
                        ", name='" + name + '\'' +
                        ", age=" + age +
                        '}';
            }
        }
//对象序列化操作
        Student s1 = new Student(18, "John", "China");
        Student s2 = new Student(20, "Jane", "China");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IO\\student.txt"));
        ArrayList<Student> students = new ArrayList<Student>();
        Collections.addAll(students, s1, s2);
        oos.writeObject(students);
        oos.close();
//对象反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IO\\student.txt"));
        ArrayList<Student> students2 = (ArrayList<Student>) ois.readObject();
        for (Student student : students2) {
            System.out.println(student.toString());
        }
        ois.close();
    }
}
