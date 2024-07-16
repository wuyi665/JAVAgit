import java.io.*;

public class Test5 {
    public static void main(String[] args) throws IOException {
        //利用字节流调用字符流的方法
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("Io\\a.txt")));
        String s;
        while ((s = br.readLine()) != null) {
            System.out.println(s);
        }
        br.close();
    }
}
