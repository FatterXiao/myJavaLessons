package com.atguigu.java1;

/**
 * 1. Object类是所有Java类的根父类
 * 2. 如果在类的声明中未使用extends关键字指明其父类，则默认父类为java.lang.Object类
 * 3. 重点讲解equals()和toString()
 *
 * 面试题： 区分 finalize \ final \ finally
 *
 * @author shkstart
 * @create 14:20
 */
public class ObjectTest {
    public static void main(String[] args) {
        Animal a = new Animal();
        System.out.println(a.getClass());//class com.atguigu.java1.Animal

        Animal a1 = new Dog();
        System.out.println(a1.getClass());//class com.atguigu.java1.Dog
    }
}
