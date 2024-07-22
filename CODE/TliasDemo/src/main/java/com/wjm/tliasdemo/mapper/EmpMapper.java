package com.wjm.tliasdemo.mapper;

import com.wjm.tliasdemo.pojo.Emp;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    /*
     * 获取总记录数,利用插件获取分页数据
     * */
    List<Emp> page(String name, Short gender, LocalDate begin, LocalDate end);

    /*
     * 根据id批量删除员工数据
     * */
    void delete(List<Integer> ids);

    /*
     * 添加员工信息
     * */
    @Insert("insert into emp (username, name, gender, image, job, entrydate, dept_id, create_time, update_time)" +
            " values(#{username},#{name},#{gender},#{image},#{job},#{entrydate},#{deptId},#{createTime},#{updateTime})")
    void add(Emp emp);

    /*
     * 根据id查询回显员工信息
     * */
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time  from emp where id =#{id}")
    Emp get(Integer id);

    /*
     * 根据id动态更新员工信息
     * */
    void update(Emp emp);

    /*
    * 根据登录信息认证
    * */
    @Select("select id, username, password, name, gender, image, job, entrydate, dept_id, create_time, update_time from emp where username=#{username} and password=#{password}")
    Emp login(Emp emp);

    /*
    * 根据部门id删除员工信息
    * */
    @Delete("delete from emp where dept_id=#{deptId}")
    void deleteBydeptId(Integer deptId);
}
