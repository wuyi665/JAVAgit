package org.example.springbootdemo.controller;

import org.example.springbootdemo.pojo.Emp;
import org.example.springbootdemo.pojo.Result;
import org.example.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
 * 根据resources目录下的静态页面完成对emp.xml文件中的对象请求
 * 返回的是统一的请求体，其中的data格式为emp对象
 * */
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/listEmp")
    public Result list() {
        List<Emp> emplist = empService.listEmp();
        //响应数据
        return Result.success(emplist);
    }
}
