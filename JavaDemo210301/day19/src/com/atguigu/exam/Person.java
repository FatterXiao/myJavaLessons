package com.atguigu.exam;

/**
 * 题目1：Person类定义如下，如何实现自然排序（按年龄从小到大排序）
 *
 * 题目2：定义一个Comparator的实例，实现上题的Person类按姓名从大到小排序
 *
 * @author shkstart
 * @create 9:23
 */
public class Person implements Comparable{
    String name;
    int age;

    public int compareTo(Object obj){
        if(this == obj){
            return 0;
        }

        if(obj instanceof Person){
            Person p = (Person)obj;
            return this.age - p.age;
        }
        throw new RuntimeException("输入的类型不匹配");
    }
}
