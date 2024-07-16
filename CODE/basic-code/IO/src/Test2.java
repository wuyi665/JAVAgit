import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test2 {
    public static void main(String[] args) throws IOException {
        //加密与解密文件
        FileInputStream fis = new FileInputStream("C:\\Users\\20590\\OneDrive\\Pictures\\Camera Roll\\picture1.jpg");
        FileOutputStream fos = new FileOutputStream("C:\\Users\\20590\\OneDrive\\Pictures\\Camera Roll\\picturecopy.jpg");

        int len;
        while ((len = fis.read()) != -1) {
            fos.write(len ^ 2);
        }
        fos.close();
        fis.close();
    }
}
