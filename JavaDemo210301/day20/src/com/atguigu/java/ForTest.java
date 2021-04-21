package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * 增强for循环的使用
 *
 * @author shkstart
 * @create 10:22
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll1 = new ArrayList();
        coll1.add(new String("AA"));
        coll1.add(123);//自动装箱
        coll1.add(456);//自动装箱
        coll1.add(new Person("Tom",12));

        /*
        for(元素的类型 变量名 :集合对象)
         */
        for(Object obj : coll1){
            System.out.println(obj);
        }
    }

    @Test
    public void test2(){
        int[] arr = new int[]{1,2,2,3,4};
        for(int i : arr){
            System.out.println(i);
        }
    }
    //对比方式一和方式二
    @Test
    public void test3(){
        int[] arr = new int[]{1,2,2,3,4};
        //方式一：
//        for(int i = 0;i < arr.length;i++){
//            arr[i] = 5;
//        }

        //方式二：
        for(int i : arr){
            i = 5;
        }

        for(int i = 0;i < arr.length;i++){
            System.out.println(arr[i]);
        }

    }
}
