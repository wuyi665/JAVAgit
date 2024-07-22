package com.wjm.tliasdemo.aop;

import com.alibaba.fastjson.JSONObject;
import com.wjm.tliasdemo.mapper.OperateLogMapper;
import com.wjm.tliasdemo.pojo.OperateLog;
import com.wjm.tliasdemo.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAspect {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.wjm.tliasdemo.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        //获取令牌从而获取操作信息
        String token = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(token);
        //记录操作日志
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateUser((Integer) claims.get("id"));
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(JSONObject.toJSONString(result));
        operateLog.setCostTime(end - begin);
        log.info("记录操作日志");
        operateLogMapper.insert(operateLog);
        return result;
    }
}
