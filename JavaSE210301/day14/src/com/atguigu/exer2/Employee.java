package com.atguigu.exer2;

/**
 *
 * 定义一个Employee类，该类包含：
 * private成员变量name,number,birthday，其中birthday 为MyDate类的对象；
 * abstract方法earnings()；
 * toString()方法输出对象的name,number和birthday。
 *
 * @author dj
 * @create 2021-03-16 19:52
 */
abstract class Employee {
    private String name;//员工姓名
    private String number;//员工工号
    private MyDate birthday;//员工生日

    public Employee() {
    }

    public Employee(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public Employee(String name, String number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }


    public MyDate getBirthday() {
        return birthday;
    }

    /**
     * 发工资方式
     * @return 返回员工的工资
     */
    public abstract double earnings();

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", birthday=" + birthday.toDateString() +
                '}';
    }
}
