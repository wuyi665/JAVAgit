package File;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException {
        String parentstr = "C:\\Users\\20590\\OneDrive\\Desktop";
        String childstr1 = "file";
        String childstr2 = "aaa";
        String childstr3 = "bbb";
        String childstr4 = "ccc.txt";
        String childstr5 = "ddd.txt";
        String childstr6 = "a.txt";
        String childstr7 = "b.txt";
        File Parent = new File(parentstr);
        File Child1 = new File(Parent, childstr1);
        File Child2 = new File(Child1, childstr2);
        File Child3 = new File(Child1, childstr3);
        File Child4 = new File(Child1, childstr4);
        File Child5 = new File(Child1, childstr5);
        File Child6 = new File(Child2, childstr6);
        File Child7 = new File(Child3, childstr7);
        Child1.mkdirs();
        Child2.mkdirs();
        Child3.mkdirs();
        Child4.createNewFile();
        Child5.createNewFile();
        Child6.createNewFile();
        Child7.createNewFile();

        File[] files = File.listRoots();
        System.out.println(Arrays.toString(files));
        getTxt(Child1);
    }

    private static void getTxt(File child1) {
        File[] files = child1.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    getTxt(file);
                }
            }
        }
    }
}
