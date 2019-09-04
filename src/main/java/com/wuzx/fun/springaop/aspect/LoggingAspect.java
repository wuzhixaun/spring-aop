package com.wuzx.fun.springaop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;


/**
 * @program: spring-aop->LoggingAspect
 * @description: 日志切面
 * @author: wuzx
 * @create: 2019-09-04 16:41
 * @version: 1.0
 **/
@Order(value = 1)//切面的优先级
@Aspect
@Component
public class LoggingAspect {
    private static final Logger log = LoggerFactory.getLogger(LoggingAspect.class);
    public static long startTime;
    public static long endTime;

    /*@PointCut注解表示表示横切点，哪些方法需要被横切*/
    /*切点表达式*/
    @Pointcut("execution(public * com.wuzx.fun.springaop.controller.*.*(..))")
    /*切点签名*/
    public void print() {

    }

    @Before(value = "print()")
    public void beforeMethod(JoinPoint joinPoint) {
        log.info("前置切面before……");
        startTime = System.currentTimeMillis();
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String requestURI = request.getRequestURI();
        String remoteAddr = request.getRemoteAddr();   //这个方法取客户端ip"不够好"
        String requestMethod = request.getMethod();
        String declaringTypeName = joinPoint.getSignature().getDeclaringTypeName();
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        log.info("请求url=" + requestURI + ",客户端ip=" + remoteAddr + ",请求方式=" + requestMethod + ",请求的类名=" + declaringTypeName + ",方法名=" + methodName + ",入参=" + args);
    }

    public void afterMethod(JoinPoint joinPoint) {
        endTime = System.currentTimeMillis() - startTime;
        log.info("后置切面after……");
    }

    /*@AfterReturning注解用于获取方法的返回值*/
    @AfterReturning(pointcut = "print()", returning = "object")
    public void getAfterReturn(Object object) {
        log.info("本次接口耗时={}ms", endTime);
        log.info("afterReturning={}", object.toString());
    }

    @AfterThrowing(pointcut = "print()", throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println(e);
    }

    @AfterReturning(pointcut = "print()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {

    }
}
