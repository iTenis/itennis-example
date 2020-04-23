package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 09:37
 */
public class ExceptionUtil extends RuntimeException{
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public ExceptionUtil() {
    }

    public ExceptionUtil(ResultEnum resultEnum){
        super(resultEnum.getMesg());
        this.code =  resultEnum.getCode();
    }
}
