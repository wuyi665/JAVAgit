package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * 终结方法:遍历forEach,统计count,收集到数组toArray和集合collect
 * */
public class Test3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "aareligj-14", "bewgrk-15", "cwegj-16", "agth-17");
        long count = list.stream().count();
        System.out.println(count);

//        Object[] array = list.stream().toArray();
//        System.out.println(Arrays.toString(array));
//        String[] array1 = list.stream().toArray(value -> new String[value]);
//        System.out.println(Arrays.toString(array1));
        Map<String, Integer> collect1 = list.stream()
                .collect(Collectors.toMap(new Function<String, String>() {
                    @Override
                    public String apply(String string) {
                        return string.split("-")[0];
                    }
                }, new Function<String, Integer>() {
                    @Override
                    public Integer apply(String string) {
                        return Integer.parseInt(string.split("-")[1]);
                    }
                }));
        System.out.println(collect1);
    }
}
