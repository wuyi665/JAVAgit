package org.example.springbootdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /*
     * 需求:请求处理类中的请求方法,发送给浏览器一个hello,返回一个HelloWorld
     *    SpringBoot内嵌了tomcat服务器
     * */
    @RequestMapping("/hello")
    public String hello() {
        System.out.println("发送hello成功");
        return "HelloWorld";
    }
}
