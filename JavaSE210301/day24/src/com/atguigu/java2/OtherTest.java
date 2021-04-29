package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author shkstart
 * @create 14:35
 */
public class OtherTest {

    //获取运行时类的父类
    @Test
    public void test1(){
        Class clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    //获取带泛型的父类
    @Test
    public void test2(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        System.out.println(genericSuperclass);
    }

    //获取父类的泛型
    @Test
    public void test3(){
        Class clazz = Person.class;

        Type genericSuperclass = clazz.getGenericSuperclass();
        ParameterizedType type = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = type.getActualTypeArguments();//获取泛型的参数

        System.out.println(((Class)actualTypeArguments[0]).getName());
    }

    //获取实现的接口
    @Test
    public void test4(){
        Class clazz = Person.class;

        Class[] interfaces = clazz.getInterfaces();
        for(Class i : interfaces){
            System.out.println(i);
        }
    }

    //获取所在的包
    @Test
    public void test5(){
        Class clazz = Person.class;

        Package package1 = clazz.getPackage();
        System.out.println(package1.getName());

    }

    @Test
    public void test6(){
        Class clazz = Person.class;

        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
