package Multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedTest {

    public static void main(String[] args) {
        Count count1 = new Count("售票口1");
        Count count2 = new Count("售票口2");
        count1.start();
        count2.start();
    }

    static class Count extends Thread {
        //静态代码块只会加载一次
        static int i = 0;
        Lock lock = new ReentrantLock();

        public Count() {
        }

        public Count(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (true) {
                /*
                 * 用lock方式同步代码块
                 * while(true){
                 *  lock.lock();
                 *  try{
                 *      if(i==100) break;
                 *      else{
                 *          i++;
                 *          sout;
                 *      }
                 *      sleep();
                 *  }
                 *  catch(....){
                 *      e.printStack();
                 *  }
                 *  finally{
                 *      lock.unlock();
                 *  }
                 * }
                 *
                 * */
                //同步方法
                if (method()) break;
            }
        }

        /*
         * 作用:基于同一个内存地址不断修改内存地址的值
         *      修改到对应的值后返回true
         * */
        private synchronized boolean method() {
            if (i == 100) {
                return true;
            } else {
                i++;
                System.out.println(getName() + "正在卖第" + i + "张票");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return false;
        }
    }
}
