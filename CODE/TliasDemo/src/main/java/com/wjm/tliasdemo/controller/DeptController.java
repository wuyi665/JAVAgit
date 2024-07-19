package com.wjm.tliasdemo.controller;

import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/*
 * 部门Controller
 * */
@Slf4j
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping(value = "/depts")
    public Result list() {
        log.info("查询全部部门信息");


        return Result.success(deptService.list());
    }
}
