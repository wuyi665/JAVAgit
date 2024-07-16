package UI;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Registerjframe extends javax.swing.JFrame implements MouseListener {

    //用户信息
    static ArrayList<User> userslist = new ArrayList<>();
    static User u1 = new User("wuyi", "123456");
    //注册相关代码
    //创建返回登陆JLabel
    JLabel relogin = new JLabel();
    //创建注册按钮
    JButton register1 = new JButton();
    //创建重置按钮
    JButton reloading = new JButton();
    //创造三个文本输入框
    JTextField registeruesrname = new JTextField();

    JTextField registerpassword1 = new JTextField();

    JTextField registerpassword2 = new JTextField();//默认都能输入

    public Registerjframe() {
        userslist.add(u1);
        //初始化图片
        this.initimage();
        //初始化界面
        this.initjframe();

    }

    public void initjframe() {
        this.setSize(488, 430);
        this.setVisible(true);
        //设置界面标题
        this.setTitle("拼图小游戏v1.0注册");
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
        relogin.setText("点击我返回登录界面");
        relogin.setBounds(200,350,100,20);
        this.getContentPane().add(relogin);

        //添加注册用户名文字
        JLabel usernameimage = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\注册用户名.png"));
        usernameimage.setBounds(100, 135, 79, 17);
        this.getContentPane().add(usernameimage);
        //添加用户名输入框
        registeruesrname.setBounds(200, 134, 200, 30);
        this.getContentPane().add(registeruesrname);

        //添加注册密码
        JLabel passwordimage1 = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\注册密码.png"));
        passwordimage1.setBounds(100, 195, 64, 16);
        this.getContentPane().add(passwordimage1);
        //添加密码输入框
        registerpassword1.setBounds(200, 195, 200, 30);
        this.getContentPane().add(registerpassword1);
        //添加再次输入密码
        JLabel passwordimage2 = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\再次输入密码.png"));
        passwordimage2.setBounds(100, 256, 97, 16);
        this.getContentPane().add(passwordimage2);
        //添加密码输入框
        registerpassword2.setBounds(200, 256, 200, 30);
        this.getContentPane().add(registerpassword2);

        //添加重置按钮
        reloading.setBounds(123, 300, 128, 47);
        reloading.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\重置按钮.png"));
        //去除按钮的边框
        reloading.setBorderPainted(false);
        //去除按钮的背景
        reloading.setContentAreaFilled(false);
        this.getContentPane().add(reloading);

        //添加注册按钮
        register1.setBounds(256, 300, 128, 47);
        register1.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\注册按钮.png"));
        //去除按钮的边框
        register1.setBorderPainted(false);
        //去除按钮的背景
        register1.setContentAreaFilled(false);
        this.getContentPane().add(register1);

        //绑定鼠标事件
        reloading.addMouseListener(this);
        register1.addMouseListener(this);
        relogin.addMouseListener(this);

        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\background.png"));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == register1) {
            //获取两个文本输入框中的内容
            String usernameInput = registeruesrname.getText();
            String passwordInput1 = registerpassword1.getText();
            String passwordInput2 = registerpassword2.getText();
            if (usernameInput.length() == 0 || passwordInput1.length() == 0 || passwordInput2.length() == 0) {
                getdialog("输入不能为空!");
            } else if (exist(userslist, usernameInput)) {
                getdialog("用户名重复!");
            } else if (!passwordInput1.equals(passwordInput2)) {
                getdialog("两次密码不一致!");
            } else {
                getdialog("注册成功");
                //关闭当前登录界面
                this.setVisible(false);
                //打开游戏的主界面
                //需要把当前登录的用户名传递给游戏界面
                new Loginjframe();
            }
        } else if (e.getSource() == reloading) {
            registeruesrname.setText("");
            registerpassword1.setText("");
            registerpassword2.setText("");
        } else if (e.getSource()==relogin) {
            this.setVisible(false);
            new Loginjframe();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == reloading) {
            reloading.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\重置按下.png"));
            System.out.println("按住重置");
        } else if (e.getSource() == register1) {
            register1.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\注册按下.png"));
            System.out.println("按住注册");
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == reloading) {
            reloading.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\重置按钮.png"));
            System.out.println("松开重置");
        } else if (e.getSource() == register1) {
            register1.setIcon(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\register\\注册按钮.png"));
            System.out.println("松开注册");
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

    public static boolean exist(ArrayList<User> users, String username) {//验证用户名是否存在于对象集合
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(users.get(i).getUsername())) {
                return true;
            }
        }
        return false;
    }

}
