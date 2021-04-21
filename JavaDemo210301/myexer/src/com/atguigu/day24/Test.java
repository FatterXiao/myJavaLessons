package com.atguigu.day24;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @author Mr.Helianthus
 * @create 2021-04-02 9:47 PM
 */
public class Test {

    public static void main(String[] args) {
        int test = test(3,5);
        System.out.println(test);
    }

    public static int test(int x, int y){
        int result = x;
        try{
            if(x<0 || y<0){
                return 0;
            }
            result = x + y;
            return result;
        }finally{
            result = x - y;
        }
    }
}
class Base{
    Base(){
        method(100);
    }
    public void method(int i){
        System.out.println("base : " + i);
    }
}
class Sub extends Base{
    Sub(){
        super.method(70);
    }
    public void method(int j){
        System.out.println("sub : " + j);
    }
}
