package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 测试Collection集合的遍历操作
 *
 *
 * Iterator接口就是用来遍历Collection集合元素的。
 *
 * @author shkstart
 * @create 9:37
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll1 = new ArrayList();
        coll1.add(new String("AA"));
        coll1.add(123);//自动装箱
        coll1.add(456);//自动装箱
        coll1.add(new Person("Tom",12));

//        System.out.println(coll3);
        //得到Iterator迭代器接口的对象
        Iterator iterator = coll1.iterator();
//        System.out.println(iterator.getClass());

//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());//如果调用的次数超过了集合中元素的个数，报NoSuchElementException

        //写法1：强烈不建议
//        for(int i = 0;i < coll1.size();i++){
//            System.out.println(iterator.next());
//        }

        //写法2：推荐
        while(iterator.hasNext()){
            //next():① 指针下移  ② 将下移以后指针指向的集合位置上的元素返回
            System.out.println(iterator.next());
        }

        //错误写法1：
//        while(iterator.next() != null){
//            System.out.println(iterator.next());
//        }
        //错误写法2:
//        while(coll1.iterator().hasNext()){
//            System.out.println(coll1.iterator().next());
//        }
    }

}
