import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("IO\\a.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("IO\\b.txt"));
        String s;
        ArrayList<String> list = new ArrayList<>();
        while ((s = br.readLine()) != null) {
            list.add(s);
        }
        br.close();
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                Integer i1 = Integer.parseInt(o1.split("\\.")[0]);
                Integer i2 = Integer.parseInt(o2.split("\\.")[1]);
                return i1.compareTo(i2);
            }
        });
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) != null) {
                bw.write(list.get(i));
                bw.newLine();
            }
        }
        bw.close();

        //指定字符编码读取数据和写出数据
        FileReader fr = new FileReader("IO\\a.txt", Charset.forName("GBK"));
        FileWriter fw = new FileWriter("IO\\b.txt", Charset.forName("GBk"));
        fw.close();
        fr.close();
    }
}
