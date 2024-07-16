package Multithreading;

public class WaitAndNotifyTest {
    public static void main(String[] args) {
        /*实现等待唤醒机制
         * 控制生产者和消费者之间的协作
         * */
        //创建线程对象
        Producer producer = new Producer();
        Consumer consumer = new Consumer();
        producer.setName("生产者");
        consumer.setName("消费者");
        //启动线程
        producer.start();
        consumer.start();

    }

    /*
     * 作用:实现生产者
     * 步骤:循环 实现同步代码 判断是否满足条件
     * */
    static class Producer extends Thread {
        @Override
        public void run() {
            while (true) {
                //获取锁对象
                synchronized (Desk.lock) {
                    if (Desk.count == 0) {
                        break;
                    } else {
                        //如果有资源进入等待
                        if (Desk.flag == 1) {
                            try {
                                Desk.lock.wait();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            //没有资源生产后唤醒消费者
                            System.out.println("生产者生产一次");
                            Desk.flag = 1;
                            Desk.lock.notifyAll();
                        }
                    }
                }
            }
        }
    }

    /*
     * 作用:实现消费者
     * */
    static class Consumer extends Thread {
        @Override
        public void run() {
            while (true) {
                //获取锁
                synchronized (Desk.lock) {
                    if (Desk.count == 0) {
                        break;
                    } else {
                        //判断是否有资源
                        if (Desk.flag == 1) {
                            Desk.count--;
                            System.out.println("消费者消费一次,还能消费" + Desk.count + "次");
                            //消费完后唤醒生产者生产资源
                            Desk.lock.notifyAll();
                            Desk.flag = 0;
                        } else {
                            //没有资源陷入等待
                            try {
                                Desk.lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }

        }
    }

    /*
     * 作用:实现生产者和消费者之间的中间量
     * */
    static class Desk {
        //0:没有资源 1:有资源
        public static int flag = 0;
        //总个数
        public static int count = 10;
        //锁对象
        static Object lock = new Object();
    }
}
