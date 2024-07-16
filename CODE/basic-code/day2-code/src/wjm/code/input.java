package wjm.code;

import java.util.Scanner;

public class input {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("输入字母i");
        int i=sc.nextInt();
        byte a=(byte)i;
        a += a;
        System.out.println(a + "为输出的integer");
        System.out.println("输入字母b");
        int b=sc.nextInt();
        int max=a>b?a:b;
        System.out.println(max);
        boolean result = a==5 || b==3;
        System.out.println(result);
        char c = 'a';
        System.out.println(c+a);

    }
}
