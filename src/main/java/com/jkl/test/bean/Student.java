package com.jkl.test.bean;

/**
 * Created by Daryl on 2020/06/05 13:37
 */
public class Student {
    private Integer id;
    private String name;

    public Student() {
        System.out.println("Student构造方法");
    }

    public Student(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
