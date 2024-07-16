package OOP;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        //创建对象
        //类名时在元空间加载class文件(字节码文件),p为在栈中申明局部变量,new在堆中开辟空间,之后进行初始化,再把堆中初始化后的地址赋给局部变量
        //Phone p = new Phone("apple",19999);

        //此时p为对象地址,通过.方法或者.变量进行调用       创建类的对象和创建数组方法相似
        //如果两个对象指向同一个地址,这时可以用对象名=null断掉该对象对于堆空间的指向
        //根据内存使用原理,main方法中语句尽可能用方法来写,这样方法使用完后会自动出栈节省空间,如果堆内的空间没有被指向将会自动清理空间
        //p.call();
        //p.playgame();

        /*
        Role r1 = new Role("乔峰", 100, '男', "面目可憎");
        System.out.println("创建角色" + r1.getName() + "成功!初始血量为:" + r1.getBlood());
        Role r2 = new Role("鸠摩智", 100, '男', "慈眉善目");
        System.out.println("创建角色" + r2.getName() + "成功!初始血量为:" + r2.getBlood());
        int i = 0;
        while (r1.getBlood() != 0 && r2.getBlood() != 0) {
            System.out.println("第" + (i + 1) + "回合");
            i++;
            r1.attack(r2);
            if (r2.getBlood() <= 0) break;
            r2.attack(r1);
        }

         */

        /*Product[] a = new Product[3];
        //创建三个商品对象 创建时必须写在循环里面
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < a.length; i++) {
            Product p = new Product();
            //录入id
            System.out.println("输入id:");
            String id = sc.next();
            p.setId(id);
            //录入名字
            System.out.println("输入name:");
            String name = sc.next();
            p.setName(name);
            //录入价格
            System.out.println("输入price:");
            double price = sc.nextDouble();
            p.setPrice(price);
            //录入库存
            System.out.println("输入quantity:");
            int quantity = sc.nextInt();
            p.setQuantity(quantity);
            a[i] = p;
        }
        for (int i = 0; i < a.length; i++) {
            //需要创建对象
            Product p1 = a[i];
            System.out.println(p1.getId() + '\t' + p1.getName() + '\t' + p1.getPrice() + '\t' + p1.getQuantity());
        }


         */

       /* //设置三部ipad的品牌 价格 颜色
        Scanner sc = new Scanner(System.in);
        Ipad[] a = new Ipad[3];
        //录入ipad信息
        for (int i = 0; i < a.length; i++) {
            Ipad ipad = new Ipad();
            System.out.println("输入品牌:");
            String brand = sc.next();
            ipad.setBrand(brand);
            System.out.println("输入价格:");
            double price = sc.nextDouble();
            ipad.setPrice(price);
            System.out.println("输入颜色:");
            String color = sc.next();
            ipad.setColor(color);
            a[i] = ipad;
        }
        //计算平均price
        avgprice(a);
    }

    private static void avgprice(Ipad[] a) {
        double price = 0;
        for (int i = 0; i < a.length; i++) {
            Ipad ipad = a[i];
            System.out.println(ipad.getBrand() + '\t' + ipad.getPrice() + '\t' + ipad.getColor());
            price += ipad.getPrice();
        }
        price = price / a.length;
        System.out.println("三部手机的平均价格是:" + price);

        */
        Student[] students = new Student[3];
        Student s1 = new Student("001", "张三", 18);
        Student s2 = new Student("002", "李四", 19);
        Student s3 = new Student("003", "王五", 20);
        students[0] = s1;
        students[1] = s2;
        students[2] = s3;
        Scanner sc = new Scanner(System.in);
        System.out.print("输入0重新录入三个学生信息,输入1添加学生信息,输入2删除学生信息,输入3修改学生信息:");
        int flag = sc.nextInt();
        if (flag == 0) {
            //录入原始的三名学生的信息
            for (int i = 0; i < students.length; i++) {
                Student s = new Student();
                luruxinxi(sc, s);
                students[i] = s;
            }
            test(students);
        } else if (flag == 1) {
            Student[] students2 = addstu(students);
            test(students2);
        } else if (flag == 2) {
            Student[] students3 = delstu(students);
            test(students3);
        } else if (flag == 3) {
            Student[] students4 = changestu(students);
            test(students4);
        } else {
            System.out.println("输入格式错误!");
        }

    }

    //录入学生信息
    private static void luruxinxi(Scanner sc, Student s) {
        //id
        System.out.print("Enter student id: ");
        String id = sc.next();
        s.setId(id);
        //name
        System.out.print("Enter student name: ");
        String name = sc.next();
        s.setName(name);
        //age
        System.out.print("Enter student age: ");
        int age = sc.nextInt();
        s.setAge(age);
    }

    //添加学生信息
    private static Student[] addstu(Student[] s) {
        Student stu = new Student();
        Student[] temp = new Student[s.length + 1];
        Scanner sc = new Scanner(System.in);
        System.out.println("录入一个新学生信息");
        luruxinxi(sc, stu);
        while (true) {
            for (int i = 0; i < s.length; i++) {
                if (s[i].getId().equals(stu.getId())) {
                    System.out.println("学生重复录入!");
                    return s;
                }
            }
            temp[s.length] = stu;
            System.out.println("学生录入成功!");
            break;
        }
        for (int i = 0; i < s.length; i++) {
            temp[i] = s[i];
        }
        return temp;
    }

    //删除学生信息
    private static Student[] delstu(Student[] s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入要删除的学生id:");
        String id = sc.next();
        for (int i = 0; i < s.length; i++) {
            if (s[i].getId().equals(id)) {
                System.out.println(s[i].getId() + '\t' + s[i].getName() + '\t' + s[i].getAge());
                System.out.print("输入1确认删除,输入0取消删除:");
                int flag = sc.nextInt();
                if (flag == 0) {
                    System.out.println("取消成功!");
                    return s;
                } else if (flag == 1) {
                    s[i] = null;
                    System.out.println("删除成功!");
                    return s;
                } else {
                    System.out.println("操作失败!");
                    return s;
                }
            }
        }
        System.out.println("删除失败!");
        return s;
    }

    //修改学生信息
    private static Student[] changestu(Student[] s) {
        Scanner sc = new Scanner(System.in);
        System.out.print("输入要修改的学生id:");
        String id = sc.next();
        for (int i = 0; i < s.length; i++) {
            if (s[i].getId().equals(id)) {
                luruxinxi(sc, s[i]);
                System.out.println("修改成功!");
                return s;
            }
        }
        System.out.println("修改失败!");
        return s;
    }


    //遍历学生数组
    private static void test(Student[] students) {
        for (int i = 0; i < students.length; i++) {
            Student s = students[i];
            if (s == null) {
            } else {
                System.out.println(s.getId() + '\t' + s.getName() + '\t' + s.getAge());
            }
        }
    }
}