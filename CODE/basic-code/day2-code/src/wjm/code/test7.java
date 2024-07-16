package wjm.code;

import java.util.Random;
import java.util.Scanner;

public class test7 {
    public static void main(String[] args) {

        //用户输入号码
        int[] newarr = innumber();
        System.out.println("选择成功!");
        System.out.print("你选择的号码是:");
        for (int i = 0; i < newarr.length; i++) {
            System.out.print(newarr[i] + " ");
        }
        System.out.println();
        //得到中奖奖池
        int[] arr = getnumber();
        System.out.print("中奖号码是:");
        System.out.print("中奖号码是:");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
//    输入号码方法
public static int[] innumber() {
        int[] arr = new int[7];
        Scanner sc = new Scanner(System.in);
        //输入红色号码
    for (int i = 0; i < arr.length -1; i++) {
        System.out.print("用户输入第" + (i + 1) + "红色号码:");
        while(true){
        int temp = sc.nextInt();
            boolean flag = compare(arr, temp);
        //对号码是否正确进行判断
        if (temp > 33 || temp < 1) {
            System.out.print("范围错误,请重新输入一个号码:");
        }
        else if (flag) {
            System.out.print("号码重复,请重新输入一个号码:");
        }else{
        arr[i] = temp;
            break;}
        }
    }

    //输入蓝色号码
    System.out.print("用户输入蓝色号码:");
    int temp1 = sc.nextInt();
    //对号码是否正确进行判断
    while(true){
    if (temp1 > 16 || temp1 < 1) {
        System.out.print("范围错误,请重新输入一个号码:");
        temp1 = sc.nextInt();
    }else {
        arr[arr.length - 1] = temp1;
        break;
    }
    }
    return arr;
}



//    生成中奖号码
public static int[] getnumber() {
        //生成中奖号码
        Random r = new Random();
        //生成空白奖池
        int[] arr = new int[7];
        //将红色号码放到奖池当中
        for (int i = 0; i < 6; ) {
            int rednumber = r.nextInt(33) + 1;
            boolean flag = compare(arr, rednumber);
            if (!flag) {
                arr[i] = rednumber;
                i++;
            }
        }
        //将蓝色号码放到奖池当中
        int bluenumber = r.nextInt(16) + 1;
        arr[6] = bluenumber;

    return arr;
    }
//对比是否重复
    public static boolean compare(int[] a, int number) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == number) {
                return true;
            }
        }return false;
    }
}
