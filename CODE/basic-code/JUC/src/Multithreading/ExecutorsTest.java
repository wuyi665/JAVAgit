package Multithreading;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {
    public static void main(String[] args) {
        /*
         * 构建线程池
         * */
        //获取线程池对象
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,
                6,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        //创建任务对象
        GetSum getSum = new GetSum();

        //提交任务
        pool.submit(getSum);

        //销毁线程池
        pool.shutdown();
    }

    /*
     * 创建对象执行任务
     * */
    static class GetSum implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
            }
        }
    }
}
