package com.atguigu.exer1;

/**
 * 定义类Kids继承ManKind，并包括
 * 成员变量int yearsOld；
 * 方法printAge()打印yearsOld的值。
 *
 * 修改：在Kids中重新定义employeed()方法，
 * 覆盖父类ManKind中定义的employeed()方法，输出“Kids should study and no job.”
 *
 * @author shkstart
 * @create 15:25
 */
public class Kids extends ManKind{
    private int yearsOld;// 年龄

    public void printAge(){
        System.out.println("I am " + yearsOld + " years old.");
    }

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    @Override
    public void employeed() {
        System.out.println("Kids should study and no job.");
    }
}
