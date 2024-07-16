import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringJoiner;
import java.util.function.Function;

public class Test3 {
    public static void main(String[] args) throws IOException {
        //给文件中内容
        FileReader fr = new FileReader("IO\\a.txt");
        FileWriter fw = new FileWriter("IO\\b.txt");
        StringBuilder sb = new StringBuilder();
        int read;
        while ((read = fr.read()) != -1) {
            sb.append((char) read);
        }
        fr.close();
//        String[] split = sb.toString().split("-");
//        ArrayList<Integer> list = new ArrayList<>();
//        for (String s : split) {
//            list.add(Integer.parseInt(s));
//        }
//        Collections.sort(list);
//        StringJoiner sj = new StringJoiner("-");
//        for (int i = 0; i < list.size(); i++) {
//            sj.add(String.valueOf(list.get(i)));
//        }
        Integer[] array = Arrays.stream(sb.toString().split("-")).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String string) {
                return Integer.parseInt(string);
            }
        }).sorted().toArray(Integer[]::new);
        StringJoiner sj = new StringJoiner("-");
        for (int i = 0; i < array.length; i++) {
            sj.add(String.valueOf(array[i]));
        }
        fw.write(sj.toString());
        fw.close();
    }
}
