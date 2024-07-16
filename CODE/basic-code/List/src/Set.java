/*
HashSet:无序不重复无索引,底层基于哈希表
        直接调用hashcode方法不同对象的哈希值不同
        重写了hashCode后根据对象的属性判断哈希值,属性相同哈希值也相同
    LinkedHashSet:有序不重复无索引,底层仍然是哈希表,但是引入了一个双向链表记录存储位置
    TreeSet:可排序不重复无索引,底层结构为红黑树(排序的时候默认排序:对象实现comparable接口
                                       比较器排序:)
 */
public class Set {
    public static void main(String[] args) {
//        HashSet<Student> set = new HashSet<>();
//        Student s1 = new Student("张三", 19);
//        Student s2 = new Student("张三", 19);
//        Student s3 = new Student("李四", 20);
//        Student s4 = new Student("王五", 21);
//        set.add(s1);
//        set.add(s2);
//        set.add(s3);
//        set.add(s4);
//        System.out.println(set);
//        TreeSet<Student> treeSet = new TreeSet<>();
//        treeSet.add(s4);
//        treeSet.add(s2);
//        treeSet.add(s1);
//        treeSet.add(s3);
//        System.out.println(treeSet);
//
//        TreeSet<String> set = new TreeSet<String>(new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                int i = o1.length() - o2.length();
//                i = i == 0 ? o1.compareTo(o2) : i;
//                return i;
//            }
//        });
//        for (String s : str) {
//            set.add(s);
//        }
//        System.out.println(set);
    }
}
