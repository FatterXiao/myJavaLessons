package com.atguigu.java1;

/**
 * 测试类中实例变量赋值的先后顺序
 *
 * 1. 类中实例变量赋值有哪些位置：
 * ① 默认初始化  （只能调用一次）
 * ② 显式初始化  （只能调用一次）
 * ③ 构造器中初始化  （只能调用一次）
 * ④ 代码块中赋值
 * ⑤ 通过"对象.属性" 或 "对象.方法"的方法给属性赋值（可以多次调用）
 *
 * 2. 类中实例变量赋值的先后顺序
 *  ① - ② / ④ -  ③ - ⑤
 *
 *  说明：属性的显式赋值与代码块中的赋值的先后顺序完全取决于声明的先后顺序。
 *
 * @author shkstart
 * @create 9:38
 */
public class FieldTest {
    public static void main(String[] args) {
        Order o1 = new Order();
        System.out.println(o1.orderId);
    }

}

class Order{



    int orderId = 1;

    {
        System.out.println("代码块");
        orderId = 2;
    }


    public Order(){
        orderId = 3;
    }
}
