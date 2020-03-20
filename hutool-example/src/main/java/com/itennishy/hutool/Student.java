package com.itennishy.hutool;

import cn.hutool.core.clone.CloneSupport;

import java.io.Serializable;
import java.util.List;

public class Student extends CloneSupport<Student> implements Serializable {

    private String         name;
    private int            age;
    private List<Tortoise> tortoises;

    public Student() {
    }

    public Student(String name, int age, List<Tortoise> tortoises) {
        this.name = name;
        this.age = age;
        this.tortoises = tortoises;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", tortoises=" + tortoises +
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

    public List<Tortoise> getTortoises() {
        return tortoises;
    }

    public void setTortoises(List<Tortoise> tortoises) {
        this.tortoises = tortoises;
    }

}