package com.itennishy.spring.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
@Aspect
public class MyAnnoImpl {

    @Pointcut("@annotation(com.itennishy.spring.annotation.MyAnno)")
    public void cut() {
    }

    @Around("cut()")
    public void around(ProceedingJoinPoint joinPoint) {
        System.out.println("around-begin");
        try {
            joinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("around-end");

    }


    @Before("cut()")
    public void before(JoinPoint joinPoint) {
        MethodSignature sign =  (MethodSignature)joinPoint.getSignature();
        Method method = sign.getMethod();
        MyAnno annotation = method.getAnnotation(MyAnno.class);
        System.out.println("before:"+method+"-"+annotation.value());

    }

    @After("cut()")
    public void after(){
        System.out.println("after");
    }
}
