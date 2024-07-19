package org.example.mybatisdemo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.mybatisdemo.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select id,name,age,gender,phone from user")
    public List<User> list();

}
