package wjm.code;
//数组元素的复制
public class test3 {
    public static void main(String[] args) {
        //定义一个老数组
        int[] a ={0,1,2,3,4,5,6,7,8,9};
        //定义一个新数组
        int[] b =new int[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i];
        }
        //输出复制的数组
        copy(b);
    }

    public static void copy(int[] a) {
        System.out.print("[");
        for (int i = 0; i < a.length; i++) {
            if (i == a.length - 1) {
                System.out.print(a[i]);
            }else{
                System.out.print(a[i] + ",");
            }
        }
        System.out.println("]");
    }
}
