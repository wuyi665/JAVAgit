package Exception;

public class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.setName(name);
        this.setAge(age);
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
        if (name.length() >= 2 && name.length() <= 10) {
            this.name = name;
        } else {
            throw new NameFormatException("名字长度错误");
        }
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
        if (age >= 18 && age <= 24) {
            this.age = age;
        } else {
            throw new AgeOutofboundsException("年龄范围错误");
        }
    }

    public String toString() {
        return "Student{name = " + name + ", age = " + age + "}";
    }
}
