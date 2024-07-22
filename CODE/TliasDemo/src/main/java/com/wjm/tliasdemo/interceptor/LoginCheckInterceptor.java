package com.wjm.tliasdemo.interceptor;

import com.alibaba.fastjson.JSON;
import com.aliyuncs.utils.StringUtils;
import com.wjm.tliasdemo.pojo.Result;
import com.wjm.tliasdemo.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
    @Override//目标资源运行前执行,true放行,false拦截
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //        获取请求url
        String requestURI = request.getRequestURI();
        log.info("请求url:{}", requestURI);

        //        判断是否包含login
        if (requestURI.contains("login")) {
            log.info("非登录操作,放行");
            return true;
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
            return false;
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
            return false;
        }

        //        放行操作
        log.info("令牌合法");
        return true;
    }

    @Override//目标资源运行后执行
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override//渲染完毕后运行,最后运行
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
