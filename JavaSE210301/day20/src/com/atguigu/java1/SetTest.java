package com.atguigu.java1;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 一、
 *  java.util.Collection:存储一个一个的数据
 *   |----java.util.Set:存储无序的、不可重复的数据   ----> 高中学的"集合"
 *               |---- HashSet：作为Set的主要实现类
 *                      |---- LinkedHashSet：作为HashSet的子类，遍历集合元素时，可以实现按照添加元素的顺序实现遍历。
 *                                          对于频繁的遍历操作，建议使用此类。
 *                                          原因：在HashSet的基础上，给每个元素提供了一对指针，记录这个元素之前的和之后的元素。
 *               |---- TreeSet：可以按照添加的元素的指定的属性的大小顺序实现遍历。 （了解）
 *                              向TreeSet中添加的元素的要求：
 *                              ① 必须是同一个类型的元素
 *                              ② 元素需要考虑排序的方式：a.自然排序  b.定制排序
 *
 * 二、 Set在 Collection的基础上，没有新增的方法。
 *
 * 三、结论：向Set集合中添加的元素，要求其所在的类必须重写两个方法：equals()、hashCode()  --->主要针对的是HashSet
 *          对于TreeSet来说，判断数据是否重复，不参考equals()、hashCode()，只是参考自然排序中的compareTo() 或
 *          定制排序中的compare().
 *
 * @author shkstart
 * @create 14:28
 */
public class SetTest {

    /*
    Set的主要实现类是HashSet。通过HashSet体会Set的特点
    1. 不可重复性：按照equals()进行判断，不能有返回值为true的元素。
    2. 无序性：不等于随机性。有别于数组存储数据时，依次紧密排列。
              元素到底存储在数组中的哪个位置呢？由添加的元素所在的类重写的hashCode()决定的。
     */

    @Test
    public void test1(){
        HashSet set = new HashSet();

        set.add(123);//自动装箱
        set.add("AA");
        set.add(new String("BB"));
        set.add(new String("BB"));
        set.add(new Person("Tom",12));
        set.add(new Person("Tom",12));

//        System.out.println(set);
        //使用迭代器
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //使用增强for循环
        for(Object obj : set){
            System.out.println(obj);
        }

        //使用一般for循环：不行

    }

    @Test
    public void test2() {
        HashSet set = new LinkedHashSet();

        set.add(123);//自动装箱
        set.add("AA");
        set.add(new String("BB"));
        set.add(new String("BB"));
        set.add(new Person("Tom", 12));

        System.out.println(set);
    }
}
