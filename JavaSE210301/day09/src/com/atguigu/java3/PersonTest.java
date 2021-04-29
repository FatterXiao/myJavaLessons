package com.atguigu.java3;

/**
 * this关键字的使用
 *
 *  1. this:可以理解为当前对象 或当前正在创建的对象
 *
 *  2. this用来调用属性、方法；构造器
 *
 *  3.1 this在方法内调用属性、方法:
 *
 *   ① 在类的方法中，如果方法的形参与类中定义的属性同名了，则为了区分方法内使用的变量是形参还是属性，我们需要
 *   引入this关键字。
 *      > 使用this关键字调用的变量就是属性，不使用this关键字调用的变量就是形参。
 *   ② 在类的方法中，如果方法的形参与类中定义的属性不同名，或没有形参等情况，我们说在方法内调用属性的话，可以省略
 *   this.
 *   ③ 在类的方法中，可以调用其他的方法，此时的this关键字也可以省略。
 *
 *  3.2 this在构造器内调用属性、方法:
 *      ① 如果出现了构造器形参变量的名字与类中定义的属性同名了，则我们需要引入this关键字。
 *       > 使用this关键字调用的变量就是属性，不使用this关键字调用的变量就是形参。
 *      ② 如果出现了构造器形参变量的名字与类中定义的属性不同名或没有形参，我们说在构造器内调用属性的话，可以省略
 *         this.
 *      ③ 在类的构造器中，可以调用其他的方法，此时的this关键字也可以省略。
 *
 *
 *
 * @author shkstart
 * @create 16:24
 */
public class PersonTest {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.setAge(10);
        p1.setName("Tom");

        p1.show();
    }

}

class Person{
    //属性
    private String name;
    private int age;
    //构造器
    public Person(){
    }

    public Person(int age){
        this.age = age;
        this.eat();
    }

    public Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    //方法
    public void eat(){
        System.out.println("人吃饭");

//        this.sleep();
        sleep();
    }
    public void sleep(){
        System.out.println("人睡觉");
    }
    public void think(String message){
        System.out.println("人思考：" + message);
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public int getAge(){
        return age;
    }

    public void show(){
        System.out.println("name = " + this.name + ",age = " + age);
    }

}
