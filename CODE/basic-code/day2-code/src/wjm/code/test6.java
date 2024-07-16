package wjm.code;

import java.util.Random;

public class test6 {
    public static void main(String[] args) {
        //奖池
        int[] arr = {8,88,188,288,388,488,888};
//        抽到的奖池
        int[] newarr = new int[arr.length];
//        开始抽奖
        Random random = new Random();
//        判断是否抽到过
        for (int i = 0; i < arr.length; ) {
            int index = random.nextInt(arr.length);
            int temp = arr[index];
            boolean flag = compare(temp , newarr);
            if(!flag){
                newarr[i] = temp;
                i++;
            }
        }
        for (int i = 0; i < newarr.length; i++) {
            System.out.println(newarr[i]);
        }
    }
//判断是否抽取到过
    public static boolean compare(int a , int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if(a == arr[i]){
                return true;
            }
        }
        return false;
    }
}
