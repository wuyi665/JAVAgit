import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringJoiner;

public class MapTest {
    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        ArrayList<String> jiangsu = new ArrayList<>();
        Collections.addAll(jiangsu, "南京", "扬州", "苏州", "无锡", "常州");
        ArrayList<String> hubei = new ArrayList<>();
        Collections.addAll(hubei, "武汉", "孝感", "十堰", "宜昌", "鄂州");
        ArrayList<String> hebei = new ArrayList<>();
        Collections.addAll(hebei, "张家口", "保定", "邢台", "唐山", "石家庄");
        map.put("江苏", jiangsu);
        map.put("湖北", hubei);
        map.put("河北", hebei);
        for (HashMap.Entry<String, ArrayList<String>> entry : map.entrySet()) {
            ArrayList<String> value = entry.getValue();
            StringJoiner sj = new StringJoiner(",", "", "");
            for (String s : value) {
                sj.add(s);
            }
            System.out.println(entry.getKey() + "=" + sj.toString());
        }
    }
}
