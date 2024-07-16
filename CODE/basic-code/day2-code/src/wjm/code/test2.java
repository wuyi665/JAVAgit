package wjm.code;

import java.util.Random;

//随机数处五位验证码
public class test2 {
    public static void main(String[] args) {
        char[] arr1 = new char[52];
        int[] arr2 ={0,1,2,3,4,5,6,7,8,9};
        for (int i = 0; i < arr1.length; i++) {
            if (i <= 25) {
                arr1[i] = (char) ('a' + i);
            } else {
                arr1[i] = (char) ('A' + i - 26);
            }
        }
        Random rand = new Random();
        String code = "";
        for (int i = 0; i < 5; i++) {
            if(i != 4) {
                int index = rand.nextInt(arr1.length);
                code = code + arr1[index];
            }else{
                int index = rand.nextInt(arr2.length);
                code = code + arr2[index];
            }
        }
        System.out.println(code);
    }
}
