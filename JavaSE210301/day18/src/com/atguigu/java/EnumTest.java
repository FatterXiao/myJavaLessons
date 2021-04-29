package com.atguigu.java;

/**
 * 一、枚举类的使用
 * 1. 枚举类的理解
 * 2. 自定义类的方式，体现枚举类
 * 3. jdk5.0:使用enum关键字定义
 * 4. enum定义的方式中，常用的方法
 *      toString():没有重写的情况下，默认返回当前枚举类对象的名字
 *      values():返回当前枚举类所有的对象构成的数组
 *      valueOf(String name):返回指定名称的枚举类的对象
 * 5. 枚举类的对象实现接口的操作
 *
 *
 * @author shkstart
 * @create 9:19
 */
public class EnumTest {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer.getClass().getSuperclass());

        System.out.println(summer);
        System.out.println("##############");
        Season1[] season1s = Season1.values();
        for (int i = 0; i < season1s.length; i++) {
            System.out.println(season1s[i]);

            season1s[i].show();
        }

        System.out.println("##############");
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);
        //如果枚举类中不存在指定名称的枚举类的对象的话，报IllegalArgumentException
//        winter = Season1.valueOf("WINTER1");

//        summer.show();
    }
}

//enum Season1{//季节
//    //内部提供4个枚举类的对象
//    SPRING,
//    SUMMER,
//    AUTUMN,
//    WINTER;
//
//    //提供私有的构造器
//    private Season1(){
//
//    }
//
//}
interface Info{
    void show();
}

enum Season1 implements Info{//季节
    //内部提供4个枚举类的对象
    SPRING("春天","春暖花开"){
        public void show(){
            System.out.println("春天在哪里？");
        }
    },
    SUMMER("夏天","夏日炎炎"){
        public void show(){
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        public void show(){
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","白雪皑皑"){
        public void show(){
            System.out.println("大约在冬季");
        }
    };

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
//    public void show() {
//        System.out.println("这是一个季节");
//    }

}