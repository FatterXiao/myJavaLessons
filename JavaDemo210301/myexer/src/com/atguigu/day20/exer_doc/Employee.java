package com.atguigu.day20.exer_doc;

import java.util.Objects;

/**
 * 存入TreeSet中的对象需要重写compareTo()方法
 * @author Mr.Helianthus
 * @create 2021-03-29 4:01 PM
 */
public class Employee implements Comparable{
    private String name;
    private int age;
    MyDate birthday;

    public Employee(String name, int age, MyDate birthday) {
        this.name = name;
        this.age = age;
        this.birthday = birthday;
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

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return age == employee.age &&
                Objects.equals(name, employee.name) &&
                Objects.equals(birthday, employee.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, birthday);
    }


       @Override
    public int compareTo(Object o) {
        // 按照名字排序
        if(this == o){
            return 0;
        }
        if(this.getClass() != o.getClass() || o == null){
            return -1;
        }
        Employee employee = (Employee)o;
        return this.getName().compareTo(employee.getName());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }
}
