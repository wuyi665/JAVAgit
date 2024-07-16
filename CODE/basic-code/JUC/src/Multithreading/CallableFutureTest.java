package Multithreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableFutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建执行任务的对象
        MyCallable myCallable = new MyCallable();
        //创建FutureTask对象管理运行结果
        FutureTask<String> futureTask = new FutureTask<>(myCallable);
        //创建线程对象
        Thread t1 = new Thread(futureTask);
        t1.start();
        //获取运行结果
        String s = futureTask.get();
        System.out.println(s);
    }

    /*
     * 创建执行任务的对象并返回执行结果
     * */
    static class MyCallable implements Callable<String> {
        @Override
        public String call() throws Exception {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            return String.valueOf(sum);
        }
    }
}
