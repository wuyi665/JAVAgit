import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPReceiveTest {
    public static void main(String[] args) throws IOException {
        /*
         * 练习UDP通信协议
         * 接收数据
         * */

        //找到socket对象(找到快递公司)
        //并且找到包裹位置
        DatagramSocket udpSocket = new DatagramSocket(10086);
        //找到接收数据包
        byte[] buf = new byte[1024];
        DatagramPacket udpPacket = new DatagramPacket(buf, buf.length);
        udpSocket.receive(udpPacket);
        //解析数据
        System.out.println(new String(udpPacket.getData(), 0, udpPacket.getLength()));
        //释放资源
        udpSocket.close();
    }
}
