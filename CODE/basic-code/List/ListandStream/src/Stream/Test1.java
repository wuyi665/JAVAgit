package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

/*
 *Stream: 对集合中的元素进行筛选可以用
 * 先创造一条流水线,之后用中间方法和终结方法对其进行操作
 * 双列集合不能直接获取stream流
 * */
public class Test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "aareligj", "bewgrk", "cwegj", "agth");
        list.stream().filter(name -> name.startsWith("a"))
                .filter(name -> name.length() == 4).forEach(string -> System.out.println(string));

        HashMap<String, Integer> map = new HashMap<>();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        map.put("d", 4);
        //第一种方法
        map.keySet().stream().forEach(s -> System.out.println(s));
        //第二种方法
        map.entrySet().stream().forEach(e -> System.out.println(e));
        //数组获取stream流
        String[] arr = list.toArray(new String[list.size()]);
        Arrays.stream(arr).forEach(s -> System.out.println(s));
    }
}
