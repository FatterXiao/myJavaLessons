package com.atguigu.java;

/**
 * @author shkstart
 * @create 16:21
 */
public class Student extends Person {

    String major;
    int id = 1002;
//    int id = 1003;

    public Student(){

    }

    public Student(String major){
        this.major = major;
    }

    public void study(){
        System.out.println("学生学习");
    }

    @Override
    public void eat() {
        System.out.println("学生应该多吃有营养的食物");
    }

    public void info(){
        System.out.println("name : " + this.name);
        System.out.println("age : " + this.age);
        System.out.println("major : " + this.major);
        System.out.println("id : " + this.id);//1002
        System.out.println("id : " + super.id); //1001
    }

    public void display(){
        this.sleep();

        this.eat();//调用子类重写的方法
        super.eat();//调用父类中被重写的方法
    }
}
