import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //录入整数直到和超过200
        ArrayList<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        while (true) {
            System.out.println("请输入一个整数:");
            String s = sc.nextLine();
            int num = Integer.parseInt(s);
            sum += num;
            if(sum>200){
                break;
            }else{
                list.add(num);
            }
        }
    }
}
