package com.atguigu.java1;

/**
 * @author shkstart
 * @create 14:14
 */
public class Student extends Person{

//    String name;
//    int age;

    String major;//专业

    public Student(String name, int age) {
//        this.name = name;
//        this.age = age;
        setName(name);
        setAge(age);
    }

    public Student() {

    }

//    public void eat(){
//        System.out.println("吃饭");
//    }
//    public void sleep(){
//        System.out.println("睡觉");
//    }
//    public void think(String thing){
//        System.out.println("思考：" + thing);
//    }

    public void study(){
        System.out.println("学习");
    }
}
