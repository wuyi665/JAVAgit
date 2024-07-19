package com.wjm.tliasdemo.mapper;

import com.wjm.tliasdemo.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*
    * 查询全部部门操作
    * @return
    * */
    @Select("select * from dept")
    public List<Dept> list();

}
