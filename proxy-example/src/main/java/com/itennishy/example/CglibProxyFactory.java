package com.itennishy.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-22 16:14
 */
public class CglibProxyFactory implements MethodInterceptor {
    private Object targetObject;

    public Object createProxyIntance(Object targetObject) {
        this.targetObject = targetObject;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.targetObject.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("cglib日志dialing");
        result = method.invoke(targetObject, args);
        System.out.println("cglib日志dialing");
        return result;
    }
}
