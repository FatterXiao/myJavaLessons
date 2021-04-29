package com.atguigu.java2;

/**
 * 类中属性赋值的位置：
 *
 * ① 属性的默认赋值（或默认初始化）
 * ② 属性的显式赋值（或显式初始化）
 * ③ 构造器中赋值（或在构造中初始化）
 *
 *
 * ④ 通过"对象.属性" 或 "对象.方法"的方式，赋值
 *
 * 赋值的先后顺序：
 * ① - ② - ③ - ④
 *
 * 说明：
 * 上述的① ② ③ 三个步骤在初始化过程中，只执行一次！
 *
 *
 *
 * @author shkstart
 * @create 15:30
 */
public class UserTest {
    public static void main(String[] args) {
        User u1 = new User(10);
        System.out.println(u1.age);

        u1.age = 20;
        u1.age = 30;
        System.out.println(u1.age);
    }
}


class User{
    String name;
    int age = 1;

    public User(){

    }
    public User(int a){
        age = a;
    }
}