package com.atguigu.java;

import java.io.Serializable;

/**
 *
 * 自定义类要想实现序列化机制，需要满足：
 * 1. 实现接口：Serializable
 * 2. 内部声明一个全局常量：serialVersionUID
 * 3. 要求此类的属性都必须是可序列化的
 *
 * 说明：
 * 1. 默认情况下，基本数据类型的变量可序列化。
 * 2. ObjectOutputStream和ObjectInputStream不能序列化static和transient修饰的成员变量
 *
 * @author shkstart
 * @create 9:59
 */
public class Person implements Serializable {
    private static final long serialVersionUID = -6849794667710L;
    private  String name;
    private  int age;
    private Pet pet;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age, Pet pet) {
        this.name = name;
        this.age = age;
        this.pet = pet;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}

class Pet implements Serializable{
    String name;
    private static final long serialVersionUID = -684967710L;
    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    public Pet(String name) {
        this.name = name;
    }

    public Pet() {
    }
}
