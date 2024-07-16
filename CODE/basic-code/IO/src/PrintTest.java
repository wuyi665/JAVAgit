import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.Charset;

public class PrintTest {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream out = new PrintStream(new FileOutputStream("IO\\a.txt", true), true, Charset.forName("UTF-8"));
        out.println("Hello World");
        out.close();
    }
}
