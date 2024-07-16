package Static;

public class Teacher extends Employee {
    public Teacher() {
    }

    public Teacher(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("工作方式为教学");
    }
}
