package com.itennishy.hutool;

import java.io.Serializable;

public class Tortoise implements Serializable {

    private String name;
    private int    age;

    public Tortoise() {
    }

    public Tortoise(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Tortoise{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}