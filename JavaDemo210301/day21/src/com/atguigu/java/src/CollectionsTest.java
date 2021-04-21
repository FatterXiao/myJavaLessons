package com.atguigu.java.src;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Collections:操作集合(List\Set\Map)的工具类
 *
 *
 * Collection 和 Collections 区别？
 *
 * @author shkstart
 * @create 14:06
 */
public class CollectionsTest {

    /*
    reverse(List)：反转 List 中元素的顺序
    shuffle(List)：对 List 集合元素进行随机排序
    sort(List)：根据元素的自然顺序对指定 List 集合元素按升序排序  类似于：Arrays.sort(Object[])
    sort(List，Comparator)：根据指定的 Comparator 产生的顺序对 List 集合元素进行排序  类似于：Arrays.sort(Object[],Comparator)
    swap(List，int， int)：将指定 list 集合中的 i 处元素和 j 处元素进行交换

    Object max(Collection)：根据元素的自然顺序，返回给定集合中的最大元素
    Object max(Collection，Comparator)：根据 Comparator 指定的顺序，返回给定集合中的最大元素
    Object min(Collection)
    Object min(Collection，Comparator)
    int frequency(Collection，Object)：返回指定集合中指定元素的出现次数
    void copy(List dest,List src)：将src中的内容复制到dest中
    boolean replaceAll(List list，Object oldVal，Object newVal)：使用新值替换 List 对象的所有旧值

     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(34);
        list.add("AA");
        list.add("AA");
        list.add("AA");
        list.add("CC");
        list.add(new Date());
        System.out.println(list);


//        Collections.reverse(list);
//        Collections.shuffle(list);
        Collections.swap(list,0,2);
        System.out.println(Collections.frequency(list, "AA"));

//        System.out.println(list);
    }
    @Test
    public void test2(){

        //void copy(List dest,List src)：将src中的内容复制到dest中
        List list = new ArrayList();
        list.add(34);
        list.add("AA");
        list.add("AA");
        list.add("AA");
        list.add("CC");

        //错误的做法：
//        List dest = new ArrayList();
//        Collections.copy(dest,list);

//        System.out.println(dest);

        //正确的做法：
        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }
}
