import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.TreeMap;

/*
LinkedHashMap:有序不重复无索引(有序也是用双链表确定)
TreeMap:无序不重复可排序(和TreeSet一样用红黑树结构),默认排序为升序
 */
public class LinkedHashMapTest {
    public static void main(String[] args) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("a", 1);
        map.put("b", 1);
        map.put("c", 1);
        System.out.println(map);
        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1.compareTo(o2) > 0) return -1;
                else return 1;
            }
        });
        treeMap.put(2, "b");
        treeMap.put(3, "c");
        treeMap.put(1, "a");
        System.out.println(treeMap);

        TreeMap<String, Integer> treeMap2 = new TreeMap<>();
        String str = "bfaiwuefygbaoeirsugfbhvpawieufgaoiewrugfvhaioeurhgvaeirolughaeir";
        for (int i = 0; i < str.length(); i++) {
            String s = str.substring(i, i + 1);
            if (treeMap2.containsKey(s)) {
                treeMap2.put(s, treeMap2.get(s) + 1);
            } else {
                treeMap2.put(s, 1);
            }
        }
        for (String s : treeMap2.keySet()) {
            System.out.print(s + "(" + treeMap2.get(s) + ") ");
        }

        int sum = getSum(1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        System.out.println(sum);
    }

    private static int getSum(int... args) {
        int sum = 0;
        for (int i : args) {
            sum += i;
        }
        return sum;
    }
}
