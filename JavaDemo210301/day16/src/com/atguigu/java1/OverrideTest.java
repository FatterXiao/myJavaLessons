package com.atguigu.java1;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 方法重写的规则中，关于throws+异常类型的说明：
 *
 *  子类重写的方法throws的异常类型为A,父类被重写的方法throws的异常类型为B
 *  要求：类型A可以与类型B相同，或者类型A是类型B的子类。
 *
 *  >推论：如果父类被重写的方法在声明时，没有声明throws的结果，则子类重写父类的方法，也不能使用throws的
 *  方式处理异常。
 *
 * @author shkstart
 * @create 10:09
 */
public class OverrideTest {

    public static void main(String[] args) {

        SuperClass s = new SubClass();
        try {
            s.method();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

class SuperClass{
    public void method() throws IOException {

    }

    public void method1(){

    }
}

class SubClass extends SuperClass{

    public void method() throws FileNotFoundException {

    }
    //编译失败
//    public void method1() throws FileNotFoundException{
//
//    }

}


