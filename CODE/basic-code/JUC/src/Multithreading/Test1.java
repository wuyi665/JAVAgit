package Multithreading;

public class Test1 {
    public static void main(String[] args) {
        /*
         * 需求:两个窗口卖1000张电影票,多线程模拟卖票过程
         * */
        Method m1 = new Method();
        Method m2 = new Method();
        m1.setName("售票口1");
        m2.setName("售票口2");
        m1.start();
        m2.start();
    }

    /*
     * 定义线程进行卖票任务
     * */
    static class Method extends Thread {
        static int tickets = 1000;

        public void run() {
            while (true)
                synchronized (Test1.class) {
                    if (tickets == 0)
                        break;
                    else {
                        tickets--;
                        System.out.println(getName() + "卖出一张票,还剩" + tickets + "张票");
                        try {
                            sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }
    }
}
