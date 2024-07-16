public class Summarize1 {
    public static void main(String[] args) {
        /*
         * IO流:存储和读写数据的解决方案(以程序为参照物读写)
         *
         * 分类:1.流的方向:输入流和输出流
         *     2.操作文件类型:字节流(操作所有文件)InputStream和OutputStream,可能会产生乱码(读取汉字不全或者编码解码方式不统一)
         *       和字符流(操作纯文本文件)Reader和Writer(在字节流的基础上加上字符集,英文读一个字节,中文读三个字节)
         *     3.读写数据实现步骤:
         *       创建对象(参数为路径字符串或者file对象,文件不存在会创建文件),
         *       读写数据(会覆盖数据,写的是整数对应的字符),还有特殊的换行写和续写(续写有开关),
         *       释放资源
         *       字节流读取多个数据时返回byte[],
         *       字符流返回的是char[](字符流输入流有缓冲区,会在缓冲区中读取数据read空参的方法返回的是十进制,有参的多了一步强转)
         *                       (字符流输出时也有缓冲区,数据先写在缓冲区中,缓冲区满或者flush()或者close()后数据写入文件中)
         *
         * 拷贝文件:
         *      拷贝的按字节存到字节数组中,拷贝速度看字节数组大小,其大小根据内存占用和速度均衡选择
         *
         * Unicode万国码字符集:utf-8:一个中文三个字节,一个英文一个字节
         *          编码getBytes 解码new String(byte[])
         *
         *IO流下有高级流->缓冲流(自带长度为8192的字节或字符数组缓冲区): BufferedInputStream,BufferedOutputStream,BufferedReader,,BufferedWriter
         *              字节缓冲流提高效率原理:直接在内存中读和取,与硬盘交互的次数变少,进而提高了效率
         *              字符缓冲流中reader有readLine方法读一行,writer中有nextLine方法换行,两个方法配合使用,因为readLine不能读取换行符
         *           ->转换流(字符流和字节流之间的桥梁,将字节流转换为字符流):InputStreamReader和OutputStreamWriter
         *           ->序列化流和反序列化流(属于字节流):ObjectInputStream和ObjectOutputStream,可以将java中的对象写到文件当中
         *              每次序列化和反序列化都会有相应的Long类型的序列号,如果修改了JavaBean,那么版本号会不一样
         *              保证即使修改了JavaBean版本号也一样的方法是在JavaBean中定义final serialVersion
         *              为了读取时方便,序列化时要定义一个对象的集合
         *           ->打印流(只有写,可以数据原样写出,字符打印流有缓冲区):PrintStream,PrintWriter
         *           ->压缩和解压缩流(输出和输入流):解压本质就是将压缩包中每一个ZipEntry对象按照层级拷贝到另一个文件夹中
         *        工具包:Commons-io
         *              Hutool
         * */
    }
}
