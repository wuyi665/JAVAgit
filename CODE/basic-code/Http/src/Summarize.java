public class Summarize {
    public static void main(String[] args) {
        /*
         * 常用网络架构:CS(体验好,开发维护难)和BS(方便但是体验不好)
         *
         * 三要素:ip,端口号,协议
         * ip:ipv4(32位分四组)不够用,又设计了ipv6(128位分8组)
         *       InetAddress表示Ip地址
         * 端口号:设备中应用程序的地址
         * 协议:TCP/IP协议
         *       UDP面向无连接通信协议:速度快,有大小限制,但数据容易丢失
         *           UDP三种通信方式:单播组播广播
         *       TCP面向连接通信协议:速度慢但无大小限制且数据安全
         *          保证发送数据之前连接已经建立(三次握手),之后通过socket建立IO流进行数据传输
         * */
    }
}
