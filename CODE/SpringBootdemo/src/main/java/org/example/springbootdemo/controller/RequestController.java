package org.example.springbootdemo.controller;

import org.example.springbootdemo.pojo.Result;
import org.example.springbootdemo.pojo.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/*
 * 测试请求参数接收
 * */
@RestController
public class RequestController {

    /*
     * 简单参数的传递请求
     * */
    @RequestMapping("/simpleParam")
    public Result simpleParam(@RequestParam(name = "name") String username, Integer age) {
        //获取请求参数
        System.out.println(username + ":" + age);
        return Result.success(username + ":" + age);
    }

    /*
     * 实体参数的传递请求
     * */
    @RequestMapping("SimplePojo")
    public Result SimplePojo(User user) {
        System.out.println(user);
        return Result.success(user);
    }

    /*
     * 数组参数的传递请求
     * */
    @RequestMapping("arrayparam")
    public Result arrayparam(String[] strs) {
        System.out.println(Arrays.toString(strs));
        return Result.success(strs);
    }

    /*
     * 集合参数的传递请求
     * */
    @RequestMapping("listparam")
    public Result listparam(@RequestParam List<String> strs) {
        System.out.println(strs);
        return Result.success(strs);
    }

    /*
     *日期参数的传递请求
     * */
    @RequestMapping("dateparam")
    public Result dateparam(@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime dateTime) {
        System.out.println(dateTime);
        return Result.success(dateTime);
    }

    /*
     * json参数的传递请求，通过实体对象来接受
     * */
    @RequestMapping("jsonparam")
    public Result jsonparam(@RequestBody User user) {
        System.out.println(user);
        return Result.success(user);
    }

    /*
     * 路径参数的传递请求，传递的参数成为url的一部分
     * */
    @RequestMapping("pathparam/{id}")
    public Result pathparam(@PathVariable Integer id) {
        System.out.println(id);
        return Result.success(id);
    }
}
