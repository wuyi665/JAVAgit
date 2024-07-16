public class DaiLiTest {
    public static void main(String[] args) {
        //获取代理对象
        BigStar bigStar = new BigStar();
        Star star = ProxyUtil.createProxy(bigStar);
        //调用方法
        star.sing();
    }
}
