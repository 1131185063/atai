package com.dream.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect
@Component
@Slf4j
public class LogAop {
    @Pointcut("execution(public * com.dream.controller..*.*(..))")
    public void myMethod(){}

    @Before("myMethod()")
    public void before(){
        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        log.info("request before------------method:"+request.getMethod()+"-------queryStr:"+request.getQueryString()+"---url:"+request.getRequestURI());
    }

    @AfterReturning(value = "myMethod()",returning = "retObj")
    public void afterReturning(Object retObj){

    }
}
