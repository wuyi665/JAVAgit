package com.wjm.tliasdemo.service;

import com.wjm.tliasdemo.pojo.Dept;

import java.util.List;

public interface DeptService {

    List<Dept> list();

    void delete(Integer id);

    void insert(Dept dept);

    Dept findById(Integer id);

    void update(Dept dept);
}
