package com.atguigu.part6.classAndObject.exer01;

public class Employee {
    int id;
    String name;
    double salary;
    int age;

    void printInfo() {
        System.out.println("编号：" + id + "，姓名：" + name + "，薪资：" + salary + "，年龄：" + age);
    }

    /**
     *
     * @param i id
     * @param n 姓名
     * @param s 薪资
     * @param a 年龄
     */
    void setInfo(int i, String n, double s, int a) {
        id = i;
        name = n;
        salary = s;
        age = a;
    }
}
