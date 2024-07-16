package Static;

public class Buyer extends AdminStaff{
        public Buyer() {}

    public Buyer(String id, String name) {
        super(id, name);
    }

    @Override
    public void work() {
        System.out.println("负责事项2");
    }
}
