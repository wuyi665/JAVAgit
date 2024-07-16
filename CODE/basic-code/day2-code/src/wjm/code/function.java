package wjm.code;

import java.util.Scanner;

public class function {
    public static void main(String[] args) {
        //方法是程序中最小的执行单元，重复、独立功能的代码可以写一个函数进行调用
//        void/int等等为函数返回的数据类型，void表示无返回值 后跟函数名
//    main方法为主入口，在main中调用什么函数就进入什么函数
//函数定义时的参数为形参      调用时的参数为实参    形参和实参必须要一一对应
//        带有返回值的用return，return相当于结束代码，之后的代码并不执行
//        不同函数之间时平级的
        function1();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入两个整数：");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int result = function2(a,b);
        System.out.println("两个数的和为：" +result);
    }

    public static void function1() {
        System.out.println("这是一个函数");
    }

    public static int function2(int m, int n) {
        int result = m + n;
        System.out.println("两个数的和为：" +result);
        return result;
    }


//在同一个class中，方法名称相同但是形参不同（个数、类型、顺序不同）称为方法的重载（方法=函数）









}
