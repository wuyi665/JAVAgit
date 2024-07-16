package wjm.code;

import java.util.Scanner;

//if和switch为分支语句
//记得大括号
//if本质是判断括号里的表达式结果为true或false,如果是boolean类型的变量直接判断即可
public class fenzhi1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学习天数");
        int days = sc.nextInt();
            if (days >= 10) {
                System.out.println("牛逼");
            }
            else if (days == 0) {
                System.out.println("傻逼");
            }
            else {
                System.out.println("继续努力");
            }


        //电影院票号,奇数坐左边,偶数坐右边
        System.out.println("你的票号是?");
            int piaohao = sc.nextInt();
            if (piaohao > 100 || piaohao < 1) {
                System.out.println("票号输入错误");
            }
            else if (piaohao % 2 == 0) {
                System.out.println("你应该坐右边");
            }else {
                System.out.println("你应该坐左边");
            }
        }
    }
