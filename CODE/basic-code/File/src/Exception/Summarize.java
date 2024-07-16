package Exception;

public class Summarize {
    public static void main(String[] args) {
        /*
         * 异常:程序出现的问题
         * 有运行时异常(RuntimeException)和编译时异常(继承自Exception)
         *作用:1.查询bug 2.作为方法内部特殊返回值,通知底层的执行情况
         *
         *异常的处理方式:
         * 1.JVM默认方式(打印在控制台,异常之后代码不再执行)
         * 2.自己处理(捕获异常try catch),好处是出现异常时会继续向下执行
         *      try中没有问题就继续往下执行,不会执行catch
         *      try中有多个异常,会写多个catch与之对应,不会执行try中异常处之后的代码
         *      没有catch到对应的异常,会采用虚拟机默认的处理方式
         * 3.抛出异常:throw(写在方法内,手动抛出异常对象)/throws(写在方法的定义处,告诉这个方法可能会有那些异常),也是之后代码不在执行
         *
         * throwable的成员方法
         * getmessage(),toString(),printStackTrace()->打印在控制台
         *
         * 自定义异常:让异常更加见名知意
         * */
    }
}
