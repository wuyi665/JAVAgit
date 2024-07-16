package wjm.code;

import java.util.Random;
import java.util.Scanner;

/*for和while循环
\t制表符在idea中为前面字符串补足八位
for和while循环中的变量尽量写到外面让他能够再次被使用
知道循环次数用while 不知道用for
 */
public class xunhuan1 {
    public static void main(String[] args) {
//        for (int a = 1; a <= 5; a++) {
//            System.out.println("正在断线重连第" + a +"次");
//        int add = 0;
//        for (int i = 1; i <= 100; i++) {
//            if (i % 2 == 0) {
//                add = add + i;
//            }
//        }
//        System.out.println("1-100的偶数和为:" + add);

//        int i = 1;
//        while (i <= 100){
//            System.out.println(i);
//            i++;
//        }

//        回文数
//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个整数");
//        int n = sc.nextInt();
//        int m = n;
//        int num = 0;
//        while (n != 0) {
//            int temp = n % 10;
//            num = num * 10 + temp;
//            n = n / 10;
//        }
//        if(num == m){
//            System.out.println("是回文数");
//        }
//        else{
//            System.out.println("不是回文数");
//        }

//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入被除数");
//        int m = sc.nextInt();
//        System.out.println("输入除数");
//        int n = sc.nextInt();
//        int shang = 0;
//        int yu = 0;
//        if (n == 0) {
//            System.out.println("除数不能为0");
//        }
//        while (n != 0 && m >= n) {
//            m = m - n;
//            shang++;
//        }
//        yu = m;
//        if (n != 0) {
//            System.out.println("商为:" + shang);
//            System.out.println("余数为:" + yu);
//        }

//无限循环代码
//        for (; ; ) {
//            System.out.println();
//        }

//        while (true) {
//        System.out.println();
//        }

//        do{
//        System.out.println();
//    }while(true);
//        跳转循环指令为continue，可在循环体中插入if判断是否跳出一次循环
//        break为跳出循环体，表示不再进行循环

//        Scanner sc = new Scanner(System.in);
//        System.out.println("请输入一个整数");
//        int number = sc.nextInt();
//        int i = 2;
//        while (i-1 <= number) {
//            if (number == 2 || number == 3) {
//                System.out.println(number + "是一个质数");
//                break;
//            }
//            else if (number % i == 0 || number == 1) {
//                System.out.println(number + "不是一个质数");
//                break;
//            }else if (i == number - 1) {
//                System.out.println(number + "是一个质数");
//                break;
//            }
//            else i++;
//        }
//        获取随机数猜数字
        Random rand = new Random();
        int number = rand.nextInt(100) +1 ;//1-100 范围从0开始
        Scanner sc = new Scanner(System.in);
        System.out.println("请猜一个数：");
        int guessnumber = sc.nextInt();
        while(number != guessnumber){
            if(number > guessnumber) {
                System.out.println("小了，请再猜一个数：");
                guessnumber = sc.nextInt();
            }else {
                System.out.println("大了，请再猜一个数：");
                guessnumber = sc.nextInt();
            }
        }
        System.out.println("猜对了，随机生成的数是：" + guessnumber);
    }
}
