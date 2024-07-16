package ArrayList;

import java.util.ArrayList;
import java.util.StringJoiner;

public class test2 {
    public static void main(String[] args) {
        StringJoiner sj = new StringJoiner("");
        sj.add("A").add("B").add("C");
        System.out.println(sj);
        ArrayList<String> list = new ArrayList<String>();
        list.add("A");
        list.add("B");
        list.add("C");
        System.out.println(list.size());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        //在集合中添加基本数据类型时要把数据变成包装类,其中特殊的是char->Character和int->interger,其他的都是将首字母大写
    }
}
