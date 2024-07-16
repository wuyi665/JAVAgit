package Regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
    public static void main(String[] args) {
        //正则表达式判断qq号码是对否合理(6-20位纯数字,第一位不能是0)
        String QQ = "2059017922";
        String regex1 = "[1-9]\\d{5,19}";
        System.out.println(QQ.matches(regex1));
        //邮箱号码正则判断
        String email = "15890411217@163.com";
        String regex2 = "[^0_]\\w+@[\\w&&[^_]]{2,6}(\\.[a-zA-Z]{2,3}){1,2}";
        System.out.println(email.matches(regex2));
        //爬虫练习
        String str = "java违反国家我欸JAVA奥i入股哈配个和jaVa17哎u如果还哦如何发i如";
        Pattern pattern1 = Pattern.compile("(?i)(java)\\d{0,2}");
        Matcher matcher1 = pattern1.matcher(str);
        while (matcher1.find()) {
            System.out.println(matcher1.group());
        }
        //捕获分组
        String str2 = "aAWEIFUGHa";
        String str3 = "afuiywehfoai";
        String regex3 = "(.).+\\1";
        System.out.println(str2.matches(regex3));
        System.out.println(str3.matches(regex3));
        //正则分组外部引用
        String str4 = "我我要要要要玩原原原原原神神!";
        String s = str4.replaceAll("(.)\\1+", "$1");
        System.out.println(s);
    }
}
