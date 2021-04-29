package com.atguigu.java1;

/**
 * @author shkstart
 * @create 14:14
 */
public class Person extends Creature{ //人类
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }
    public void eat(){
        System.out.println("吃饭");
        sleep();
    }
    private void sleep(){
        System.out.println("睡觉");
    }
    public void think(String thing){
        System.out.println("思考：" + thing);
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

    public void info(){
        System.out.println("name = " + name +",age = " + age);
    }
}
