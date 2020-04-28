package com.itennishy.config;

import lombok.Data;

import java.util.List;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-28 10:22
 */
@Data
public class MapperBean {
    private String interfaceName; //接口名
    private List<Function> list; //接口下所有方法
}

