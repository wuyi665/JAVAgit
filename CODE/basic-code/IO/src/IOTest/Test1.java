package IOTest;

import cn.hutool.core.util.ReUtil;
import cn.hutool.http.HttpUtil;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    public static void main(String[] args) throws IOException {
        /*
         * 网络爬虫
         * 姓:https://zhidao.baidu.com/question/143118960.html
         * 男生名字:https://ratenn.com/boy-name.html
         * 女生名字:https://ratenn.com/girl-name.html
         * */
        //定义变量记录网址
        String familyname = "https://zhidao.baidu.com/question/143118960.html";
        String boyname = "https://ratenn.com/boy-name.html";
        String girlname = "https://ratenn.com/girl-name.html";
        //利用Hutool爬取网址数据
        String familynameStr = HttpUtil.get(familyname);
        String boynameStr = HttpUtil.get(boyname);
        String girlnameStr = HttpUtil.get(girlname);
        List<String> familynameList = ReUtil.findAll("", familynameStr, 1);
        List<String> boynameList = ReUtil.findAll("", boynameStr, 1);
        List<String> girlNameList = ReUtil.findAll("", girlnameStr, 1);


//        //利用爬取方法爬取数据
//        String FamilyNameStr = webCrawler(familyname);
//        String BoyNameStr = webCrawler(boyname);
//        String GirlNameStr = webCrawler(girlname);
//        //利用正则表达式获取数据
//        ArrayList<String> familyNameList = getData(FamilyNameStr, "");
//        ArrayList<String> boyNameList = getData(BoyNameStr, "");
//        ArrayList<String> girlNameList = getData(GirlNameStr, "");

    }

    /*
     * 作用:利用正则表达式获取字符串中数据并存入集合
     * 参数1:需要操作的字符串
     * 参数2:正则表达式
     * 返回值:筛选后的集合
     * */
    private static ArrayList<String> getData(String str, String regex) {
        //创建集合存放数据
        ArrayList<String> list = new ArrayList<>();
        //创建正则表达式对象
        Pattern pattern = Pattern.compile(regex);
        //按照正则表达式对象获取数据
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    /*
     * 作用:网络爬取数据并拼接为字符串
     * 参数:网址字符串形式
     * 返回值:爬取到的字符串
     * */
    private static String webCrawler(String net) throws IOException {
        //创建StringBuilder拼接字符串
        StringBuilder sb = new StringBuilder();
        //创建URL并链接网址
        URL url = new URL(net);
        URLConnection urlConnection = url.openConnection();
        //读取数据
        InputStreamReader isr = new InputStreamReader(urlConnection.getInputStream());
        int read;
        while ((read = isr.read()) != -1) {
            sb.append((char) read);
        }
        //释放资源
        isr.close();
        return sb.toString();
    }
}
