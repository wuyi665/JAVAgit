package Multithreading;

public class Test2 {
    public static void main(String[] args) {
        /*
         * 需求:两个线程同时获取1-100中整数并且输出奇数
         * */
        Method m1 = new Method();
        Method m2 = new Method();
        m1.setName("P1");
        m2.setName("P2");
        m1.start();
        m2.start();
    }

    /*
     * 定义线程执行的任务
     * */
    static class Method extends Thread {
        static int i = 1;
        static int max = 100;

        @Override
        public void run() {
            while (true) {
                synchronized (Test2.class) {
                    if (i == max + 1) {
                        break;
                    } else {
                        if (i % 2 == 1) System.out.println(getName() + "获得的奇数是:" + i);
                        i++;
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
}
