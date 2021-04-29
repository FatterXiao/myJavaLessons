package com.atguigu.java;

import javax.swing.*;

/**
 * 测试java8中接口的新特性
 * @author shkstart
 * @create 9:54
 */
public class Java8Test {
    public static void main(String[] args) {
        //知识点1：接口中的静态方法只能被接口调用，实现类不可以调用
        //SubClass.method1();//编译不通过
        CompareA.method1();

        //知识点2：实现类可以重写接口中的默认方法
        // 1）实现类如果没有重写接口中的默认方法，则实现类的对象调用的是接口中的默认方法
        //2）实现类如果重写了接口中的默认方法，则实现类的对象调用的是重写的后的方法
        SubClass sub1 = new SubClass();
        sub1.method2();
        //知识点3：如果实现类实现的多个接口中定义了同名同参数的方法，则在实现类没有重写此方法
        //的情况下，会报错---> 接口冲突
        //为了避免接口冲突，要求实现类必须重写此同名同参数的方法。
        sub1.method3();
        //知识点4：如果子类（或实现类）继承的父类和实现的接口中定义了同名同参数的方法，则在子类（或实现类）
        // 没有重写此方法的情况下，不会报错。默认调用的是父类中声明的方法。--->类优先原则
        sub1.method4();

        //知识点5：如何调用接口中的默认方法。见下面
    }
}

interface CompareA{

    //静态方法
    public static void method1(){
        System.out.println("CompareA:武汉");
    }

    //默认方法
    public default void method2(){
        System.out.println("CompareA:北京");
    }

    default void method3(){
        System.out.println("CompareA:上海");
    }

    default void method4(){
        System.out.println("CompareA:深圳");
    }

}
interface CompareB{
    default void method3(){
        System.out.println("CompareB:上海");
    }
}

class SuperClass{
    public void method4(){
        System.out.println("SuperClass:深圳");
    }
}

class SubClass extends SuperClass implements CompareA,CompareB{
    public void method2(){
        System.out.println("SubClass:北京");
    }

    public void method3(){
        System.out.println("SubClass:上海");
    }
    //知识点5
    public void method(){
        super.method4();//调用的是父类中声明的方法
        CompareA.super.method3();//调用接口中的默认方法
        CompareB.super.method3();
    }

}
