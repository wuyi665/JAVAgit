package com.wjm.tliasdemo.service;

import com.wjm.tliasdemo.mapper.DeptMapper;
import com.wjm.tliasdemo.pojo.Dept;
import jakarta.annotation.Resource;

import java.util.List;

public interface DeptService {
    /*
    * 查询全部部门数据
    * */
    public List<Dept> list();
}
