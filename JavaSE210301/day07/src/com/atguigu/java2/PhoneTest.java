package com.atguigu.java2;

/**
 *
 * 类中属性的设计
 *
 * 1. 复习：变量的分类：① 按照数据类型： 基本数据类型  vs 引用数据类型
 *                    ② 按照在类中声明的位置： 成员变量  vs 局部变量
 *
 * 2. 对比成员变量  vs 局部变量
 *     相同点：都是变量，定义的格式相同的。
 *     不同点：
 *          ① 类中声明的位置不同
 *              成员变量：直接声明在类中
 *              局部变量：方法内部、方法的形参、构造器内部、构造器形参、代码块内部等
 *          ② 在内存中分配的位置不同
 *              成员变量：分配在堆空间中
 *              局部变量：分配在栈空间中
 *          ③ 成员变量声明以后，可以有默认赋值。
 *                  整型：0
 *                  浮点型：0.0
 *                  字符型：0 或 \u0000
 *                  boolean型：false
 *                  引用类型：null
 *
 *            而局部变量在调用前，必须显式赋值，因为没有默认赋值。
 *          ④ 成员变量可以在声明前，添加权限修饰符。
 *            而局部变量不能使用权限修饰符进行修饰。
 *            （此时的权限修饰符有：public \ private \ protected \缺省）
 *
 * @author shkstart
 * @create 16:47
 */
public class PhoneTest {
    public static void main(String[] args) {
        Phone p1 = new Phone();
        System.out.println(p1.phoneName);
        System.out.println(p1.price);

        p1.sendMessage("有内鬼，终止交易");
    }
}

class Phone{
    //属性：成员变量
    String phoneName;
    double price;

    //方法
    public void call(){
        int hour = 1; //局部变量
        System.out.println("手机打了" + hour + "小时的电话");
    }
    public void sendMessage(String message){ //message:局部变量
        System.out.println("发送短信：" + message);
    }
    public void playGame(String game){//game:局部变量
        System.out.println("玩游戏：" + game);
    }
}
