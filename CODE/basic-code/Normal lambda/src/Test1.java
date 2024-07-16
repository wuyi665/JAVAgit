import java.util.Arrays;
import java.util.Comparator;

public class Test1 {
    public static void main(String[] args) {
        girlfriend g1 = new girlfriend("zhangsan", 20, 160);
        girlfriend g2 = new girlfriend("lisi", 19, 160);
        girlfriend g3 = new girlfriend("wangwu", 20, 178);
        girlfriend g4 = new girlfriend("zhaoliu", 20, 160);
        girlfriend[] arr = {g1, g2, g3, g4};
        Arrays.sort(arr, new Comparator<girlfriend>() {
            @Override
            public int compare(girlfriend o1, girlfriend o2) {
                int temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                return temp;
            }
        });
        System.out.println(Arrays.toString(arr));
        System.out.println(getsum(20));
    }

    public static int getsum(int count) {
        if (count == 1) {
            return 1;
        } else if (count == 2) {
            return 2;
        } else {
            return getsum(count - 1) + getsum(count - 2);
        }
    }
}

class girlfriend {
    private String name;
    private int age;
    private int height;

    public girlfriend() {
    }

    public girlfriend(String name, int age, int height) {
        this.name = name;
        this.age = age;
        this.height = height;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return height
     */
    public int getHeight() {
        return height;
    }

    /**
     * 设置
     *
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    public String toString() {
        return "girlfriend{name = " + name + ", age = " + age + ", height = " + height + "}";
    }
}
