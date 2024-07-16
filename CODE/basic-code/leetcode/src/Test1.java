import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        //整数拼接取最大
        int[] arr = {3, 34, 30, 59, 58};
        String[] str = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            str[i] = String.valueOf(arr[i]);
        }
        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1 + o2).compareTo(o2 + o1) >= 0) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        StringBuilder sumString = new StringBuilder();
        for (String string : str) {
            sumString.append(string);
        }
        if (sumString.substring(0, 1).equals("0")) {//防止出现数组全为零现象
            System.out.println("0");
        } else {
            System.out.println(sumString.toString());
        }
    }
}
