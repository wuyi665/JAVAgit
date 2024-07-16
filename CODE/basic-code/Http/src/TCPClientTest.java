import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class TCPClientTest {
    public static void main(String[] args) throws IOException {
        /*
         * 练习TCP通信协议
         * 客户端发送数据
         * */
        //创建socket对象的同时连接服务端
        Socket socket = new Socket("DESKTOP-6QQ37E0", 10086);
        //从连接通道中获取输出流
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8);
        //获取输入流接收回写数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8);
        Scanner sc = new Scanner(System.in);
        while (true) {
            //写出数据
            System.out.print("请输入发送信息:");
            String str = sc.nextLine();
            if (str.equals("exit")) {
                break;
            } else {
                osw.write(str);
                osw.write("\r\n");
                //缓冲流要加flush()刷新
                osw.flush();
            }
            socket.shutdownOutput();
            int s;
            while ((s = isr.read()) != -1) {
                System.out.print((char) s);
            }
        }

        //释放资源
        socket.close();
    }
}
