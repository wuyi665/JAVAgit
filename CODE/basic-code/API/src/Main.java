import java.io.IOException;
import java.math.BigInteger;
import java.util.Random;

/*
查看源码ctrl+alt+b
常用API:记一下类名和类的作用,具体用法查询api帮助文档
Math:abs  ceil向上取整  floor向下取整  round四舍五入  max  min  pow(a,b)获得a的b次幂  sqrt开平方  cbrt开立方

System:exit  currentTimeMillis返回当前系统时间毫秒值形式(1970年1月1日8点)
       arraycopy数组拷贝(数组内是基本数据类型时,两数组数据类型要一致;如果都是引用数据类型,那么子类也可以拷贝给父类,反之不行)

Runtime(表示当前虚拟机的运行环境):exit  getRuntime(返回当前系统的运行环境对象)
       availableProcessors(获得cpu线程数)   maxMemory(虚拟机能获得的总内存大小,单位为byte)
       totalMemory(虚拟机已经获得的内存大小)   freeMemory(虚拟机剩余内存大小)
       exec(运行cmd)

Object(顶级父类):toString(println自动调用这个方法,如果想要打印的不是对象的地址值,可以对toString方法进行重写,前面下载的ptg插件可以自动重写该方法)
       equals(跟toString一样,想要比较对象的属性值而不是地址值也要进行重写,alt+insert即可)
       clone(调用时先重写clone方法,让想要克隆的对象实现cloneable接口,之后才能调用clone)
       克隆方式一为浅克隆:引用数据类型全部把地址值克隆走,在堆内存中访问同一片空间,一个修改,另一个也会跟着改变
             二为深克隆:字符串这种不可变的直接拷贝地址值,数组这种重新创造一个数组,将原有数据拷贝进去,数组地址已经改变
       正常重写的clone方法为浅克隆,想要深克隆要在clone方法中自己创建

Objects(工具类):常用的equals对比字符串的内容,Objects.equals可以对比对象中的属性值是否完全相同
                isnull,nonnull

BigInteger:可以记录超出比特位的整数(一旦创造了该对象,内部记录的值不能改变)
            经典的加减乘除次幂比大小方法

BigDecimal:(用于小数的精确运算,在计算机中小数位数的存储空间有限,如果超出就会造成计算误差)
            bigdecimal底层存储是把每个元素转换为对应的ASCII码表元素之后存储

包装类:将基础数据类型包装为引用数据类型     有自动拆装箱
    成员方法:toxxxString得到多少进制的相应字符串  parseInt解析为整数   除了Character都有parse方法
            之后在键盘录入时可以全部录入为字符串之后用相应的parse方法转换类型

 */
public class Main {
    public static void main(String[] args) throws IOException {
//        System.out.println(Runtime.getRuntime().availableProcessors());
//        System.out.println(Runtime.getRuntime().maxMemory() / 1024 / 1024);
//        System.out.println(Runtime.getRuntime().totalMemory() / 1024 / 1024);
//        //shutdown  cmd命令
//        //-s默认一分钟后关机
//        //-s -t指定关机时间,单位为秒
//        //-a取消关机操作
//        //-r关机并重启
//        Runtime.getRuntime().exec("shutdown -a");
        int n = 4;
        BigInteger bd1 = new BigInteger(n, new Random());//随机整数,范围为2的n次方-1
        BigInteger bd2 = new BigInteger("9999999999999", 10);//创造指定的大整数,radix表示进制
        BigInteger bd3 = BigInteger.valueOf(100);//静态方法获取biginteger的对象

    }
}