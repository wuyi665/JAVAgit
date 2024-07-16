package wjm.code;

import java.util.Scanner;
/*
default省略时不输出任何语句
default可以写在switch任何位置
break不能省略,否则产生case穿透并且case穿透顺序执行穿透直到遇到break

*/
public class fenzhi2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("输入你想玩的游戏");
        String game=sc.nextLine();
        extracted(game);
    }

    private static void extracted(String game) {
        switch (game){
            case "瓦":
            { System.out.println("我想玩无畏契约");
            break;}
            case "pvz":
            {System.out.println("我想玩植物大战僵尸杂交版");
            break;}
            default:
            {System.out.println("玩个蛋,学习!");
            break;}

        }
    }
}
