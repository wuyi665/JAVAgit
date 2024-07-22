package com.wjm.tliasdemo.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.utils.StringUtils;
import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/*
 * 配置登录过滤器
 * */
@Slf4j
//@WebFilter(urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        //        获取请求url
        String requestURI = request.getRequestURI();
        log.info("请求url:{}", requestURI);

        //        判断是否包含login
        if (requestURI.contains("login")) {
            log.info("非登录操作,放行");
            filterChain.doFilter(request, response);
            return;
        }

        //        获取请求头当中的令牌token
        String token = request.getHeader("token");

        //        判断令牌存在
        if (!StringUtils.isEmpty(token)) {
            log.info("令牌存在");
        } else {
            log.info("令牌为空,返回未登录信息");
            Result notLogin = Result.error("NOT_LOGIN");
            //转换为json格式
            //            JSONObject.toJSONString(notLogin);
            response.getWriter().write(JSON.toJSONString(notLogin));
            return;
        }

        //        解析令牌
        try {
            JwtUtils.parseJWT(token);
        } catch (Exception e) {
            //解析失败
            e.printStackTrace();
            log.info("解析令牌失败");
            Result notLogin = Result.error("NOT_LOGIN");
            //转换为json格式
            //            JSONObject.toJSONString(notLogin);
            response.getWriter().write(JSON.toJSONString(notLogin));
            return;
        }

        //        放行操作
        log.info("令牌合法");
        filterChain.doFilter(request, response);
    }
}
