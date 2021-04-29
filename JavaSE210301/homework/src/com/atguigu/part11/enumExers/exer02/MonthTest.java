package com.atguigu.part11.enumExers.exer02;

/*
    案例：
​	1、声明月份枚举类Month：
​	（1）创建：1-12月常量对象
​	（2）声明两个属性：value（月份值，例如：JANUARY的value为1），
​						description（描述，例如：JANUARY的description为1月份是一年的开始）。
​	（3）声明一个有参构造，创建12个对象
​	（4） 声明一个方法：public static Month getByValue(int value)
​	（5）重写toString()：返回对象信息，例如：1->JANUARY->1月份是一年的开始。
​	2、在测试类中，从键盘输入1个1-12的月份值，获取对应的月份对象，并打印对象
 */
public class MonthTest {
    public static void main(String[] args) {
        EnumMonths month = EnumMonths.getByValue(1);
        System.out.println(month);
    }
}
