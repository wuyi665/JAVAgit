package wjm.code;

import java.util.Scanner;

public class test4 {
    public static void main(String[] args) {
        int[] arr = array();
        double score = score(arr);
        System.out.println("最终得分为：" + score);

    }
//输入评委分数
    public static int[] array(){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("请输入评委分数：");
            arr[i] = sc.nextInt();
            if(arr[i]<0 || arr[i]>100){
                System.out.println("打分不符合打分范围！");
                i--;
            }
        }
        return arr;
    }
    //计算最终得分
    public static double score(int[] a) {
        int max = a[0];
        int min = a[0];
        double sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
            if(a[i]>max) max = a[i];
            if(a[i]<min) min = a[i];
        }
        sum = (sum - max - min)/(a.length - 2);
        return sum;
    }
}
