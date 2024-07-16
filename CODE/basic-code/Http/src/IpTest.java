import java.net.InetAddress;
import java.net.UnknownHostException;

public class IpTest {
    public static void main(String[] args) throws UnknownHostException {
        //创建Ip对象
        InetAddress ip = InetAddress.getByName("DESKTOP-6QQ37E0");
        System.out.println(ip);
    }
}
