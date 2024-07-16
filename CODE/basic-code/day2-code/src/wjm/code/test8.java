package wjm.code;

//数组中存储数组为二维数组
//二维数组也在堆中,其中有一个空间储存m个一维数组的地址,还有m个一维数组的小空间存储数组的值
//ctrl+alt+l格式化代码
public class test8 {
    public static void main(String[] args) {
////创建二维数组
//        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {6, 7, 8, 9, 10};
//        int[][] c = {a, b};
//        //建议编写格式
////        int[][] d = {
////                {1, 2, 3, 4, 5},
////                {6, 7, 8, 9, 10}
////        };
////        动态初始化
//        int[][] d = new int[3][4];
//        d[1][2] = 333;
//        for (int i = 0; i < d.length; i++) {
//            for (int j = 0; j < d[i].length; j++) {
//                System.out.print(d[i][j] + " ");
//            }
//            System.out.println();
//
//        }
        int[][] a = {
                {1, 2, 3},
                {3, 4, 5},
                {5, 6, 7}
        };
        zongsum(a);

    }

    public static void zongsum(int[][] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int sum1 = fensum(a[i]);
            System.out.println("第" + (i + 1) + "行的和为" + sum1);
            sum += sum1;
        }
        System.out.println("总的和为" + sum);
    }


    public static int fensum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i];
        }
        return sum;
    }
}
