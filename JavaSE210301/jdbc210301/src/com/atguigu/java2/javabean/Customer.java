package com.atguigu.java2.javabean;

import java.sql.Date;

/**
 * ORM编程思想  (object  relational mapping)
 *
 * 数据库中的一张表 与  Java的一个类对应
 * 表中的一条数据   与  Java类的一个对象对应
 * 表中的一个字段   与  Java类的一个属性对应
 *
 *
 *
 *
 *
 * @author shkstart
 * @create 14:25
 */
public class Customer {
    private int id;
    private String name;
    private String email;
    private Date birth;

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", birth=" + birth +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Customer(int id, String name, String email, Date birth) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birth = birth;
    }

    public Customer() {
    }
}
