import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class StudentTest {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> list3 = new ArrayList<>();
        ArrayList<String> list4 = new ArrayList<>();
        Collections.addAll(list1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0);
        Collections.addAll(list2, "1", "3", "5", "7", "9");
        Collections.addAll(list3, "2", "4", "6", "8", "10");
        for (int i = 0; i < 100; i++) {
            if (list4.size() == list2.size() + list3.size()) {
                list4.clear();
            }
            Random r = new Random();
            while (true) {
                if (list1.get(r.nextInt(list1.size())) == 1) {
                    String str = list2.get(r.nextInt(list2.size()));
                    if (addlist(str, list4)) {
                        System.out.print(str + " ");
                        break;
                    }
                } else {
                    String str = list3.get(r.nextInt(list3.size()));
                    if (addlist(str, list4)) {
                        System.out.print(str + " ");
                        break;
                    }
                }
            }
        }
    }

    public static boolean addlist(String args, ArrayList<String> list) {
        if (list.contains(args)) {
            return false;
        } else {
            list.add(args);
            return true;
        }
    }
}
