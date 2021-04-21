package com.atguigu.java3;

import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 * @author shkstart
 * @create 16:39
 */
public class GenericTest {
    /*
    泛型在继承上的体现

    情况1：A类是B类的父类，结论：G<A> 和 G<B> 不是子父类的关系，是并列关系的两个类

    情况2：A类是B类的父类，结论：A<G>是B<G>的父类，可以使用多态。
     */
    @Test
    public void test1(){
        Object obj;
        String str = new String();
        obj = str;//多态

        Object[] arr1;
        String[] arr2 = new String[10];
        arr1 = arr2;//动态

        List<Person> list1;
        List<Student>  list2 = new ArrayList<Student>();
//        list1 = list2; //编译不通过


        List<Object> list3;
        List<String> list4 = new ArrayList<String>();
//        list3 = list4;//编译不通过
        /*
        反证法：
        * 如果可以list3 = list4;
        * list3 = new ArrayList<String>();
        * list3.add(123);
        * */

//        String str1 = new Date(23423432L);


    }
    @Test
    public void test2(){
        List<String> list1;
        ArrayList<String> list2 = new ArrayList<>();
        list1 = list2;
    }

    /*
    * 通配符的使用: ?
    *
    * A<?> 可以看做是A<G> 的父类。
    * */
    @Test
    public void test3(){
        ArrayList<String> list = new ArrayList<>();
//        method(list); //List<Object> list1 = list
        method1(list); //编译通过

        method2(list);

        ArrayList<Object> list1 = new ArrayList<>();
        method2(list1);
    }

    public void method(ArrayList<Object> list1){

    }
    public void method1(ArrayList<String> list1){

    }

    public void method2(ArrayList<?> list1){

    }

}
