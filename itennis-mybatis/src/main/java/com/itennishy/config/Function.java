package com.itennishy.config;

import lombok.Data;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-28 10:22
 */
@Data
public class Function {
    private String sqltype;
    private String funcName;
    private String sql;
    private Object resultType;
    private String parameterType;

}
