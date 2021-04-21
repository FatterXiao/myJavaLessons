package com.atguigu.part17.exer01.test;

import org.junit.Test;

/**
 * @author Mr.Helianthus
 * @create 2021-04-12 9:04 PM
 */
public class Test01 {
    // 在测试类Test01的test01()测试方法中，用反射获取AtguiguDemo类的Class对象，
    // 并获取它的所有信息，包括类加载器、包名、类名、父类、父接口、属性、构造器、方法们等
    @Test
    public void test() throws ClassNotFoundException {
        Class clazz = Class.forName("com.atguigu.part17.exer01.AtguiguDemo");
        //ClassLoader
    }
}
