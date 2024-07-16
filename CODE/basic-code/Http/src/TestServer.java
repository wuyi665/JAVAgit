import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServer {
    public static void main(String[] args) throws IOException {
        /*
         * 需求:服务器接收客户端上传的文件并给出反馈信息
         * */
        //获取socket对象接收端口信息
        ServerSocket serverSocket = new ServerSocket(10086);
        //监听客户端
        Socket socket = serverSocket.accept();
        //获取输入流接收文件
        BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
        //获取保存文件的流
        File file = new File("C:\\Users\\20590\\OneDrive\\Desktop\\file");
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
            bos.flush();
        }
        //获取输出流反馈信息
        OutputStreamWriter osw = new OutputStreamWriter(socket.getOutputStream());
        osw.write("收到传送文件");
        osw.write("\r\n");
        osw.flush();
        //释放资源
//        bos.close();
        socket.close();
        serverSocket.close();
    }
}
