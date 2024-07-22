package com.wjm.tliasdemo.service;

import com.wjm.tliasdemo.pojo.Emp;
import com.wjm.tliasdemo.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {

    PageBean list(Integer page, Integer pageSize, String name, Short gender, LocalDate begin, LocalDate end);

    void delete(List<Integer> ids);

    void add(Emp emp);

    Emp get(Integer id);

    void update(Emp emp);

    Emp login(Emp emp);
}
