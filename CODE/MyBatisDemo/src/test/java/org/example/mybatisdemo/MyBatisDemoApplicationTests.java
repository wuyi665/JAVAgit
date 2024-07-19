package org.example.mybatisdemo;

import org.example.mybatisdemo.mapper.EmpMapper;
import org.example.mybatisdemo.mapper.UserMapper;
import org.example.mybatisdemo.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@SpringBootTest
class MyBatisDemoApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private EmpMapper empMapper;

    @Test
    public void test() {
//        empMapper.delete(18);
//        empMapper.insert(new Emp((Integer) 17, "Tom", "tom", (short) 1, (short) 2, "img.url",
//                LocalDate.now(), 2, LocalDateTime.now(), LocalDateTime.now()));
        Emp emp1 = new Emp();
        emp1.setId(1);
        emp1.setName("金庸");
        emp1.setUpdateTime(LocalDateTime.now());
        empMapper.update(emp1);
    }

    @Test
    public void test1() {
        List<Integer> ids = Arrays.asList(15, 16, 21);
        empMapper.delete(ids);
    }
}
