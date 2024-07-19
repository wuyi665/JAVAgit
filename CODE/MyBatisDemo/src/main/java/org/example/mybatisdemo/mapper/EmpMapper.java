package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.*;
import org.example.mybatisdemo.pojo.Emp;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select * from emp")
    public List<Emp> findAll();

    //    @Select("select * from emp where id=#{id}")
    public List<Emp> findById(Integer id, String name, Short gender);

//    @Delete("delete from emp where id= #{id}")
    public void delete(List<Integer> ids);

    @Insert("insert into emp(username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    public void insert(Emp emp);

    //    @Update("update emp" +
//            "id=#{id}" +
//            "where name = #{name}")
    public void update(Emp emp);
}
