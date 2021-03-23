package com.atguigu.java2;

/**
 * final关键字的使用
 *
 * 1. final:最终的
 *
 * 2. final可以用来修饰：类、方法、变量（成员变量、局部变量）
 *
 * 3. final修饰类：说明此类不能被继承！  比如：String\StringBuffer\StringBuilder
 *
 * 4. final修饰方法：说明此方法不能被重写！比如：Object类 getClass()
 *
 * 5. final修饰变量：表示此"变量"不能被修改，即为常量
 *        5.1 final修饰成员变量
 *              可以在哪些位置赋值：显式赋值；代码块中赋值；构造器中赋值；
 *              说明：只能选择上述三个位置之一进行赋值。
 *              标识符的规范中，常量的声明的格式：XXX_YYY_ZZZ
 *              static final的成员变量：全局常量。比如：Math的PI
 *
 *
 *        5.2 final修饰局部变量
 *                 修饰方法内的局部变量：保证在使用此"变量"前，给此"变量"赋值
 *                 修饰方法形参：调用此方法时，给形参赋值。一旦赋值，在方法内就不能修改此"变量"的值。
 *
 * @author shkstart
 * @create 10:39
 */
public class FinalTest {
    public static void main(String[] args) {
        FinalTest test = new FinalTest();
//        test.num3 = 10;

        FinalTest.method1(10);
    }

    final int num = 1;
    final int num1;
    final int num2;
//    final int num3;

    {
//        num = 1;
        num1 = 1;
    }

    public FinalTest(){
        num2 = 2;
    }
    public FinalTest(String s){
        this();
    }

    public void method(){
        final int NUM = 1;
//        NUM = 2;
        System.out.println(NUM);
    }

    public static void method1(final int NUM){
//        NUM = 1;
        System.out.println(NUM);
    }

}

//class SubString extends String{
//
//}

final class A{

}
//class B extends A{
//
//}

class C{
    public final void method(){

    }
}

class D extends C{
//    public void method(){
//
//    }
}