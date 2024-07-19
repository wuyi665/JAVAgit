package com.wjm.tliasdemo.service.impl;

import com.wjm.tliasdemo.mapper.DeptMapper;
import com.wjm.tliasdemo.pojo.Dept;
import com.wjm.tliasdemo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService1 implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> list() {

        return deptMapper.list();
    }
}
