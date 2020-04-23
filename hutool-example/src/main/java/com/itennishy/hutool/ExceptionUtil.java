package com.itennishy.hutool;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-22 17:33
 */
public class ExceptionUtil extends Exception{

    private Integer code;
    public ExceptionUtil(String mesg){
        super(mesg);
    }

    public ExceptionUtil(Integer code, String message){
        super(message);
        this.code = code;
    }

    public ExceptionUtil(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
}
