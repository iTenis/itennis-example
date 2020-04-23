package com.itennishy.example;

import lombok.Data;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 09:28
 */
@Data
public class Result<T> {

    private Integer code;
    private String mesg;
    private T data;
}
