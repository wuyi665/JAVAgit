package Multithreading;

public class RunnableTest {
    public static void main(String[] args) {
        //创建执行任务对象
        MyRunnable runnable = new MyRunnable();
        //创建线程对象
        Thread t1 = new Thread(runnable);
        t1.setName("线程1");
        t1.start();
        Thread t2 = new Thread(runnable);
        t2.setName("线程2");
        t2.start();
    }

    /*
     * 实现MyRunnable对象完成一个任务
     * */
    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 50; i++) {
                //获取当前线程对象
                Thread t = Thread.currentThread();
                System.out.println(t.getName() + "HelloMyRun");
            }
        }
    }
}
