import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
    public static void main(String[] args) throws IOException {
        //读reader
        FileReader fr = new FileReader("IO\\a.txt");
        char[] buf = new char[5];
        int len;
        while ((len = fr.read(buf)) != -1) {
            System.out.print(new String(buf, 0, len));
        }
        fr.close();
        //写writer
        FileWriter fw = new FileWriter("IO\\b.txt");
        fw.write("Hello World");
        fw.close();
    }
}
