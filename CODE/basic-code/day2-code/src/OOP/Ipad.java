package OOP;

public class Ipad {
    private String brand;
    private double price;
    private String color;
//构造方法
    public Ipad() {
    }

    public Ipad(String brand, double price, String color) {
        this.brand = brand;
        this.price = price;
        this.color = color;
    }
//设置与获取
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
