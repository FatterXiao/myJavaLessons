package com.atguigu.exer;

/**
 * @author shkstart
 * @create 10:01
 */
public class User implements Comparable<User> {
    private String name;
    private int age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    @Override
    public int compareTo(User u) {
        int ageValue = this.age - u.age;
        if (ageValue != 0) {
            return ageValue;
        }
        return this.name.compareTo(u.name);

    }
}
