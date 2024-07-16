package Student_Manage_System;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentsManage {
    static ArrayList<Student> students = new ArrayList<Student>();

    static {
        Student s1 = new Student("张三", 18, "001");
        Student s2 = new Student("李四", 19, "002");
        Student s3 = new Student("王五", 20, "003");
        students.add(s1);
        students.add(s2);
        students.add(s3);
    }

    public static void main(String[] args) {


//        进入管理系统

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("----------------欢迎来到学生管理系统----------------");
            System.out.println("1:添加学生");
            System.out.println("2:删除学生");
            System.out.println("3:修改学生");
            System.out.println("4:查询学生");
            System.out.println("5:展示所有学生信息");
            System.out.println("6:退出系统");
            System.out.print("请输入您的选择:");
            int function = sc.nextInt();
            if (function == 1) {
                students = addStudent(students);
            } else if (function == 2) {
                students = delStudent(students);
            } else if (function == 3) {
                students = changeStudent(students);
            } else if (function == 4) {
                students = chaxunStudent(students);
            } else if (function == 5) {
                bianli(students);
            } else if (function == 6) {
                System.out.println("退出系统成功!");
                break;
            } else {
                System.out.println("输入格式错误!");
            }
        }
    }


    public static void bianli(ArrayList<Student> students) {
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).getId() + '\t' + students.get(i).getName() + '\t' + students.get(i).getAge());
        }
    }

    public static ArrayList<Student> addStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();
        System.out.println("请输入添加的学生id:");
        s.setId(sc.next());
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(s.getId())) {
                System.out.println("id重复!");
                return students;
            }
        }
        System.out.println("请输入添加的学生name");
        s.setName(sc.next());
        System.out.println("请输入添加的学生age");
        s.setAge(sc.nextInt());
        students.add(s);
        return students;
    }

    public static ArrayList<Student> delStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入删除的学生id:");
        String s = sc.next();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(s)) {
                students.remove(i);
                System.out.println("删除完成!");
                return students;
            }
        }
        System.out.println("未找到相同学生id");
        return students;
    }

    public static ArrayList<Student> changeStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入修改的学生id:");
        String s = sc.next();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(s)) {
                //修改内容
                System.out.println("请输入修改的学生name");
                String name = sc.next();
                students.get(i).setName(name);
                System.out.println("请输入修改的学生age");
                int age = sc.nextInt();
                students.get(i).setAge(age);
                System.out.println("修改完成!");
                return students;
            }
        }
        System.out.println("未找到相同学生id");
        return students;
    }

    public static ArrayList<Student> chaxunStudent(ArrayList<Student> students) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的学生id:");
        String s = sc.next();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(s)) {
                //显示查询内容
                System.out.println(students.get(i).getId() + '\t' + students.get(i).getName() + '\t' + students.get(i).getAge());
                return students;
            }
        }
        System.out.println("未找到相同学生id");
        return students;
    }
}
