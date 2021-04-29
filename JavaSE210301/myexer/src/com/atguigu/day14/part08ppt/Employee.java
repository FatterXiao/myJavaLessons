package com.atguigu.day14.part08ppt;


public abstract class Employee {
    private String name;
    private String number;
    private MyDate birthday;

    public abstract double earnings();

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

    public void setNumber(String number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", numeber='" + number + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
