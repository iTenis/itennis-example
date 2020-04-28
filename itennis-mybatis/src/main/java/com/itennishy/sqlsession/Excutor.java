package com.itennishy.sqlsession;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-28 10:23
 */

public interface Excutor {
    public <T> T query(String statement,Object parameter);
}
