package com.atguigu.java3;

/**
 * 接口的使用
 *
 * 1. 我们使用interface定义接口 （复习：我们使用class定义类）
 * 2. 接口内部可以定义的结构：
 *       jdk7及之前：
 *            全局常量：public static final  。 在实际声明时，此修饰可以省略
 *            抽象方法：public abstract 。 在实际声明时，此修饰可以省略
 *       ********************************************
 *       jdk8新特性：
 *            静态方法（有方法体）、默认方法（有方法体）
 *       jdk9新特性：
 *           私有方法
 *
 *    说明：接口中不存在构造器的！
 *          接口不能实例化
 *
 * 3. 类与接口之间是实现(implements)关系，而且类可以实现多个接口。
 *    格式：class A extends B implements C
 *     A相较于B来讲，称为：子类
 *     A相较于C来讲，称为：实现类
 *
 * 4. 如果实现类实现了接口中的所有的抽象方法，则此实现类方可实例化
 *    如果实现类没有实现接口中的所有的抽象方法，则此实现类仍是一个抽象类
 *
 * 5. 接口与接口之间是继承关系，而且可以多继承。
 *
 * @author shkstart
 * @create 16:17
 */
public class InterfaceTest {
    public static void main(String[] args) {
        System.out.println(Flyable.MIN_SPEED);
        System.out.println(Flyable.MAX_SPEED);

//        Flyable.MAX_SPEED = 7800;
    }
}

interface Flyable{
    // 属性
    public static final int MIN_SPEED = 1;
    int MAX_SPEED = 7900;

    //方法
//    public abstract void fly();
    void fly();
}

interface Attackable{

    void attack();

}

class Plane implements Flyable{

    @Override
    public void fly() {
        System.out.println("飞机可以飞~");
    }
}

abstract class Bullet implements Flyable,Attackable{

}

//**************************
interface AA{
    void method1();
}

interface BB{
    void method2();
}
interface CC extends AA,BB{

}

class DD implements CC{
    public void method1(){

    }
    public void method2(){

    }
}


