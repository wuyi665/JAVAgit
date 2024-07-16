package Stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;

/*
 * 中间方法:过滤filter,获取limit,跳过skip,去重distinct,合并concat,转换数据类型map
 * 只会修改流中的数据,不改变原始集合或者数组的数据
 * stream流中的数据只能使用一次,没有用变量接收的意义
 * */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "aareligj-14", "bewgrk-15", "cwegj-16", "agth-17");
        list.stream()
                .limit(2)
                .skip(1)
                .forEach(s -> System.out.println(s));
        Collections.addAll(list, "aareligj-14", "bewgrk-15");
        System.out.println(list);
        list.stream()
                .distinct()
                .forEach(s -> System.out.println(s));
        list.stream()
                .distinct()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String string) {
                        String[] split = string.split("-");
                        return Integer.parseInt(split[1]);
                    }
                })
                .forEach(s -> System.out.println(s));

    }
}
