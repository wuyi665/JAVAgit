package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        //取出偶数
//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        Arrays.stream(arr).filter(i -> i % 2 == 0).forEach(i -> System.out.println(i));
        //取出年龄大于等于24的并放入map中
//        ArrayList<String> list = new ArrayList<String>();
//        Collections.addAll(list, "zhangsan,23", "lisi,24", "wangwu,25");
//        Map<String, Integer> collect = list.stream()
//                .filter(e -> Integer.parseInt(e.split(",")[1]) >= 24)
//                .collect(Collectors.toMap(string -> string.split(",")[0],
//                        string -> Integer.parseInt(string.split(",")[1])));
//        System.out.println(collect);
        //存储演员对象
        ArrayList<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "zhangsan1,23", "lisi1,24", "wangwu1,25", "zhaoliu1,26", "luoqi1,22", "laoba1,25");

        ArrayList<String> list2 = new ArrayList<>();
        Collections.addAll(list2, "zhangsan2,23", "lisi2,24", "wangwu2,25", "zhaoliu2,26", "luoqi2,22", "laoba2,25");

        Stream<String> stream1 = list1.stream().limit(3);
        Stream<String> stream2 = list2.stream().limit(4).skip(1);

        List<String> collected = Stream.concat(stream1, stream2).toList();

        List<Actor> result = collected.stream().map(string -> {
            Actor actor = new Actor();
            actor.setName(string.split(",")[0]);
            actor.setAge(Integer.parseInt(string.split(",")[1]));
            return actor;
        }).toList();
        System.out.println(result);
    }
}
