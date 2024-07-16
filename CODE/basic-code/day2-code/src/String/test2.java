package String;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        /*
        String a="15890411217";
        //substring方法为截取字符串操作
        String b=a.substring(0,3);
        String c=a.substring(7);
        System.out.println(b+"****"+c);


        String a="你tmd";
        //replace表示把特定的字符串替换为新的字符串
        String result=a.replace("tmd","***");
        System.out.println(a);
        System.out.println(result);


        StringBuilder a = new StringBuilder();//StringBUilder相当于一个字符串容器,创建之后内容可以改变,此时打印a显示的是属性值
        默认长度为16,扩容后为16*2+2=34,如果超过扩容就是字符串长度,不再进行溢出扩容
        在字符串的拼接和反转方面用StringBuilder
        a.append("abc");//添加
        a.reverse();//反转
        int length=a.length();
        System.out.println(length);
        String b=a.toString();//操作完后必须转到字符串才能对字符串进行操作
        System.out.println(b);
        但在用StringBuilder对字符串进行拼接时要规定间隔符号与左右符号过于复杂,于是有了StringJoiner(jdk8后出现)
        StringJoiner a = new StringJoiner(",","[","}");分别为间隔符号,开始符号和结束符号



        //链式编程:调用一个方法后,可以先不赋值,可以继续调用方法处理,完全处理完后再进行赋值
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = new StringBuilder().append(str).reverse().toString();
        if (str.equals(result)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一串数字:");
        String str = sc.nextLine();
        String newstr = changezhongwen(str);

    }

    public static String changezhongwen(String str) {
        String a = "零壹贰叁肆伍陆柒捌玖";
        boolean flag = false;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (str.length() > 10) {
                System.out.println("输入长度不规范!");
                flag = false;
                break;
            } else if (ch < '0' || ch > '9') {
                System.out.println("输入内容不规范!");
                flag = false;
                break;
            }
            flag = true;
        }
        while (flag) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                }else {
                    str = str.replace(str.charAt(i), a.charAt(str.charAt(i) - '0'));
                }
            }
            System.out.println(str);
            break;

        }
        return str;
    }

}
