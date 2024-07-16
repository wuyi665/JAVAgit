package Multithreading;

import java.util.Random;

public class Test3 {
    public static void main(String[] args) {
        /*
         * 需求:一共100元的红包分成三个,一共五个人去抢,输出抢到的钱数
         * */
        Method m1 = new Method();
        Method m2 = new Method();
        Method m3 = new Method();
        Method m4 = new Method();
        Method m5 = new Method();
        m1.setName("孙悟空");
        m2.setName("猪八戒");
        m3.setName("沙和尚");
        m4.setName("唐三藏");
        m5.setName("白龙马");
        m1.start();
        m2.start();
        m3.start();
        m4.start();
        m5.start();
    }

    /*
     * 定义抢红包的线程
     * */
    static class Method extends Thread {
        @Override
        public void run() {
            synchronized (Test3.class) {
                try {
                    //红包数量为0跳出
                    if (Money.count == 0) {
                        System.out.println(getName() + "没有抢到红包");
                    } else {
                        //红包数量为1时拿到剩余所有钱
                        if (Money.count == 1) {
                            System.out.println(getName() + "抢到了" + Money.money + "元");
                            Money.money = 0;
                            Money.count--;
                        } else {
                            //随机红包钱数
                            Random r = new Random();
                            int a = r.nextInt(Money.money);
                            System.out.println(getName() + "抢到了" + a + "元");
                            Money.money -= a;
                            Money.count--;
                        }
                    }
                    this.interrupt();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

        /*
         * 定义红包
         * 有相应的钱数和红包个数
         * */
        static class Money {
            private static int money = 100;
            private static int count = 3;

            public Money(int money, int count) {
                this.money = money;
                this.count = count;
            }
        }
    }
}
