import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
Collections是集合的工具类,常用的API有:addAll批量添加数据和shuffle打乱数据,sort排序,copy拷贝,binarySearch二分查找,swap交换
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, "jkefh", "eoiwyfrw", "eif", "elfigj", "jkefkEP");
        System.out.println(list);
        Collections.shuffle(list);
        System.out.println(list);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(list);
    }
}
