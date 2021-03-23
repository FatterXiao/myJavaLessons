package com.atguigu.java2;

import com.sun.corba.se.impl.orb.ParserTable;
import org.junit.Test;

/**
 * 字符串的使用
 *
 *
 *
 * @author shkstart
 * @create 14:23
 */
public class StringTest {

    /*
    * String类的声明：
    * 1. public final class String
    *   implements java.io.Serializable, Comparable<String>, CharSequence
    *
    *  final:String不可被继承
    *  Serializable : 表明String是可以序列化的
    *  Comparable:String的对象是可以比较大小的
    *
    * 2. String的不可变性
    *  情况1：字符串通过字面量的方式进行了赋值，如果对此变量进行了重新赋值，则新的值不能在原有字符串常量池字面量
    *         的位置进行修改。必须重新指定一个新的位置赋值。
    *  情况2： 使用字符串拼接操作给字符串赋新的值，不能再原有字符串常量池的位置上进行拼接，必须开辟新的空间存放
    *         拼接以后的字符串内容。
    *  情况3： 调用String的replace()修改字符串内的指定字符时，也必须重新开辟空间保存修改以后的字符串。原有的
    *         字符串不会被修改。
    * */
    @Test
    public void test1(){
        String str1 = "hello";
        String str2 = "hello";


        System.out.println(str1 == str2);//true

        str1 = "world";

        System.out.println(str1);//world
        System.out.println(str2);//hello
    }
    @Test
    public void test2(){
        String str1 = "hello";
        String str2 = "hello";

        str1 += "world";

        System.out.println(str1);//helloworld
        System.out.println(str2);//hello
    }
    @Test
    public void test3(){
        String str1 = "hello";
        String str2 = str1.replace('l', 'w');

        System.out.println(str1);//hello
        System.out.println(str2);//hewwo
    }

    @Test
    public void test4(){
        //效率低
//        String s1 = "a";
//        for(int i = 0;i < 10;i++){
//            s1 += "b";
//        }

        Person p1 = new Person("Tom",12);
        Person p2 = new Person("Tom",12);

        System.out.println(p1.name == p2.name);//true

        p1.name = "Jerry";

        System.out.println(p2.name);//Tom

    }


    /*
    *  String的实例化方式：
    *   方式一：字面量的赋值方式
    *   方式二：new + 构造器的方式
    *
    *
    * 1. 以字面量的方式给String赋值，此时的字面量数据存储在String常量池中。
    * 2. String常量的存放位置：
    *    jdk6 : 存放在方法区（永久代）
    *    jdk7及以后：存放到堆空间
    *
    * 3. 字符串常量池中不能存放相同字面量的两个字符串数据。
    *
    * 面试题：new String("hello")在内存中创建了几个对象？
    *
    *
    * */
    @Test
    public void test5(){
        //方式一：字面量的赋值方式
        String s1 = "hello";
        //方式二：new + 构造器的方式
        String s2 = new String("hello");

        System.out.println(s1 == s2);//false

    }

    /**
     * 常量与常量的拼接结果在常量池。且常量池中不会存在相同内容的常量。
     * 只要其中有一个是变量，结果就在堆中,相当于新new了一个字符串对象。
     * 如果拼接的结果调用intern()方法，返回值就在常量池中
     */
    @Test
    public void test6(){
        String s1 = "hello";
        String s2 = "world";

        String s3 = "helloworld";
        String s4 = "hello" + "world";
        String s5 = s1 + "world";
        String s6 = "hello" + s2;
        String s7 = s1 + s2;

        String s8 = s5.intern();

        System.out.println(s3 == s4);
        System.out.println(s3 == s5);
        System.out.println(s3 == s6);
        System.out.println(s3 == s7);
        System.out.println(s5 == s6);
        System.out.println(s5 == s7);
        System.out.println(s6 == s7);

        System.out.println(s3 == s8);


    }
}
