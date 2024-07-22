package com.wjm.tliasdemo.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wjm.tliasdemo.mapper.EmpMapper;
import com.wjm.tliasdemo.pojo.Emp;
import com.wjm.tliasdemo.pojo.PageBean;
import com.wjm.tliasdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class EmpService1 implements EmpService {
    @Autowired
    EmpMapper empMapper;

    @Override
    public PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end) {
        //设置分页参数
        PageHelper.startPage(page, pageSize);
        //查询数据
        List<Emp> empList = empMapper.page(name, gender, begin, end);
        //分页展示
        PageInfo<Emp> pageInfo = new PageInfo<>(empList);
        //返回PageBean对象
        return new PageBean(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public void delete(List<Integer> ids) {
        empMapper.delete(ids);
    }

    @Override
    public void add(Emp emp) {
        //补充基础属性
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.add(emp);
    }

    @Override
    public Emp get(Integer id) {
        return empMapper.get(id);
    }

    @Override
    public void update(Emp emp) {
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp);
    }

    @Override
    public Emp login(Emp emp) {
        return empMapper.login(emp);
    }
}
