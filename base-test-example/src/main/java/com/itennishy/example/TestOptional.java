package com.itennishy.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiehuisheng@hotmail.com
 * @version 1.0
 * @date 2020-04-23 15:27
 */

public class TestOptional {

    public static void main(String[] args) {
        Animal animal = new Animal();
//        Optional<Animal> opt = Optional.ofNullable(animal);
//        System.out.println(opt.get().getName());
//        System.out.println(opt.get().getAge());
//        System.out.println(animal.getAge());

//        List<String> strings = new ArrayList<>();
//        strings.add("1");
//        strings.add("2");
//        strings.add("3");
        Map<String, String> map = new HashMap<>();
//        map.putIfAbsent("key", "oldValue");
        // 如果key存在，则忽略put操作
//        map.putIfAbsent("key", "newValue");
        map.computeIfAbsent("key",v -> "computeValue"+v);
        String value = map.get("key");
        System.out.println(value);

    }
}


class Animal{
    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
