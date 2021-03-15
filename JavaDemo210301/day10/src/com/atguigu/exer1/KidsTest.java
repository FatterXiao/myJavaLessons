package com.atguigu.exer1;

/**
 * 定义类KidsTest，在类的main方法中实例化Kids的对象someKid，用该对象访问其父类的成员变量及方法。
 *
 * @author shkstart
 * @create 15:25
 */
public class KidsTest {
    public static void main(String[] args) {

        Kids someKid = new Kids();
        //调用父类的结构
        someKid.setSex(1);
//        someKid.setSalary(0);

        someKid.employeed();
        someKid.manOrWoman();

        //调用子类自己声明的结构
        someKid.setYearsOld(12);
        someKid.printAge();


    }
}
