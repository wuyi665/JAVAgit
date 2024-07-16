package MethodUse;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/*
 * 方法引用就是将已有的方法拿过来用,当作函数式接口中抽象方法的方法体
 *要求:1.引用处必须是函数式接口
 *    2.被引用的方法要存在
 *    3.被引用方法形参和返回值要跟抽象方法保持一致
 *    4.被引用的方法要满足当前需求
 * 分类:1.引用静态方法(对象::方法名)
 *     2.引用成员方法(其他类,本类this,父类super),static中没有this和super
 *     3.引用构造方法(类名::new)
 *     4.其他调用方式(类名引用成员方法,数组的构造方法)
 * */
public class Test1 {
    public static void main(String[] args) {
        //创建数组进行倒序排序
        int[] arr = {1, 5, 8, 2, 0, 3};
        Integer[] arr1 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = Integer.valueOf(arr[i]);
        }
        //原始排序方法
//        Arrays.sort(arr1, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2.compareTo(o1);
//            }
//        });
        //方法引用,::为方法引用符,类名::静态方法
        Arrays.sort(arr1, Test1::compare);
        System.out.println(Arrays.toString(arr1));
//将字符串修改为student对象转成集合
        //原始方法
        String[] arr2 = {"zhangsan-19", "lisi-18", "wangwu-17"};
        List<Student> studentList = Arrays.stream(arr2).map(new Function<String, Student>() {
            @Override
            public Student apply(String string) {
                return new Student(string.split("-")[0], Integer.parseInt(string.split("-")[1]));
            }
        }).collect(Collectors.toList());
        System.out.println(studentList);
        //方法引用
        List<Student> studentList1 = Arrays.stream(arr2).map(Student::new).collect(Collectors.toList());
        System.out.println(studentList1);
    }

    private static int compare(Integer integer, Integer integer1) {
        return integer1.compareTo(integer);
    }
}
