/*
冒泡排序和选择排序基本思想相同,选择排序是优化后的冒泡排序
插入排序:将数组分为有序和无序两个部分
快速排序:递归算法,递归算法会特别占用栈内存,因为放法不断进栈
    将0索引位置的数字当作基准数,比基准数小的在左,大的在右
 */

import java.util.Random;

public class PaiXu {
    public static void main(String[] args) {
        int[] arr = {5, 9, 6, 3, 8, 5, 2, 9, 0};
        int[] arr1=new int[10000];
        Random rand = new Random();
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = rand.nextInt(10000);
        }
        long start = System.nanoTime();
        fast(arr, 0, arr.length - 1);
//        maopao(arr1);
        long end = System.nanoTime();
        System.out.println(end - start);
//        sout(arr);
    }

    private static void sout(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void maopao(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] > arr[i]) {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public static void insert(int[] arr) {
        //找出无序数组开始索引
        int startindex = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                startindex = i;
                break;
            }
        }
        for (int i = startindex; i < arr.length; i++) {
            int j = i;
            while (j >= 1 && arr[j] < arr[j - 1]) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }

    }

    public static void fast(int[] arr, int i, int j) {
        int basenumber = i;
        int startindex = i;
        int endindex = j;
        if (startindex > endindex) {
            return;
        }
        while (startindex != endindex) {
            while (true) {
                if (arr[endindex] <= arr[0] || startindex == endindex) {
                    break;
                }
                endindex--;
            }
            while (true) {
                if (arr[startindex] > arr[0] || startindex == endindex) {
                    break;
                }
                startindex++;
            }
            int temp = arr[startindex];
            arr[startindex] = arr[endindex];
            arr[endindex] = temp;
        }
        int temp = arr[endindex];
        arr[endindex] = arr[basenumber];
        arr[basenumber] = temp;
        fast(arr, i, startindex - 1);
        fast(arr, startindex + 1, j);
    }

    public static int digui(int number) {
        if (number == 1) {
            return 1;
        }

        return number * digui(number - 1);
    }

}
