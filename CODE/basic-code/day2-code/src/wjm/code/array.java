package wjm.code;

import java.util.Random;

//存数的时候字节多的可以包括字节少的，反之则不行
public class array {
    public static void main(String[] args) {
//        int array[] = {1, 2, 3};//长度不会变化,静态初始化
//        array[1] = 3;//自动遍历array.fori
//        for (int i = 0; i < array.length; i++) {
//        System.out.println(array[i]);
//        }

//        int [] a ={1,2,3,4,5,6,7,8,9,10};
//        int count = 0;
//        for (int i = 0; i < a.length; i++) {
//            if (a[i] % 3 == 0) {
//                count++;
//            }
//        }
//        System.out.println("能整除三的数有" + count + "个");
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入数组长度");
//        int i = sc.nextInt();//定义数组长度
//        String[] a = new String[i];//数组动态初始化
//        System.out.println("请输入数组内容");
//        for (int j = 0; j < i; j++) {
//            a[j] = sc.next();//输入数组内容
//            System.out.println(a[j]);
//        }
//
//        int[] b = {5,4,3,2,1};
//        int temp = 0;
//        for (int i = 0 , j =b.length - 1; i < j; i++ , j--) {
//            temp = b[i];
//            b[i] = b[j];
//            b[j] = temp;
//        }
//        for (int i = 0; i < b.length; i++) {
//            System.out.println(b[i]);
//        }
        Random rand = new Random();
        int[]  a= {1,2,3,4,5};
        for (int i = 0; i < a.length; i++) {
            int index = rand.nextInt(a.length);
            int temp = 0;
            temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
        //栈用来存储方法例如main，每个方法开始时入栈，运行结束后出栈
// 堆用来存储对象以及数组，数组在堆中存储内容有length和各个元素，数组在堆中的地址会返回给栈中定义数组的位置
//        数组名就相当于地址的寄存变量
//        几个数组同时指向一个空间，这几个数组名寄存的地址是相同的，修改一个所有都改变
    }
}
