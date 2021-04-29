package com.atguigu.day24;

/**
 * @author Mr.Helianthus
 * @create 2021-04-02 10:17 PM
 */
public class Person {
    public String name;
    private int age;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void showInfo(){
        System.out.println("Invoke Person_Method: showInfo");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
