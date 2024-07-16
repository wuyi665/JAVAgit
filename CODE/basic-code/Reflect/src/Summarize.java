public class Summarize {
    public static void main(String[] args) {
        /*
         * 反射:允许对成员变量,成员方法和构造方法进行编程访问,类中的东西是从class字节码文件中获取的
         *   通过反射可以获取到对象中所有的东西
         *   获取class对象的三种方式:1.Class.forName("全类名);
         *                       2.类名.class
         *                       3.对象.getClass();
         *   获取构造方法Constructor:getConstructors()->获取公共的所有构造方法  getDeclaredConstructors()->获取所有构造方法
         *   获取成员变量Field:与上面一致
         *   获取成员方法Method:与上面一致,Object invoke(Object obj,Object...args):运行获取出来的方法,用obj调用,args为方法参数
         *
         * 动态代理:无侵入式地给代码增加额外的功能
         *      Proxy这个类是产生动态代理的方法
         * */
    }
}
