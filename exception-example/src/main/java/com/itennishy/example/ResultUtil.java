package com.itennishy.example;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 09:41
 */
public class ResultUtil {

    public static Result getSuccess(Object object) {
        Result result = new Result();
        result.setCode(200);
        result.setMesg("成功");
        result.setData(object);
        return result;

    }

    public static Result getError(Integer code, String mesg, Object o) {
        Result result = new Result();
        result.setCode(code);
        result.setMesg(mesg);
        result.setData(o);
        return result;
    }


    public static Result getError(Integer code, String msg){
        return getError(code, msg, null);
    }
}
