package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 泛型：
 * 1. 为什么使用泛型？
 * 2. 掌握：泛型在集合中的使用 （泛型接口、泛型类、泛型方法）
 *      > ArrayList、Iterator、HashMap、Entry；
 *      > Comparable、Comparator
 * 3. 如何自定义泛型类、泛型接口、泛型方法
 * 4. 泛型在继承上的体现：
 *     A<G>、B<G> 有子父类关系： List<String> list = new ArrayList<String>();
 *     G<A>、G<B> 没有子父类关系： ArrayList<Object> 、 ArrayList<String>
 * 5. 通配符的使用：ArrayList<?>
 *     > 有限制条件的通配符的使用
 *
 * @author shkstart
 * @create 8:41
 */
public class GenericTest {

    @Test
    public void test1(){

        ArrayList<?> list1;
        ArrayList<Person> list2 = new ArrayList<Person>();
        ArrayList<Student> list3 = new ArrayList<Student>();

        //合法
        list1 = list2;
//        list1 = list3;

        //写入：list1是否可以添加数据？ 不可以的
//        list1.add(new Person());

        //特例：
        list1.add(null);

        //读取：可以
        list2.add(new Person());
        Object obj = list1.get(1);
        System.out.println(obj);


    }
    /*
    *  ?
    *
    * ? extends T ： A<? extends T> 可以看做是A<T>和 A<G>的父类。其中G类是T类的子类
    *
    * ? super Person: A<? super T> 可以看做是A<T>和 A<G>的父类。其中G类是T类的父类
    *
    * */
    @Test
    public void test2(){
        ArrayList<? extends Person> list1 ;
        ArrayList<? super Person> list2;

        ArrayList<Object> list3 = new ArrayList<Object>();
        ArrayList<Person> list4 = new ArrayList<Person>();
        ArrayList<Student> list5 = new ArrayList<Student>();

        //? extends T
//        list1 = list3; //编译不通过
        list1 = list4;
//        list1 = list5;

        //写入：不允许
        list1.add(null);//特例
//        list1.add(new Student());//编译不通过
//        list1.add(new Person());//编译不通过
//        list1.add(new Object());//编译不通过

        //读取：合法
        Person p1 = list1.get(0);


        //? super Person
        list2 = list3;
        list2 = list4;
//        list2 = list5;//编译不通过

        //写入：
        list2.add(null);
        list2.add(new Student());//编译通过
        list2.add(new Person());//编译通过
//        list2.add(new Object());//编译不通过

        //读取：
        Object obj = list2.get(0);
    }

}
