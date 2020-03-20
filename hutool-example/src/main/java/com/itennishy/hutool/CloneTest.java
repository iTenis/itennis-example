package com.itennishy.hutool;

import cn.hutool.core.util.ObjectUtil;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CloneTest {

    private static List<Tortoise> oldTortoises = new ArrayList<Tortoise>();
    private static List<Tortoise> newTortoises = new ArrayList<Tortoise>();

    static {
        oldTortoises.add(new Tortoise("old_巴西龟1", 3));
        oldTortoises.add(new Tortoise("old_巴西龟2", 5));

        newTortoises.add(new Tortoise("new_巴西龟1", 4));
        newTortoises.add(new Tortoise("new_巴西龟2", 6));
    }

    /**
     * 场景 1：对象引用
     */
    @Test
    public void testRefer() {
        Student student1 = new Student("wgj", 24, oldTortoises);
        Student student2 = student1;
        // 设置 tortoises，tortoises 指向同一地址
        // student1.setTortoises(newTortoises);
        // student2.setTortoises(newTortoises);

        // 改变 tortoises，tortoises 内容一起改变
        student1.getTortoises().add(new Tortoise("add_巴西龟3", 7));
        compare(student1, student2);
    }

    /**
     * 场景 2：浅度克隆
     */
    @Test
    public void testClone() {
        Student student1 = new Student("wgj", 24, oldTortoises);
        Student student2 = student1.clone();
        // 设置 tortoises，tortoises 指向不同地址
        // student1.setTortoises(newTortoises);
        // student2.setTortoises(newTortoises);

        // 改变 tortoises，tortoises 内容一起改变
        student1.getTortoises().add(new Tortoise("add_巴西龟3", 7));
        compare(student1, student2);
    }

    /**
     * 场景 3：深度克隆
     */
    @Test
    public void testCloneByStream() {
        Student student1 = new Student("wgj", 24, oldTortoises);
        Student student2 = ObjectUtil.cloneByStream(student1);
        // 设置 tortoises，tortoises 指向不同地址
        // student1.setTortoises(newTortoises);
        // student2.setTortoises(newTortoises);

        // 改变 tortoises，tortoises 内容不会一起改变
        student1.getTortoises().add(new Tortoise("add_巴西龟3", 7));
        compare(student1, student2);
    }

    /**
     * 比较
     *
     * @param o1
     * @param o2
     */
    private void compare(Object o1, Object o2) {
        System.out.println("==: " + (o1 == o2));
        System.out.println("equals: " + (o1.equals(o2)));
        System.out.println(o1.toString());
        System.out.println(o2.toString());
    }

}