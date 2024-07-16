import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPSendTest {
    public static void main(String[] args) throws IOException {
        /*
         * 练习UDP通信协议
         * 发送数据
         * */

        //创建socket对象(相当于快递公司)
        DatagramSocket socket = new DatagramSocket();
        //打包数据
        String str = "Hello World!";
        byte[] bytes = str.getBytes();
        //定义要发送到的ip
        InetAddress ip = InetAddress.getByName("DESKTOP-6QQ37E0");
        //定义端口号
        int port = 10086;
        //打包数据(相当于包裹)
        DatagramPacket packet = new DatagramPacket(bytes, bytes.length, ip, port);
        //发送数据
        socket.send(packet);
        //释放资源
        socket.close();


    }
}
