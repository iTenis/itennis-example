package com.itennishy.sqlsession;

import java.lang.reflect.Proxy;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-28 10:23
 */
public class MySqlsession {
    private Excutor excutor= new MyExcutor();

    private MyConfiguration myConfiguration = new MyConfiguration();

    public <T> T selectOne(String statement,Object parameter){
        return excutor.query(statement, parameter);
    }

    @SuppressWarnings("unchecked")
    public <T> T getMapper(Class<T> clas){
        //动态代理调用
        return (T) Proxy.newProxyInstance(clas.getClassLoader(),new Class[]{clas},
                new MyMapperProxy(myConfiguration,this));
    }

}
