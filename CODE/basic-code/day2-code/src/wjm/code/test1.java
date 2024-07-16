package wjm.code;

import java.util.Scanner;
//ctrl+alt+m可以自动提取方法！！！！！！！！
public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入机票原价：");
        double preprice = sc.nextDouble();
        System.out.print("输入当前月份：");
        int month = sc.nextInt();
        System.out.print("输入机舱舱型：");
        String a = sc.next();
        double price = calc(preprice,month,a);
        System.out.println("机票折扣价格为：" + price);
    }
    public static double calc(double preprice, int month, String a) {
        double price = 0;
        if (month > 12 || month < 1) {
            System.out.println("输入月份错误！");
        }else if(month >= 5 && month <= 10 && a.equals("头等舱")){
            price = preprice * 0.9;
        }else if(month >= 5 && month <= 10 && a.equals("经济舱")){
            price = preprice * 0.85;
        }else if((month <= 4 || month >= 11) && a.equals("头等舱")){
            price = preprice * 0.7;
        }else if((month <= 4 || month >= 11) && a.equals("经济舱")){
            price = preprice * 0.65;
        }else{
            System.out.println("输入舱型错误!");
        }
        return price;
    }
}
