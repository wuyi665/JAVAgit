import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
 * 类的作用:产生一个动态代理
 * */
public class ProxyUtil {
    /*
     * 方法的作用:给一个对象创建一个代理
     * 形参:要产生代理的对象
     * 返回值:给该对象产生的代理
     * */
    public static Star createProxy(BigStar bigStar) {
        //参数1:指定的代理类加载器
        //参数2:指定接口
        //参数3:代理要做什么
        Star star = (Star) Proxy.newProxyInstance(
                ProxyUtil.class.getClassLoader(),
                new Class[]{Star.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //代理前置工作
                        if ("sing".equals(method.getName())) {
                            System.out.println("准备唱歌场地");
                        } else if ("dance".equals(method.getName())) {
                            System.out.println("准备跳舞场地");
                        }
                        //找代理对象进行操作方法
                        return method.invoke(bigStar, args);
                    }
                });
        return star;
    }
}
