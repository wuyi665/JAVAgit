package com.wjm.tliasdemo.mapper;

import com.wjm.tliasdemo.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {
    /*
     * 查询全部部门操作
     * @return
     * */
    @Select("select * from dept")
    List<Dept> list();

    /*
     * 根据id删除部门
     * */
    @Delete("delete from dept where id =#{id}")
    void deleteById(Integer id);

    /*
     * 根据部门名称新增部门
     * */
    @Insert("insert into dept(name,create_time,update_time) values(#{name},#{createTime},#{updateTime})")
    void insert(Dept dept);

    /*
    * 根据id查询部门
    * */
    @Select("select id, name, create_time, update_time from dept where id=#{id}")
    Dept findById(Integer id);

    /*
    * 修改部门信息
    * */
    @Update("update dept set name=#{name},update_time=#{updateTime} where id=#{id}")
    void update(Dept dept);
}
