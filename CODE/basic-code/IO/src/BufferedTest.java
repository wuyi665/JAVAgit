import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws IOException {
        //字节缓冲流
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("IO\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("IO\\c.txt"));
        byte[] buf = new byte[1024];
        int len;
        while ((len = bis.read(buf)) != -1) {
            bos.write(buf, 0, len);
        }
        bos.close();
        bis.close();
        //字符缓冲流
        BufferedReader br = new BufferedReader(new FileReader("IO\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("IO\\d.txt"));
        String s;
        while ((s = br.readLine()) != null) {
            bw.write(s);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
