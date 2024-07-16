package Doudizhu;

import java.util.*;

public class PokerGame {
    //准备牌,用静态代码块,只加载一次
    static HashMap<Integer, String> hashMap = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        String[] color = {"♣", "♠", "♦", "♥"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int count = 1;
        for (String n : number) {
            for (String c : color) {
                hashMap.put(count, c + n);
                list.add(count);
                count++;
            }
        }
        hashMap.put(count, "小王");
        hashMap.put(count + 1, "大王");
        list.add(count);
        list.add(count + 1);
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);
        System.out.println(list);
        System.out.println(hashMap);
        HashMap<Integer, String> lord = new HashMap<>();
        TreeMap<Integer, String> player1 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        TreeMap<Integer, String> player2 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        TreeMap<Integer, String> player3 = new TreeMap<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        //发牌
        for (int i = 0; i < list.size(); i++) {
            if (i <= 2) {
                lord.put(list.get(i), hashMap.get(list.get(i)));
                continue;
            }
            if (i % 3 == 0) {
                player1.put(list.get(i), hashMap.get(list.get(i)));
            } else if (i % 3 == 1) {
                player2.put(list.get(i), hashMap.get(list.get(i)));
            } else {
                player3.put(list.get(i), hashMap.get(list.get(i)));
            }
        }
        show("底牌", lord);
        show("玩家1", player1);
        show("玩家2", player2);
        show("玩家3", player3);

    }

    public static void show(String str, Map<Integer, String> map) {
        System.out.print(str + ":");
        for (Integer i : map.keySet()) {
            System.out.print(map.get(i) + " ");
        }
        System.out.println();
    }
}
