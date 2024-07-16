package ArrayList;

import java.util.ArrayList;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
//        Student s1 = new Student("张三",18);
//        Student s2 = new Student("李四",19);
//
//        ArrayList<Student> list = new ArrayList<Student>();
//        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
//            Student s = new Student();
//            System.out.println("输入学生名字:");
//            s.setName(sc.next());
//            System.out.println("输入学生年龄:");
//            s.setAge(sc.nextInt());
//            list.add(s);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            Student s = list.get(i);
//            System.out.println(s.getName()+"\t"+s.getAge());
//        }
        ArrayList<User> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
//        for (int i = 0; i < 3; i++) {
//            User user = new User();
//            System.out.println("输入id");
//            user.setId(sc.next());
//            System.out.println("输入username");
//            user.setUsername(sc.next());
//            System.out.println("输入password");
//            user.setPassword(sc.next());
//            list.add(user);
//        }
        User s1=new User("001","zhangsan","123456");
        User s2=new User("002","lisi","123456");
        User s3=new User("003","wangwu","123456");
        list.add(s1);
        list.add(s2);
        list.add(s3);
        System.out.println("输入要查找的id");
        String id1 = sc.next();
        int index = chazhao(list, id1);
        if(index!=-1){
            System.out.println(list.get(index).getId()+'\t'+list.get(index).getUsername()+'\t'+list.get(index).getPassword());
        }else{
            System.out.println("查找的id不存在!");
        }
    }

    public static int chazhao(ArrayList<User> list, String id) {
        int index = -1;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}


