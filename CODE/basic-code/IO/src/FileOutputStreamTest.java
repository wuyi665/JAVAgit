import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("IO\\a.txt");
        //创建对象
        FileOutputStream fos = new FileOutputStream(file, false);
        //写数据
        byte[] bytes = {97, 98, 99, 100, 101, 102, 103, 104, 105};
//        String str = "你好";
//        byte[] bytes1 = str.getBytes();
//        fos.write(bytes1);
//        String str1 = "\r\n";
//        byte[] bytes2 = str1.getBytes();
//        fos.write(bytes2);
//        String str2 = "中国";
//        byte[] bytes3 = str2.getBytes();
        fos.write(bytes);
        //释放资源
        fos.close();
    }
}
