package com.atguigu.exer;

/**
 * @author shkstart
 * @create 11:13
 */
public class Person {

    String name;
    int age = 10;
    /**
     * 表示性别。具体为：
     * 0 : 女性
     * 1 : 男性
     *
     */
    int sex;

    //方法
    public void study(){
        System.out.println("studying");
    }

    public void showAge(){
        //方法内可以调用当前类的属性
        System.out.println("age = " + age);
    }

    /**
     * 给对象增加年龄的方法
     * @param i 要增加的年龄数
     * @return 对象的年龄
     */
    public int addAge(int i){//
        age += i;
        return age;
    }

}
