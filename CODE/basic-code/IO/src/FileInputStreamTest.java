import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        File file = new File("IO\\a.txt");
        FileInputStream fis = new FileInputStream(file);
        int read;
        while ((read = fis.read()) != -1) {
            System.out.print((char) read);
        }
        fis.close();
    }
}
