package UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class APPjframe extends JFrame implements KeyListener, ActionListener {
    //定义使用图片的路径
    String path = "D:\\JAVA\\CODE\\Game\\素材\\image\\animal\\animal3\\";
    //定义空白图片的位置
    int zerox = 0;
    int zeroy = 0;
    int[][] image = new int[4][4];
    int[][] win = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 0}
    };
    //定义步数
    int count = 0;

    //创建选项下的条目对象
    JMenuItem replay = new JMenuItem("重新游戏");
    JMenuItem relogin = new JMenuItem("重新登录");
    JMenuItem closegame = new JMenuItem("关闭游戏");
    JMenuItem animals = new JMenuItem("动物");
    JMenuItem girls = new JMenuItem("美女");
    JMenuItem sports = new JMenuItem("运动");
    JMenuItem kankan = new JMenuItem("你真点开啊");

    //主界面相关代码
    public APPjframe() {
        //初始化界面
        this.initJFrame();
        //初始化菜单
        this.JMenuBar();
        //打乱图片索引
        this.randomimage();
        //初始化图片
        this.initimage();
        //初始化按钮
        //button();


        this.setVisible(true);//默认隐藏,设置后会出现,建议写在最后
    }

    private void initimage() {
        //清空原本出现的所有图片
        this.getContentPane().removeAll();

        //创建一个显示步数的管理容器
        JLabel stepslabel = new JLabel("步数:" + count);
        stepslabel.setBounds(50, 30, 100, 20);
        this.getContentPane().add(stepslabel);

        //如果成功
        if (victory()) {
            JLabel winlabel = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\win.png"));
            winlabel.setBounds(203, 283, 197, 73);
            this.getContentPane().add(winlabel);
        }

        //添加多个图片时,先加载的图层在上
        //打乱图片索引
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                //创建一个JLabel对象（管理容器）
                JLabel label = new JLabel(new ImageIcon(path + image[i][j] + ".jpg"));
                //指定图片位置
                label.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                //给图片添加边框
                label.setBorder(new BevelBorder(0));
                //把管理容器添加到界面
                //this.add(label);
                this.getContentPane().add(label);
            }
        }
        //添加背景图片
        JLabel background = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\background.png"));
        background.setBounds(40, 40, 508, 560);
        this.getContentPane().add(background);
        //刷新一下
        this.getContentPane().repaint();


    }

    private void randomimage() {
        int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        //打乱图片顺序
        for (int i = 0; i < a.length; i++) {
            int index = r.nextInt(a.length);
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        for (int i = 0; i < a.length; i++) {
            if (a[i] == 0) {
                zerox = i / 4;
                zeroy = i % 4;
            }
            image[i / 4][i % 4] = a[i];
        }
    }

    private void JMenuBar() {
        //初始化菜单
        JMenuBar menuBar = new JMenuBar();

        //创建菜单上两个选项
        JMenu function1 = new JMenu("功能");
        JMenu function2 = new JMenu("点开看看");
        JMenu changeimage = new JMenu("更换图片");


        //对应添加
        function1.add(changeimage);
        function1.add(replay);
        function1.add(relogin);
        function1.add(closegame);
        function2.add(kankan);
        changeimage.add(animals);
        changeimage.add(girls);
        changeimage.add(sports);
        menuBar.add(function1);
        menuBar.add(function2);
        //给整个界面设置菜单
        this.setJMenuBar(menuBar);
        //给整个界面增加一个动作监听
        animals.addActionListener(this);
        girls.addActionListener(this);
        sports.addActionListener(this);
        replay.addActionListener(this);
        relogin.addActionListener(this);
        closegame.addActionListener(this);
        kankan.addActionListener(this);
    }

    private void initJFrame() {
        this.setSize(603, 680);//表示像素
        //设置界面标题
        this.setTitle("拼图小游戏v1.0");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//四种模式
        //给整个界面增加一个键盘监听
        this.addKeyListener(this);


    }

    public void button() {
        //创建按钮
        JButton button = new JButton("点击我");
        //设置宽高
        button.setBounds(0, 0, 100, 50);
        //给按钮添加动作监听
        button.addActionListener(new ActionListener() {
            //匿名内部类形式
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("我被电击!!!");
            }
        });
        //添加到界面中
        this.getContentPane().add(button);

    }//按钮类用法

    private boolean victory() {
        //判断是否成功
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (win[i][j] != image[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        //判断是否胜利,胜利直接结束监视器
        if (victory()) {
            return;
        }
        int keycode = e.getKeyCode();
        if (keycode == 32) {
            //删除全部图片
            this.getContentPane().removeAll();

            //创建一个显示步数的管理容器
            JLabel stepslabel = new JLabel("步数:" + count);
            stepslabel.setBounds(50, 30, 100, 20);
            this.getContentPane().add(stepslabel);

            //加载完整图片
            //创建一个JLabel对象（guanlirongqi）
            JLabel label = new JLabel(new ImageIcon(path + "all.jpg"));
            //指定图片位置
            label.setBounds(83, 134, 105 * 4, 105 * 4);
            //给图片添加边框
            label.setBorder(new BevelBorder(0));
            //把管理容器添加到界面
            //this.add(label);
            this.getContentPane().add(label);
            //加载背景图片
            JLabel background = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新一下
            this.getContentPane().repaint();

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //判断是否胜利,胜利直接结束监视器
        if (victory()) {
            return;
        }
        int keycode = e.getKeyCode();
        if (keycode == 37) {
            if (zeroy < 3) {
                System.out.println("向左移动");
                image[zerox][zeroy] = image[zerox][zeroy + 1];
                image[zerox][zeroy + 1] = 0;
                zeroy++;
                count++;
            }
            initimage();
        } else if (keycode == 38) {
            if (zerox < 3) {
                System.out.println("向上移动");
                image[zerox][zeroy] = image[zerox + 1][zeroy];
                image[zerox + 1][zeroy] = 0;
                zerox++;
                count++;
            }
            initimage();
        } else if (keycode == 39) {
            if (zeroy > 0) {
                System.out.println("向右移动");
                image[zerox][zeroy] = image[zerox][zeroy - 1];
                image[zerox][zeroy - 1] = 0;
                zeroy--;
                count++;
            }
            initimage();
        } else if (keycode == 40) {
            if (zerox > 0) {
                System.out.println("向下移动");
                image[zerox][zeroy] = image[zerox - 1][zeroy];
                image[zerox - 1][zeroy] = 0;
                zerox--;
                count++;
            }
            initimage();
        } else if (keycode == 32) {//空格查看完整图片
            //删除全部图片
            this.getContentPane().removeAll();

            //创建一个显示步数的管理容器
            JLabel stepslabel = new JLabel("步数:" + count);
            stepslabel.setBounds(50, 30, 100, 20);
            this.getContentPane().add(stepslabel);

            //加载完整图片
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    //创建一个JLabel对象（guanlirongqi）
                    JLabel label = new JLabel(new ImageIcon(path + image[i][j] + ".jpg"));
                    //指定图片位置
                    label.setBounds(105 * j + 83, 105 * i + 134, 105, 105);
                    //给图片添加边框
                    label.setBorder(new BevelBorder(0));
                    //把管理容器添加到界面
                    //this.add(label);
                    this.getContentPane().add(label);
                }
            }
            //加载背景图片
            JLabel background = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\background.png"));
            background.setBounds(40, 40, 508, 560);
            this.getContentPane().add(background);
            //刷新一下
            this.getContentPane().repaint();
        } else if (keycode == 27) {//作弊按键为esc
            int[][] win1 = {
                    {1, 2, 3, 4},
                    {5, 6, 7, 8},
                    {9, 10, 11, 12},
                    {13, 14, 15, 0}
            };
            count = 666;
            image = win1;
            initimage();
        } else {
            System.out.println(keycode);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == animals) {
            Random r = new Random();
            int p = r.nextInt(8) + 1;
            path = "D:\\JAVA\\CODE\\Game\\素材\\image\\animal\\animal" + p + "\\";
            //打乱图片索引
            randomimage();
            //计步器清零
            count = 0;
            //初始化图片
            initimage();
        } else if (e.getSource() == girls) {
            Random r = new Random();
            int p = r.nextInt(11) + 1;
            path = "D:\\JAVA\\CODE\\Game\\素材\\image\\girl\\girl" + p + "\\";
            //打乱图片索引
            randomimage();
            //计步器清零
            count = 0;
            //初始化图片
            initimage();
        } else if (e.getSource() == sports) {
            Random r = new Random();
            int p = r.nextInt(10) + 1;
            path = "D:\\JAVA\\CODE\\Game\\素材\\image\\sport\\sport" + p + "\\";
            //打乱图片索引
            randomimage();
            //计步器清零
            count = 0;
            //初始化图片
            initimage();
        } else if (e.getSource() == replay) {
            //打乱图片索引
            randomimage();
            //计步器清零
            count = 0;
            //初始化图片
            initimage();
        } else if (e.getSource() == relogin) {
            this.setVisible(false);
            new Loginjframe();
        } else if (e.getSource() == closegame) {
            System.exit(0);
        } else if (e.getSource() == kankan) {
            //创建一个弹框
            JDialog jdialog = new JDialog();
            JLabel damie = new JLabel(new ImageIcon("D:\\JAVA\\CODE\\Game\\素材\\image\\damie.jpg"));
            damie.setBounds(0, 0, 99, 100);//相对于弹框的位置
            jdialog.getContentPane().add(damie);
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
}
