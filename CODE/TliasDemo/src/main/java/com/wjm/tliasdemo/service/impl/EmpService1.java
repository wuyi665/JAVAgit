package com.wjm.tliasdemo.service.impl;

import com.wjm.tliasdemo.pojo.Emp;
import com.wjm.tliasdemo.service.EmpService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService1 implements EmpService {
    @Override
    public List<Emp> list() {
        return List.of();
    }
}
