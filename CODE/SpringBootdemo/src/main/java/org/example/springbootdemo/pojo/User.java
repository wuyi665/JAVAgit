package org.example.springbootdemo.pojo;

public class User {
    private String name;
    private Integer age;
    private Address address;

    public User() {
    }

    public User(String name, Integer age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
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
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 获取
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * 设置
     *
     * @param address
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    public String toString() {
        return "Uesr{name = " + name + ", age = " + age + ", address = " + address + "}";
    }
}
