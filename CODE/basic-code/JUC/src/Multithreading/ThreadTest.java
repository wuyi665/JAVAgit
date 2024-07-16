package Multithreading;

public class ThreadTest {
    public static void main(String[] args) {
        /*
         * 多线程的第一种启动方式
         * 定义一个类继承thread
         * 重写run方法
         * 创建对象
         * */
        MyThread t1 = new MyThread("线程1");
        MyThread t2 = new MyThread("线程2");
        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());
        System.out.println(Thread.currentThread().getName() + Thread.currentThread().getPriority());
//        t1.start();
//        t2.start();
    }

    static class MyThread extends Thread {
        public MyThread() {
        }

        public MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            //线程执行代码
            for (int i = 0; i < 100; i++) {
                System.out.println(getName() + "HelloMyThread");
            }
        }
    }
}
