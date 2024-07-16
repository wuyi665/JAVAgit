package OOP;

public class Javabean {
    //定义成员变量
    private String user;
    private String password;
    private String email;
    private int age;
    private String gender;

    //无参构造
    public Javabean() {
        System.out.println("这是无参构造!");
    }

    //有参构造
    public Javabean(String user, String password, String email, int age, String gender) {
        this.user = user;
        this.password = password;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    //设定调用方法(快捷键:alt+insert|| alt+Fn+insert || ptg插件)
    /**
     * 获取
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(String user) {
        this.user = user;//如果没有this.会使用就近原则进行赋值操作,其本质是代表了方法调用者的地址值
    }

    /**
     * 获取
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 获取
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * 设置
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }




}
