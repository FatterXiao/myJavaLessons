package com.atguigu.java1;

/**
 * 方法的重载（overload)
 *
 * 1. 概念：在同一个类中，允许存在一个以上的同名方法，只要它们的参数个数或者参数类型不同即可。
 *   这样的多个方法，我们称彼此为方法的重载。
 *
 *   技巧：“两同一不同”：同一个类，相同的方法名；参数列表不同（参数个数不同 或参数类型不同）
 *
 * 2. 方法之间是否构成重载，与形参名、返回值类型、权限修饰符都没有关系
 *
 * 3. 如何确定调用某一个方法：① 通过方法名确定一波重载的方法  ② 通过赋的实参值，确定调用确定的形参对应的方法。
 *
 * 4. 同一个类中，相同方法名，形参列表也相同的方法，不允许存在多个。
 *
 * @author shkstart
 * @create 15:28
 */
public class OverLoadTest {
    public static void main(String[] args) {
        OverLoadTest test = new OverLoadTest();
        test.show(1.1);

        test.show(1);

        System.out.println(123);
        System.out.println("hello");
    }

    //如下的4个方法构成重载
    public void show(int i){

    }
    public void show(double d){
        System.out.println("hello1");
    }
    public void show(String s,int i){

    }

    public void show(int i,String s){

    }
    //如下的3个方法与上述4个方法不构成重载
//    public void show(double d1){
//        System.out.println("hello2");
//    }

//    public double show(double d){
//
//        return 0.0;
//    }

//    private void show(double d){}

}
