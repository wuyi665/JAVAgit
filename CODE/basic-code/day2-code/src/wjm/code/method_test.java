package wjm.code;

import java.util.Scanner;
//基本数据类型包含整数、浮点数、布尔数、字符，这些类都储存在栈中
//引用数据类型包含数组等代码中含new的类，这些类都储存在堆里
//传递基本数据类型时，形参的改变不影响实参的改变，而引用数据类型会改变
public class method_test {
    public static void main(String[] args) {
        int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        printarray(a);//调用
        int max = max(a);//调用
        System.out.println("数组中整数最大值为：" + max);
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个想判断的数");
        int guess = sc.nextInt();//输入
        boolean flag = exist(guess , a);//调用
        System.out.println(flag);
        System.out.println("输入截取上下区间");
        int from =sc.nextInt();
        int to =sc.nextInt();
        int[] b = getarr(a,from,to);//调用
        printarray(b);//调用
    }
//打印一个数组
    public static void printarray(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i != a.length - 1){
            System.out.print(a[i] + ",");
            }else{
                System.out.print(a[i]);//printlin后的ln表示换行
            }
        }
        System.out.println("]");
    }
//    返回数组最大值
public static int max(int[] a) {
        int max = a[0];
    for (int i = 1; i < a.length; i++) {
        if (a[i] > max) {
            max = a[i];
        }
    }
    return max;
    }
//判断数组中是否存在猜的数
    public static boolean exist(int guess , int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == guess) {
                 return true;
            }
        }
        return false;
    }
//    截取数组数据从from到to（包含to)
    public static int[] getarr(int[] a, int from, int to) {
        if ((from - to) > a.length) {
            System.out.println("截取长度错误");
            return null;
        }
        int[] b = new int[to - from + 1];
        int index = 0;
        for (int i = from - 1; i <= to - 1; i++) {
            b[index] = a[i];
            index++;
        }
        return b;
    }

}
