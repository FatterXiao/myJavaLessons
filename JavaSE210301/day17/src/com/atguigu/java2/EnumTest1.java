package com.atguigu.java2;

/**
 *
 * 使用enum定义枚举类
 *
 * @author shkstart
 * @create 16:57
 */
public class EnumTest1 {

    public static void main(String[] args) {
        Season1 spring = Season1.SPRING;
        System.out.println(spring);
    }
}

enum Season1{//季节
    //内部提供4个枚举类的对象
    SPRING("春天","春暖花开"),
    SUMMER("夏天","夏日炎炎"),
    AUTUMN("秋天","秋高气爽"),
    WINTER("冬天","白雪皑皑");

    //对象的实例变量
    private final String seasonName;//季节的名称
    private final String seasonDesc;//季节的描述

    //提供私有的构造器
    private Season1(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

//    @Override
//    public String toString() {
//        return "Season1{" +
//                "seasonName='" + seasonName + '\'' +
//                ", seasonDesc='" + seasonDesc + '\'' +
//                '}';
//    }
}
