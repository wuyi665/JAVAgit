package Multithreading;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args) {
        /*
         * 需求:使用阻塞队列实现等待唤醒机制
         *      生产者和消费者必须使用同一个阻塞队列
         * */
        //创建阻塞队列对象
        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(10);
        Producer p = new Producer(abq);
        Consumer c = new Consumer(abq);
        p.setName("厨师");
        c.setName("顾客");
        p.start();
        c.start();


    }

    /*
     * 作用:实现生产者
     * 步骤:循环 实现同步代码 判断是否满足条件
     * */
    static class Producer extends Thread {
        ArrayBlockingQueue<String> abq;

        public Producer(ArrayBlockingQueue<String> abq) {
            this.abq = abq;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    abq.put("资源");
//                    System.out.println(getName() + "生产一次资源");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
     * 作用:实现消费者
     * */
    static class Consumer extends Thread {
        ArrayBlockingQueue<String> abq;

        public Consumer(ArrayBlockingQueue<String> abq) {
            this.abq = abq;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    String taked = abq.take();
//                    System.out.println(getName() + "消费了一次" + taked);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
