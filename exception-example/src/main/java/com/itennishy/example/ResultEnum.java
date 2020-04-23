package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 09:32
 */
public enum ResultEnum {

    SUCCESS(200, "成功"),
    ERROR(-1, "系统异常");

    private Integer code;
    private String mesg;

    ResultEnum(Integer code, String mesg) {
        this.code = code;
        this.mesg = mesg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMesg() {
        return mesg;
    }
}
