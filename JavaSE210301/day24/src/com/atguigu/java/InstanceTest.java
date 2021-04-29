package com.atguigu.java;

import org.junit.Test;

/**
 * 有了Class的实例以后，都可以使用反射做哪些事情呢？
 * 反射的应用一：创建对应的运行时类的对象。
 * 反射的应用二：获取对应的运行时类的完整的类的结构：属性、方法、构造器；父类、实现的接口、所在的包、注解
 * 反射的应用三：调用对应的运行时类的指定的结构：属性、方法、构造器
 * 反射的应用四：动态代理 （放到Spring中讲）
 *
 *
 *
 * 测试反射的应用一：创建对应的运行时类的对象。
 *
 * @author shkstart
 * @create 11:31
 */
public class InstanceTest {

    @Test
    public void test1() throws IllegalAccessException, InstantiationException {
        //获取Class的实例，对应着一个运行时类
        Class clazz = Person.class;

        //如何创建Person类的对象
        /*
        * 要想保证newInstance()可以正常执行，必须：
        * ① 运行时类中必须提供空参的构造器
        * ② 空参的构造器的访问权限要够。不一定非得是public
        * */
        Person obj = (Person) clazz.newInstance();
        System.out.println(obj);
    }

}
