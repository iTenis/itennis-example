package com.itennishy.example;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 异常统一处理类，方便用户可以更加友好的看到错误信息
 *
 * @author: wujian
 * @time: 2019/11/9
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理系统内部异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        return ResultUtil.getError(ResultEnum.ERROR.getCode(),
                ResultEnum.ERROR.getMesg());
    }

    /**
     * 处理自定义异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler(ExceptionUtil.class)
    public Result handleMyException(ExceptionUtil e) {
        return ResultUtil.getError(e.getCode(), e.getMessage());
    }

}
