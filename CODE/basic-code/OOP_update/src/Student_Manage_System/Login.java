package Student_Manage_System;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Login {
    static ArrayList<User> users = new ArrayList<>();

    static {
        User u1 = new User("wuyi", "123456", "41132620040117441X", "15890411217");
        users.add(u1);
    }

    public static void main(String[] args) {
        //        登录 注册 忘记密码页面

        Scanner sc1 = new Scanner(System.in);
        while (true) {
            loop:
            while (true) {
                System.out.println("----------------欢迎来到学生管理系统----------------");
                System.out.println("1:登录");
                System.out.println("2:注册");
                System.out.println("3:忘记密码");
                System.out.println("4:退出网页");
                System.out.println("5:展示userlist");
                System.out.print("请输入你的操作:");
                String choice = sc1.next();
                switch (choice) {
                    case "1": {
                        boolean flag = login(users);
                        if (flag == true) {
                            break loop;
                        } else {
                            System.exit(0);
                        }
                    }
                    case "2": {
                        register(users);
                        break;
                    }
                    case "3": {
                        forgetpassword(users);
                        break;
                    }
                    case "4": {
                        System.out.println("退出成功!");
                        System.exit(0);//停止虚拟机运行
                    }
                    case "5": {
                        for (int i = 0; i < users.size(); i++) {
                            System.out.println(users.get(i).getUsername() + '\t' + users.get(i).getPassword() + '\t'
                                    + users.get(i).getIdnumber() + '\t' + users.get(i).getPhonenumber());
                        }
                        break;
                    }
                    default: {
                        System.out.println("操作失败!");
                        break;
                    }
                }
            }
        }
    }

    public static ArrayList<User> register(ArrayList<User> users) {
        Scanner sc = new Scanner(System.in);
        User u1 = new User();
        System.out.println("请输入用户名(3-15位数字与字母的组合):");
        //输入用户名的判断
        loop:
        while (true) {
            loop1:
            while (true) {//判断用户名长度
                String username = sc.next();
                if (username.length() < 3 || username.length() > 15) {
                    System.out.print("用户名长度错误,请重新输入:");
                    break loop1;
                }
                //判断用户名内容组合
                int count = 0;
                for (int i = 0; i < username.length(); i++) {
                    char ch = username.charAt(i);
                    if ((ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')) {
                    } else {
                        System.out.println("用户名必须是字母加数字的组合!请重新输入:");
                        break loop1;
                    }
                    if ((ch >= 'A' && ch <= 'Z' || ch >= 'a' && ch <= 'z')) {
                        count++;
                    }
                    if (count == 0) {
                        System.out.println("用户名不能是纯数字!请重新输入:");
                        break loop1;
                    }

                }
                //判断用户名是否重复
                for (int i = 0; i < users.size(); i++) {
                    if (username.equals(users.get(i).getUsername())) {
                        System.out.print("用户名重复,请重新输入:");
                        break loop1;
                    }
                }
                u1.setUsername(username);
                System.out.println("用户名输入正确!");
                break loop;
            }
        }
        //输入密码的判断
        System.out.println("请输入密码(格式不限):");
        loop2:
        while (true) {
            String password1 = sc.next();
            System.out.println("请再次输入密码,并与第一次输入保持一致:");
            String password2 = sc.next();
            if (password1.equals(password2)) {
                System.out.println("密码输入正确!");
                u1.setPassword(password1);
                break loop2;
            } else {
                System.out.println("两次密码不一致!请重新输入:");
            }
        }
        //身份证号码的判断
        System.out.println("请输入身份证号码:");
        loop3:
        while (true) {
            loop4:
            while (true) {
                String idnumber = sc.next();
                if (idnumber.length() != 18 || idnumber.charAt(0) == '0') {
                    System.out.println("身份证号码格式不正确!请重新输入:");
                    break loop4;
                } else if ((idnumber.charAt(17) < '0' || idnumber.charAt(17) > '9')
                        && idnumber.charAt(17) != 'X' && idnumber.charAt(17) != 'x') {
                    System.out.println("身份证号码格式不正确!请重新输入:");
                    break loop4;
                } else {
                    for (int i = 0; i < 17; i++) {
                        if (idnumber.charAt(i) < '0' || idnumber.charAt(i) > '9') {
                            System.out.println("身份证号码格式不正确!请重新输入:");
                            break loop4;
                        } else {
                            System.out.println("身份证号码输入成功!");
                            u1.setIdnumber(idnumber);
                            break loop3;
                        }
                    }
                }

            }
        }
        //手机号码的验证
        System.out.println("请输入手机号码:");
        loop5:
        while (true) {
            String phonenumber = sc.next();
            if (phonenumber.length() != 11 || phonenumber.charAt(0) == '0') {
                System.out.println("电话号码格式错误!,请重新输入:");
            } else {
                for (int i = 0; i < 11; i++) {
                    if (phonenumber.charAt(i) < '0' || phonenumber.charAt(i) > '9') {
                        System.out.println("电话号码格式错误!,请重新输入:");
                    } else {
                        System.out.println("电话号码输入正确!");
                        u1.setPhonenumber(phonenumber);
                        break loop5;
                    }
                }
            }
        }
        System.out.println("注册成功!");
        users.add(u1);
        return users;
    }

    public static boolean login(ArrayList<User> users) {
        String username = new String();
        Scanner sc = new Scanner(System.in);
        //登录有三次机会
        int count = 0;
        System.out.println("请输入用户名:");
        while (count < 3) {
            while (true) {
                String username1 = sc.next();
                boolean flag = exist(users, username1);
                if (flag) {
                    username = username1;
                    break;
                } else {
                    System.out.println("用户名不存在!请重新输入:");
                }
            }
            System.out.println("请输入密码:");
            String password = sc.next();
            //验证码环节
            while (true) {
                String verify1 = getverify();
                System.out.println("请输入验证码:");
                String verify2 = sc.next();
                if (verify1.equalsIgnoreCase(verify2)) {
                    break;
                } else {
                    System.out.println("验证码输入失败!");
                }
            }
            for (int i = 0; i < users.size(); i++) {
                if (username.equals(users.get(i).getUsername()) && password.equals(users.get(i).getPassword())) {
                    System.out.println("登录成功!");
                    return true;
                }
            }
            count++;
            System.out.println("用户名或密码错误!");
            System.out.println("还有" + (3 - count) + "次机会");
        }
        if (count == 3) {
            System.out.println("登录失败!");
            return false;
        }
        return true;
    }

    public static void forgetpassword(ArrayList<User> users) {
//        User u1 = new User();
        Scanner sc = new Scanner(System.in);
        System.out.println("输入要找回的用户名:");
        String username = sc.next();
        Boolean flag = exist(users, username);
        if (flag == false) {
            System.out.println("输入的用户名不存在!");
        } else {
            System.out.println("输入身份证号码:");
            String idnumber = sc.next();
            System.out.println("输入电话号码:");
            String phonenumber = sc.next();
            for (int i = 0; i < users.size(); i++) {
                if (phonenumber.equals(users.get(i).getPhonenumber()) && idnumber.equals(users.get(i).getIdnumber())) {
                    System.out.println("该用户的密码为:" + users.get(i).getPassword());
                    return;
                }
            }
            System.out.println("输入的身份证号码或电话号码错误!");
        }
    }

    public static boolean exist(ArrayList<User> users, String username) {//验证用户名是否存在于对象集合
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

    public static String getverify() {
        //生成验证码
        StringBuilder verify1 = new StringBuilder();
        String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String b = "0123456789";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            verify1.append(a.charAt(r.nextInt(52)));
        }

        verify1.append(b.charAt(r.nextInt(10)));
        char[] test = verify1.toString().toCharArray();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(5);
            char temp = test[index];
            test[index] = test[i];
            test[i] = temp;
        }
        //展示验证码
        String verify = new String(test);
        System.out.println("正确的验证码为:" + verify);
        return verify;
    }

}
