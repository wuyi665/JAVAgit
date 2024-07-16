import java.io.*;
import java.net.Socket;

public class TestClient {
    public static void main(String[] args) throws IOException {
        /*
         * 需求:客户端上传给服务器一个文件并接收服务器返回消息
         * */
        //创建服务器连接
        Socket socket = new Socket("DESKTOP-6QQ37E0", 10086);
        //写入要上传的文件
        File file = new File("C:\\Users\\20590\\OneDrive\\Desktop\\file");
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
        //获取输出流
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            //传给服务器文件
            bos.write(buf, 0, len);
            bos.flush();
        }
        //写出结束标记
        socket.shutdownInput();
        //获取输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //获取反馈数据
        String str;
        while ((str = br.readLine()) != null) {
            System.out.print(str);
        }
        //释放资源
//        bis.close();
        socket.close();
    }
}
