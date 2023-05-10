package com.example.demo.controller;

import java.io.Serializable;

/**
 * @author hwd
 * @version 1.0
 * @since 2023/4/7
 */
public class B implements Serializable {
    private Integer age;

    public void setAge(Integer age) {
        this.age=age;
    }

    public Integer getAge(){
        return age;
    }
}
