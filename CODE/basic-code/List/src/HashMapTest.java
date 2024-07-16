/*
HashMap:无序不重复无索引
key是对象要重写hashCode和equals方法

HashMap底层原理:
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Student, String> map = new HashMap<>();
        Student s1 = new Student("张三", 18,"男");
        Student s3 = new Student("王五", 26,"女");
        Student s2 = new Student("李四", 22,"男");
        Student s4 = new Student("李四", 22,"女");
        map.put(s1, "河南");
        map.put(s2, "山东");
        map.put(s3, "新疆");
        map.put(s4, "湖南");
        for (HashMap.Entry<Student, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " 籍贯:" + entry.getValue());
        }


        HashMap<String, Integer> ticketmap = new HashMap<>();
        ArrayList<String> ticket = new ArrayList<>();
        String[] arr = {"A", "B", "C", "D"};
        getTicket(ticket, arr);
        System.out.println(ticket);
        for (String s : ticket) {
            if (ticketmap.containsKey(s)) {
                ticketmap.put(s, ticketmap.get(s) + 1);
            } else {
                ticketmap.put(s, 1);
            }
        }
        System.out.println(ticketmap);
        int max = 0;
        for (HashMap.Entry<String, Integer> entry : ticketmap.entrySet()) {
            max = Math.max(max, entry.getValue());
        }
        for (HashMap.Entry<String, Integer> entry : ticketmap.entrySet()) {
            if (entry.getValue() == max) {
                System.out.println("得票最多的景点是:" + entry.getKey());
            }
        }
    }


    public static ArrayList<String> getTicket(ArrayList<String> ticket, String[] arr) {
        Random r = new Random();
        for (int i = 0; i < 80; i++) {
            String s = arr[r.nextInt(arr.length)];
            ticket.add(s);
        }
        return ticket;
    }
}
