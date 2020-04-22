package com.itennishy.hutool;

import cn.hutool.core.clone.CloneSupport;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Cat extends CloneSupport<Cat> {

    private String name;
    private Integer age;

}
