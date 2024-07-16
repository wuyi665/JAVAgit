import java.util.HashMap;
import java.util.function.BiConsumer;

/*
双列集合Map:包含一个key(不可以重复)和一个value(可以重复),属于一一对应关系称为键值对
Map包括:HashMap和LinkedHashMap和TreeMap
Map的api:put,remove,clear,containsKey/Value
遍历方式:1.键找值 2.键值对 3.lambda表达式

 */
public class Map {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("红心", "K");
        map.put("方片", "K");
        map.put("黑桃", "K");
        map.put("梅花", "K");
        String put = map.put("亏贼", "Q");
        //键值对冲突会把原有的值覆盖并返回被覆盖的值,不冲突会返回null
        System.out.println(put);
        //返回被删除的值
        String remove = map.remove("亏贼");
        System.out.println(map);
        System.out.println(remove);
//        map.clear();
//        System.out.println(map);
// 键找值的方式遍历
//        Set<String> keys = map.keySet();
//        //增强for
//        for (String key : keys) {
//            System.out.println(key + ":" + map.get(key));
//        }
//        //迭代器
//        Iterator<String> iterator = keys.iterator();
//        while (iterator.hasNext()) {
//            String key = iterator.next();
//            System.out.println(key + ":" + map.get(key));
//        }
//        //lambda表达式
//        keys.forEach(new Consumer<String>() {
//            @Override
//            public void accept(String string) {
//                System.out.println(string + ":" + map.get(string));
//            }
//        });
//键值对的方式
//        Set<HashMap.Entry<String, String>> entries = map.entrySet();
//        //增强for
//        for (HashMap.Entry<String, String> entry : entries) {
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        //迭代器
//        Iterator<HashMap.Entry<String, String>> iterator = entries.iterator();
//        while (iterator.hasNext()) {
//            HashMap.Entry<String, String> entry = iterator.next();
//            System.out.println(entry.getKey() + ":" + entry.getValue());
//        }
//        //lambda表达式
//        entries.forEach(new Consumer<HashMap.Entry<String, String>>() {
//            @Override
//            public void accept(java.util.Map.Entry<String, String> stringStringEntry) {
//                System.out.println(stringStringEntry.getKey() + ":" + stringStringEntry.getValue());
//            }
//        });
        //前面的lambda表达式本质上是遍历set集合,下面用lambda表达式遍历map
        map.forEach(new BiConsumer<String, String>() {
            @Override
            public void accept(String key, String value) {
                System.out.println(key + ":" + value);
            }
        });
    }
}
