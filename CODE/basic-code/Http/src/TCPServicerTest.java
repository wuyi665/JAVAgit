import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServicerTest {
    public static void main(String[] args) throws IOException {
        /*
         * 练习TCP通信协议
         * 服务端接受数据
         * */
        //创建服务端对象
        ServerSocket serverSocket = new ServerSocket(10086);
        //监听客户端连接
        Socket socket = serverSocket.accept();
        //从连接通道中获取输入流读取数据
        InputStreamReader isr = new InputStreamReader(socket.getInputStream());
        //获取输出流回写数据
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        int s;
        while ((s = isr.read()) != -1) {
            System.out.print((char) s);
        }
        osw.write("已经收到数据");
        osw.flush();
        //释放资源
        socket.close();
        serverSocket.close();
    }
}
