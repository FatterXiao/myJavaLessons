package com.atguigu.java2;

/**
 * StringBuffer\StringBuilder的测试
 *
 * @author shkstart
 * @create 16:51
 */
public class StringBufferBuilderTest {
    /*
    * 区分String\StringBuffer\StringBuilder
    * 都是字符串相关的类
    *
    *
    * String:不可变的字符序列；底层使用char[]数组存储
    * StringBuffer:可变的字符序列；线程安全的，效率低；底层使用char[]数组存储
    * StringBuilder:可变的字符序列；线程不安全的，效率高；jdk5.0引入。底层使用char[]数组存储
    *
    * String str = new String("abc"); // char[] value = new char[]{'a','b','c'}
    *
    * StringBuffer sb = new StringBuffer("abc");//char[] value = new char["abc".length + 16]
    *   //value[0] = 'a',value[1] = 'b',value[2] = 'c';
    *
    * sb.append("m");//value[3] = 'm'
    *
    *
    *
    * */
}
