package ImmutableList;

import java.util.List;

public class immutableTest1 {
    public static void main(String[] args) {
        //创建不可变集合(只能查询)
        List<String> list = List.of("张三", "李四", "王五");
        boolean result = list.contains("张三");
        System.out.println(result);
    }
}
