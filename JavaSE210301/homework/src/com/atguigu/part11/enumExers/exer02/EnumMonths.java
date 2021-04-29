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
public enum EnumMonths {

    JANUARY(1,"1月份是一年的开始"),
    FEBRUARY(2,"2月份是一年中最短的一个月"),
    MARCH(3,"3月春暖花开"),
    APRIL(4,"4月阳光明媚"),
    MAY(5,"5月清凉初夏"),
    JUNE(6,"6月骄阳似火"),
    JULY(7,"7月下半年的第一个月"),
    AUGUST(8,"8月人已晒干"),
    SEPTEMBER(9,"秋风送爽"),
    OCTOBER(10,"10月全国同欢"),
    NOVEMBER(11,"11月寻找秋裤"),
    DECMEBER(12,"12月冰天雪地");

    private int value;
    private String description;

    private EnumMonths(int value, String description) {
        this.value = value;
        this.description = description;
    }


    public static EnumMonths getByValue(int value){
        return EnumMonths.values()[value -1];// TODO：
    }

    public String toString(){
        return value + "->" + name() + "->" + description;
    }
}
