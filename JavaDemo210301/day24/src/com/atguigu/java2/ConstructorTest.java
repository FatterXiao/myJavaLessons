package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;

/**
 * @author shkstart
 * @create 14:31
 */
public class ConstructorTest {
    @Test
    public void test1(){
        Class clazz = Person.class;

        //getConstructors():获取当前运行时类中声明为public权限的构造器
//        Constructor[] cons1 = clazz.getConstructors();
//        for(Constructor c : cons1){
//            System.out.println(c);
//        }


        //getDeclaredConstructors():获取当前运行时类中所有的构造器
        Constructor[] cons2 = clazz.getDeclaredConstructors();
        for(Constructor c : cons2){
            System.out.println(c);
        }
    }
}
