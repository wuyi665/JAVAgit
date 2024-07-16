import java.util.ArrayList;
import java.util.ListIterator;

/*
List:add,remove(自动调用实参形参类型一致的方法),set,get,其中都有int index,可以通过索引操作
**数据结构:指数据是用什么方法结合在一起的(长什么样子,如何增删)
         栈:先进后出,后进先出
         队列:一个后端,一个前端,后端进入,前端弹出,先进先出
         数组:长度不可以改变,有索引查询比较快,内存中存储连续,删除/添加效率低,因为要前移/后移
         链表:存储数据和下一个结点的地址值,删除和添加慢,查询需要遍历,速度较慢(有双向链表,前后地址值都有)
ArrayList:底层是数组,空参构造创造一个长度为0的数组,添加第一个创造长度为10的,之后溢出后扩容为1.5倍
LinkedList:底层是双向链表
 */
public class List {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add(1, "D");
        System.out.println(list);
        list.remove(1);
        list.remove("C");
        System.out.println(list);
        list.set(0, "哎呦");
        list.set(1, "你干嘛");
        System.out.println(list);
        //迭代器遍历
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            System.out.println(iterator.next());
//        }
        //增强for遍历
//        for (String s : list) {
//            System.out.println(s);
//        }
        //列表迭代器(继承Iterator)
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
    }
}
