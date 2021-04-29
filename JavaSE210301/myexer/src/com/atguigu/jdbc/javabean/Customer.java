package com.atguigu.jdbc.javabean;

import java.sql.Date;

/**
 * @author Mr.Helianthus
 * @create 2021-04-11 10:57 PM
 */
public class Customer {
    private int id;
    private String name;
    private Date birthday;

    public Customer() {
    }

    public Customer(int id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
