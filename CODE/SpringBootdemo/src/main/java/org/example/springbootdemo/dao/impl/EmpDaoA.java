package org.example.springbootdemo.dao.impl;

import org.example.springbootdemo.dao.EmpDao;
import org.example.springbootdemo.pojo.Emp;
import org.example.springbootdemo.utils.XmlParserUtils;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.util.List;

@Repository
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        //加载解析xml文件
        File file = new File("D:\\IDEA\\CODE\\JAVAgit\\CODE\\SpringBootdemo\\src\\main\\resources\\emp.xml");
        List<Emp> emplist = XmlParserUtils.parse(file, Emp.class);
        return emplist;
    }
}
