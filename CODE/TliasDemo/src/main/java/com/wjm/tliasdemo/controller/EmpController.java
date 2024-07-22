package com.wjm.tliasdemo.controller;

import com.wjm.tliasdemo.anno.Log;
import com.wjm.tliasdemo.pojo.Emp;
import com.wjm.tliasdemo.pojo.PageBean;
import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emps")
public class EmpController {
    @Autowired
    private EmpService empService;

    /*
     * 员工分页查询get请求
     * */
    @GetMapping
    public Result list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name, Short gender,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end) {
        log.info("分页查询参数:{},{},{},{},{},{}", page, pageSize, name, gender, begin, end);
        return Result.success(empService.list(page, pageSize, name, gender, begin, end));
    }

    /*
     * 根据id删除员工
     * */
    @Log
    @DeleteMapping("/{ids}")
    public Result delete(@PathVariable List<Integer> ids) {
        log.info("删除id为{}的员工", ids);
        empService.delete(ids);
        return Result.success();
    }

    /*
     * 添加员工post请求
     * */
    @Log
    @PostMapping
    public Result add(@RequestBody Emp emp) {
        log.info("添加员工数据{}", emp.toString());
        empService.add(emp);
        return Result.success();
    }

    /*
     * 根据id查询回显get请求
     * */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        return Result.success(empService.get(id));
    }

    /*
     * 根据id更新数据put请求
     * */
    @Log
    @PutMapping
    public Result update(@RequestBody Emp emp) {
        empService.update(emp);
        return Result.success();
    }
}
