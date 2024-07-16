package Multithreading;

public class Summarize {
    public static void main(String[] args) {
        /*
         * 进程:每一个程序的运行实体
         * 线程:操作系统进行运算调度的最小单位之一,包含在进程之内,是进程的实际运作单位
         *
         * 并发:多个指令在CPU上交替进行(每个指令有自己的程序计数器记录当前进度)
         * 并行:多个指令同时执行
         *
         * 线程创建方式:1.继承Thread的方式(相当于直接创建一个线程)
         *           2.实现Runnable接口的方式(创建一个实现方法的对象,再创建线程实现它)
         *           3.利用Callable和Future接口方式(可以获取到多线程运行结果)
         * 选择使用是看是否获取结果以及是否需要继承其他类
         *
         * Thread的常用成员方法:get/setName,currentThread,sleep,
         *                  set/getPriority(优先级1-10),setDaemon(守护,在非守护线程执行完毕之后陆续结束),
         *                  yield(礼让),join(插入)
         *
         * 线程状态:新建new,就绪runnable,阻塞block,等待waiting,计时等待timed waiting,运行,死亡terminated
         *
         * 想要线程安全的方式,可以用synchronized或者lock将相关代码锁住,让一次只有一个线程能够使用资源
         * 死锁相关内容
         *
         * 等待唤醒机制:生产者(生产数据)和消费者(消费数据)多线程协作模式
         *          有一个东西控制线程的执行
         *          第一种(消费者等待):消费者判断是否有资源,没有进入wait状态,生产者接管cpu,生产出资源之后notify消费者,消费者接管cpu
         *          第二种(生产者等待):生产者判断是否有资源,有就进入wait状态,消费者接管cpu,消费完资源之后notify生产者,生产者接管cpu
         *      等待唤醒机制可以使用阻塞队列:ArrayBlockingQueue(数组,有界)和LinkedBlockingQueue(链表,长度为int最大值)
         *
         * 线程池(Executors):核心线程数,阻塞队列,最大线程数(cpu密集型和io密集型),空闲时间,空闲时间单位,拒绝策略(默认丢弃抛出异常),线程工厂
         * */
    }
}
