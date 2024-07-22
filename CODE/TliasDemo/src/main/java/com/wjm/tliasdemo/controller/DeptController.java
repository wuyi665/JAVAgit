package com.wjm.tliasdemo.controller;

import com.wjm.tliasdemo.anno.Log;
import com.wjm.tliasdemo.pojo.Dept;
import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


/*
 * 部门Controller
 * */
@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

    @Autowired
    private DeptService deptService;

    /*
     * 查询全部部门信息get请求
     * */
    @GetMapping
    public Result list() {
        log.info("查询全部部门信息");
        return Result.success(deptService.list());
    }

    /*
     * 删除部门信息delete请求
     * */
    @Log
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除{}部门信息", id);
        deptService.delete(id);
        return Result.success();
    }

    /*
     * 新增部门信息post请求
     * */
    @Log
    @PostMapping
    public Result insert(@RequestBody Dept dept) {
        log.info("新增部门名称{}", dept.getName());
        deptService.insert(dept);
        return Result.success();
    }

    /*
     * 根据id查询部门信息get请求
     * */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        log.info("查询部门信息id:{}", id);
        return Result.success(deptService.findById(id));
    }

    /*
     * 修改部门信息put请求
     * */
    @Log
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("修改部门信息{}", dept.getName());
        deptService.update(dept);
        return Result.success();
    }
}
