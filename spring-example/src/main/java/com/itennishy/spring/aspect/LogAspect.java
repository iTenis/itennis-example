package com.itennishy.spring.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import java.util.Arrays;
import java.util.concurrent.Executors;

@Aspect
public class LogAspect {

    @Pointcut("execution(public int com.itennishy.spring.aspect.divTest.*(..))")
    public void Pointcut() {
    }

    @Before("Pointcut()")
    public void LogStart(JoinPoint joinPoint) {
        System.out.println("LogStart...函数名" + joinPoint.getSignature().getName() + " 参数" + Arrays.asList(joinPoint.getArgs()));
    }

    @After("Pointcut()")
    public void LogEnd(JoinPoint joinPoint) {
        System.out.println("LogEnd..." + joinPoint.getSignature().getName());
    }

    @AfterReturning(value = "Pointcut()",returning = "o")
    public void LogReturning(JoinPoint joinPoint,Object o) {
        System.out.println("LogReturning..."+o);
    }

    @AfterThrowing(value = "Pointcut()",throwing = "o")
    public void LogException(JoinPoint joinPoint, Exception o) {
        System.out.println("LogException..."+o);
    }
}
