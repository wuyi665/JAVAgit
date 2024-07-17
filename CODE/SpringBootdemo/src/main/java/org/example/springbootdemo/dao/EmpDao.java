package org.example.springbootdemo.dao;

import org.example.springbootdemo.pojo.Emp;

import java.util.List;

public interface EmpDao {
    //面向接口编程，创建读取数据接口
    public List<Emp> listEmp();
}
