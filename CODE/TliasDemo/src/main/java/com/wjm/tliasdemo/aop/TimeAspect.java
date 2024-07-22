package com.wjm.tliasdemo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class TimeAspect {
    //切入点表达式
    @Pointcut("execution(* com.wjm.tliasdemo.service.*.*(..))")
    public void pt(){}
    //指定作用方法
    @Around("pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //记录开始时间
        long begin = System.currentTimeMillis();
        //调用原始方法执行
        Object object = joinPoint.proceed();
        //记录结束时间,计算方法执行总耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行总耗时:{}ms", end - begin);
        return object;
    }
}
