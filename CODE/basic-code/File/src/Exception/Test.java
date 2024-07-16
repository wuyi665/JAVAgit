package Exception;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        try {
//            System.out.println(arr[9]);
//        } catch (ArrayIndexOutOfBoundsException e) {
////            throw new RuntimeException("索引越界");
//            e.printStackTrace();
//        }
//        getMax(arr);
        Student s1 = new Student();
        while (true) {
            try {
                signin(s1);
                break;
            } catch (NameFormatException e) {
                e.printStackTrace();
            } catch (AgeOutofboundsException e) {
                e.printStackTrace();
            }
        }
    }

    public static void signin(Student student) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入名字:");
        String name = sc.nextLine();
        student.setName(name);
        System.out.print("输入年龄:");
        int age = Integer.parseInt(sc.nextLine());
        student.setAge(age);
        System.out.println(student);
    }


    public static void getMax(int[] arr) {
        if (arr == null) {
            throw new NullPointerException();
        } else if (arr.length == 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        System.out.println(max);
    }
}
