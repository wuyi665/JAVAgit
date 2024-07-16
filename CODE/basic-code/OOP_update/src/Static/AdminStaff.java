package Static;

public class AdminStaff extends Employee {
    public AdminStaff() {
    }

    public AdminStaff(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("工作方式为负责其他事项");
    }
}
