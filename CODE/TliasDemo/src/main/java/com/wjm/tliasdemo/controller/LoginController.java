package com.wjm.tliasdemo.controller;

import com.wjm.tliasdemo.pojo.Emp;
import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.service.EmpService;
import com.wjm.tliasdemo.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
public class LoginController {
    @Autowired
    EmpService empService;

    @Autowired
    JwtUtils jwtUtils;

    /*
     * 根据用户名和密码登录
     * */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        log.info("登录信息认证{}", emp);
        Emp e = empService.login(emp);

        if (e != null) {
            //生成令牌并下发
            Map<String, Object> map = new HashMap<>();
            map.put("id", e.getId());
            map.put("name", e.getName());
            map.put("password", e.getPassword());
            String s = jwtUtils.generateJwt(map);
            return Result.success(s);
        }

        return Result.error("用户名或密码错误");
    }
}
