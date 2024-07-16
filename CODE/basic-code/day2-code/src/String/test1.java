package String;

import java.util.Scanner;

//api例如Scanner和Random可以调用别人写好的功能,是jdk中提供的写好的java类,可以用api帮助文档查询
public class test1 {
    public static void main(String[] args) {/*
        Scanner sc = new Scanner(System.in);
        System.out.println("输入一个小数:");
        double a = sc.nextDouble();
        System.out.println(a);
        输入一个小数

        //字符串String在创建之后不能被更改,String其实是定义好的一个类,每次创建一个新的都和创造对象方法相同
        //按照字节数组的方式创造字符串
        byte[]  b={97,98,99};//将其中的字节通过ascii码表转换后给字符串
        String a=new String(b);
        System.out.println(a);
        从jdk7之后,直接赋值的字符串存储在堆内存中的串池,如果有相同的字符串会直接复用,如果用new方法(赋值语句中存在变量)不会复用
        */
        //String的比较:"=="符号在比较基本数据类型时比较的是数据值,在比较引用数据类型时比较的是地址值
        /*
        String username = "wjm";
        String password = "1234567890";
        int Stringlength = username.length();
        System.out.println(Stringlength);
        for (int i = 0; i < Stringlength; i++) {
            char ch = username.charAt(2 - i);//charAt(i)方法中i为索引,表示返回该字符串中第i个字符
            System.out.print(ch);
        }

         */

//        for (int i = 0; i < 3; i++) {
//            String inusername = inputusername();
//            String inpassword = inputpassword();
//            if (username.equals(inusername) && password.equals(inpassword)) {
//                System.out.println("登录成功!");
//                break;
//            } else {
//                System.out.println("登陆失败!请重新输入!");
//            }
//        }
//    }
//
//
//    public static String inputusername() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入用户名:");
//        String username = sc.nextLine();
//        return username;
//    }
//
//    public static String inputpassword() {
//        Scanner sc = new Scanner(System.in);
//        System.out.println("输入密码:");
//        String password = sc.nextLine();
//        return password;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入金额:");
        String b = sc.nextLine();
        boolean flag = TrueorFalse(b);
        if (flag) {
            InttoString(b);
        }

    }
//判断是否规范
    private static boolean TrueorFalse(String b) {
        boolean flag = true;
        if (b.length() <= 0 || b.length() > 7) {
            System.out.println("输入金额不规范!");
            flag = false;
        }
        for (int i = 0; i < b.length(); i++) {
            char c = b.charAt(i);
            if (c == '0' || c == '1'||c == '2' || c == '3'|| c == '4'||c == '5' || c == '6' || c == '7'||c == '8' || c == '9') {

            }else{
                System.out.println("输入金额不规范!");
                flag = false;
                break;
            }
        }
        return flag;
    }
//数字转换金额
    private static void InttoString(String b) {
        String a = "佰拾万仟佰拾元";
        for (int i = 0; i < a.length(); i++) {
            if (i < (a.length() - b.length())) {
                System.out.print("零");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '0') {
                System.out.print("零");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '1') {
                System.out.print("壹");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '2') {
                System.out.print("贰");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '3') {
                System.out.print("叁");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '4') {
                System.out.print("肆");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '5') {
                System.out.print("伍");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '6') {
                System.out.print("陆");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '7') {
                System.out.print("柒");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '8') {
                System.out.print("捌");
                System.out.print(a.charAt(i));
            } else if (b.charAt(i - a.length() + b.length()) == '9') {
                System.out.print("玖");
                System.out.print(a.charAt(i));
            }
        }
    }
}




