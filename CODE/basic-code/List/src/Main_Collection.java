import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
集合进阶:单列集合Collection(list和set)和双列集合Map
    Collection分为List(有序可重复有索引)和Set(无序不重复无索引)
    Collection遍历格式:迭代器(Iterator)遍历:
                    增强for遍历:单列集合和数组
                    lambda遍历

 */
public class Main_Collection {
    public static void main(String[] args) {
        //集合基本方法
        Collection<String> col = new ArrayList<>();
        col.add("A");
        col.add("B");
        col.add("C");
        System.out.println(col);
        col.clear();
        System.out.println(col);
        col.add("A");
        col.add("B");
        col.add("C");
        col.add("你干嘛");
        col.add("哎呦!");
        System.out.println(col.remove("B"));
        System.out.println(col);
        //contain底层依赖equals方法进行判断,比较的是地址值,如果添加的是自定义对象应该重写equals方法
        System.out.println(col.contains("A"));
        System.out.println(col.size());

        //迭代器(Iterator)遍历,之后指针不复位
        Iterator<String> it = col.iterator();
        while (it.hasNext()) {
            String str = it.next();
            if (str.equals("A")) {
                it.remove();
            }
        }
        System.out.println(col);
        //增强for集合(原理还是迭代器)
        for (String str : col) {
            System.out.println(str);
        }
//        //lambda表达式遍历
//        col.forEach(new Consumer<String>() {
//
//            @Override
//            public void accept(String string) {
//                System.out.println(string);
//            }
//        });
        col.forEach(s-> System.out.println(s));
    }
}
