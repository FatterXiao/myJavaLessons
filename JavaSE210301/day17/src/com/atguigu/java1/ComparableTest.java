package com.atguigu.java1;

import org.junit.Test;

import java.util.Arrays;

/**
 * 1. Java中对多个对象进行排序操作，有如下的两种方式：
 *    自然排序：需要与 Comparable 结合使用
 *    定制排序：需要与 Comparator 结合使用
 *
 * 2. 如何实现自然排序？
 *   ① 待排序的多个对象所属的类需要实现Comparable接口
 *   ② 此类需要实现compareTo()，在此方法中指名排序的方式
 *
 *
 * 3. 对比两种排序方式？
 *   自然排序：针对具体要排序的类，提前提供的一种排序方式。在没有特殊需求情况下，默认使用的排序方法。
 *            “一劳永逸”
 *   定制排序：针对于临时性的需求或多样性的需求，我们临时提供的一种排序方式。
 *
 *
 *
 * @author shkstart
 * @create 14:41
 */
public class ComparableTest {

    @Test
    public void test1(){
        String[] arr = new String[]{"Tom","Kite","Abel","Kitty","Tonny","Jack"};

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));

    }

    @Test
    public void test2(){
        Goods g1 = new Goods("Razer", 120);
        Goods g2 = new Goods("Lenovo", 23);
        Goods g3 = new Goods("HP", 56.43);
        Goods g4 = new Goods("Logitech", 78.65);
        Goods g5 = new Goods("Asus", 87.67);

        Goods[] arr = new Goods[]{g1,g2,g3,g4,g5};

        System.out.println(Arrays.toString(arr));
        //java.lang.ClassCastException: com.atguigu.java1.Goods cannot be cast to java.lang.Comparable
        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}
