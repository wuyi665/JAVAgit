package UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

public class Loginjframe extends JFrame implements MouseListener {
    //用户信息
    static ArrayList<User> userslist = new ArrayList<>();
    static User u1 = new User("wuyi", "123456");
    //是事件源的写在成员变量部分

    //创建验证码
    JLabel yanzhengma = new JLabel();
    //创建登录按钮
    JButton login = new JButton();
    //JLabel login = new JLabel(new ImageIcon(path + "登录按钮.png"));
    //创建注册按钮
    JButton register = new JButton();
    //JLabel register = new JLabel(new ImageIcon(path + "注册按钮.png"));
    //创建显示密码按钮
    JButton showpassword = new JButton();
    //JLabel showpassword = new JLabel(new ImageIcon(path + "显示密码.png"));
    //创造三个文本输入框
    JTextField inputuesrname = new JTextField();

    JPasswordField inputpassword = new JPasswordField();

    JTextField inputverify = new JTextField();//默认都能输入

    //登录相关代码
    public Loginjframe() {
        userslist.add(u1);
        //初始化界面图片
        this.initimage();
        //初始化界面
        this.initjframe();


    }

    public void initjframe() {
        this.setSize(488, 430);
        this.setVisible(true);
        //设置界面标题
        this.setTitle("拼图小游戏v1.0登录");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initimage() {
        //添加用户名文字
        JLabel usernameimage = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\用户名.png"));
        usernameimage.setBounds(116, 134, 47, 17);
        this.getContentPane().add(usernameimage);
        //添加用户名输入框
        inputuesrname.setBounds(195, 134, 200, 30);
        this.getContentPane().add(inputuesrname);

        //添加密码文字
        JLabel passwordimage = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\密码.png"));
        passwordimage.setBounds(130, 195, 32, 16);
        this.getContentPane().add(passwordimage);
        //添加密码输入框
        inputpassword.setBounds(195, 195, 200, 30);
        inputpassword.setEchoChar('*');
        this.getContentPane().add(inputpassword);
        //添加显示密码按钮
        showpassword.setBounds(400, 195, 18, 29);
        showpassword.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\显示密码.png"));
        //去除按钮的边框
        showpassword.setBorderPainted(false);
        //去除按钮的背景
        showpassword.setContentAreaFilled(false);
        this.getContentPane().add(showpassword);

        //添加验证码文字
        JLabel verifyimage = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\验证码.png"));
        verifyimage.setBounds(133, 256, 50, 30);
        this.getContentPane().add(verifyimage);
        //添加验证码输入框
        inputverify.setBounds(195, 256, 100, 30);
        this.getContentPane().add(inputverify);
        //添加正确验证码

        String verify2 = getverify();
        //正确验证码位置设置
        yanzhengma.setText(verify2);
        yanzhengma.setBounds(300, 256, 50, 30);
        this.getContentPane().add(yanzhengma);

        //添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\登录按钮.png"));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        this.getContentPane().add(login);

        //添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        //绑定鼠标事件
        yanzhengma.addMouseListener(this);
        login.addMouseListener(this);
        register.addMouseListener(this);
        showpassword.addMouseListener(this);


        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    public static String getverify() {
        //生成验证码
        StringBuilder verifybuilder = new StringBuilder();
        String a = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String b = "0123456789";
        Random r = new Random();
        for (int i = 0; i < 4; i++) {
            verifybuilder.append(a.charAt(r.nextInt(52)));
        }

        verifybuilder.append(b.charAt(r.nextInt(10)));
        char[] test = verifybuilder.toString().toCharArray();
        for (int i = 0; i < 5; i++) {
            int index = r.nextInt(5);
            char temp = test[index];
            test[index] = test[i];
            test[i] = temp;
        }
        //展示验证码
        String rightverify = new String(test);
        System.out.println("正确的验证码为:" + rightverify);
        return rightverify;
    }//生成验证码

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == yanzhengma) {
            System.out.println("正在更换验证码");
            //创建正确验证码
            String verify = getverify();
            yanzhengma.setText(verify);
        } else if (e.getSource() == login) {
            //获取两个文本输入框中的内容
            String usernameInput = inputuesrname.getText();
            String passwordInput = inputpassword.getText();
            //获取用户输入的验证码
            String verifyInput = inputverify.getText();
            if (verifyInput.length() == 0) {
                System.out.println("验证码为空");
                getdialog("验证码不能为空!");
            } else if (usernameInput.length() == 0 || passwordInput.length() == 0) {
                System.out.println("用户名和密码为空");
                getdialog("用户名和密码不能为空!");
            } else if (!verifyInput.equalsIgnoreCase(yanzhengma.getText())) {
                System.out.println("验证码错误");
                getdialog("验证码输入错误!");
            } else if ((usernameInput.equals(u1.getUsername())) && (passwordInput.equals(u1.getPassword()))) {
                System.out.println("用户名和密码正确可以开始玩游戏了");
                //关闭当前登录界面
                this.setVisible(false);
                //打开游戏的主界面
                //需要把当前登录的用户名传递给游戏界面
                new APPjframe();
            } else {
                System.out.println("用户名或密码错误");
                getdialog("用户名或密码错误!");
            }
            System.out.println("单击登录");
        } else if (e.getSource() == register) {
            System.out.println("单击注册");
            //关闭当前登录界面
            this.setVisible(false);
            new Registerjframe();
        } else if (e.getSource() == showpassword) {
            System.out.println("显示密码");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\登录按下.png"));
            System.out.println("按住登录");
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\注册按下.png"));
            System.out.println("按住注册");
        } else if (e.getSource() == showpassword) {
            showpassword.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\显示密码按下.png"));
            System.out.println("按住显示密码");
            inputpassword.setEchoChar((char) 0);
        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\登录按钮.png"));
            System.out.println("松开登录");
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\注册按钮.png"));
            System.out.println("松开注册");
        } else if (e.getSource() == showpassword) {
            showpassword.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\login\\显示密码.png"));
            System.out.println("松开显示密码");
            inputpassword.setEchoChar('*');
        }


    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public void getdialog(String text) {
        //创建一个弹框
        JDialog jdialog = new JDialog();
        JLabel tishi = new JLabel(text);
        tishi.setBounds(25, 25, 100, 100);//相对于弹框的位置
        jdialog.getContentPane().add(tishi);
        //设置弹框大小
        jdialog.setSize(150, 150);
        //弹框置顶
        jdialog.setAlwaysOnTop(true);
        //设置弹框的位置
        jdialog.setLocationRelativeTo(null);
        //弹框不关闭无法操作下面界面
        jdialog.setModal(true);
        //显示弹框
        jdialog.setVisible(true);
    }
}
