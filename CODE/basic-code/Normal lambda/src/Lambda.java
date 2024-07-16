import java.util.Arrays;
import java.util.Comparator;

/*
简化匿名内部类:采用函数式编程思想,强调的是做的事情而不是谁去做
        () -> {
        大括号中间写方法体
        }
        只能简化有且只有一个抽象方法的接口
 */
public class Lambda {
    public static void main(String[] args) {
        //匿名内部类
        swim(new Swim() {
            @Override
            public void swiming() {
                System.out.println("正在游泳!!!");
            }
        });
        //lambda表达式
        swim(() -> {
            System.out.println("正在游泳!!!");
        });

        String[] arr = {"WEKIYFJGTowuie", "bbuklh", "ccc", "jkweyFGH", "a"};
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });
        System.out.println(Arrays.toString(arr));
    }


    public static void swim(Swim s) {
        s.swiming();
    }
}

interface Swim {
    public abstract void swiming();
}
