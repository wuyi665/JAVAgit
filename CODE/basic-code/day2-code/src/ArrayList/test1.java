package ArrayList;

import java.util.ArrayList;

/*
集合:对于字符串来说创建之后长度不能改变,但stringbuilder是一个长度可变的容器
对于数组同样如此,所以现在需要一个长度可变的容器叫做集合,但集合只能存储引用数据类型,这样很适合创建对象的各类数据
 */
public class test1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();//<>中写泛型,规定集合中的数据类型
        //成员方法要会增 删 改 查
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        System.out.println(list);//打印时展示的是集合中的数据内容

        boolean result = list.remove("ccc");//删除的第一种格式
        System.out.print("删除操作");
        System.out.println(result);
        System.out.println("删除后的列表:");
        System.out.println(list);
        String result1 = list.remove(1);//删除的第二种格式
        System.out.print("删除的内容为:");
        System.out.println(result1);
        System.out.println("删除后的列表:");
        System.out.println(list);

        String result2 = list.set(0, "wjm");//返回一个修改之前的内容
        System.out.print("修改前的内容:");
        System.out.println(result2);
        System.out.println("修改后的列表:");
        System.out.println(list);

        String result3 = list.get(0);//返回一个查询到的内容
        System.out.print("查询到的内容:");
        System.out.println(result3);

        int size = list.size();//返回集合长度
        for (int i = 0; i < size; i++) {
            System.out.println(list.get(i));
        }
    }
}
