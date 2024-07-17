package org.example.springbootdemo.service.impl;

import org.example.springbootdemo.dao.EmpDao;
import org.example.springbootdemo.pojo.Emp;
import org.example.springbootdemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceA implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    public List<Emp> listEmp() {
        //调用到获取数据
        List<Emp> emplist = empDao.listEmp();
        //对数据进行转换处理
        emplist.stream().forEach(emp -> {
            //处理gender
            String gender = emp.getGender();
            if ("1".equals(gender)) {
                emp.setGender("男");
            } else {
                emp.setGender("女");
            }
            //处理job
            String job = emp.getJob();
            if ("1".equals(job)) {
                emp.setJob("讲师");
            } else if ("2".equals(job)) {
                emp.setJob("班主任");
            } else {
                emp.setJob("就业指导");
            }
        });
        return emplist;
    }
}
