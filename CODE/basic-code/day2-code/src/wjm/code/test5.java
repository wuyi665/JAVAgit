package wjm.code;

import java.util.Scanner;

//数字加密和解密
public class test5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入你的密码:");
        int a = sc.nextInt();
        //求出密码的长度并将每一位数分配给数组
        int  length = getlength(a);
        int[] arr = new int[length];
        getarr(length, a, arr);
        jiami(arr);
        fanzhuan(arr);
        System.out.print("加密后的密码是:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
        fanzhuan(arr);
        jiemi(arr);
        System.out.print("解密后的密码是:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
//    解密
public static void jiemi(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5) {
                arr[i] = arr[i] - 5;
            }else {
                arr[i] = arr[i] + 5;
            }
        }

}
//    数组翻转
public static void fanzhuan(int[] arr) {
        for (int i = 0 , j = arr.length -1; i < j; i++ , j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

}
//对密码进行加密
public static void jiami(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        arr[i] = (arr[i] + 5) % 10;
    }

}
//将整数存在数组中
    private static void getarr(int length, int a, int[] arr) {
        for (int i = length -1; i >= 0; i--) {
            int temp = a % 10;
            a = a / 10;
            arr[i] = temp;
        }
    }

    //求出整数长度
    private static int getlength(int a) {
        int count = 0;
        while (a != 0){
            a = a /10;
            count++;
        }
        return count;
    }
}
