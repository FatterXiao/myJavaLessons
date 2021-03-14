package com.atguigu.java1;

/**
 * 面向对象的特征一：封装与隐藏性
 *
 * 1. 封装性的理解：把该隐藏的隐藏起来，该暴露的暴露出来。这就是封装性的设计思想。
 *   比如：私有化(private)类的属性，不让在类的外部随意调用。并且提供公共的(public)方法对此属性进行访问。
 *       我们可以在方法内编写对属性赋值等操作的限制。
 * 2. 对属性通过方法的访问，我们可以体现为：获取、设置。
 *
 * 3. 对封装性的理解：
 *    一方面，我们在设计功能时，将不同的功能封装进不同的方法，将方法声明在相关的类中。
 *    另一方面，Java提供了几种权限修饰符用于修饰类及类的内部成员。体现这些结构在被调用时的可见性的大小。
 *
 * 4. 封装性的体现：
 *    举例1：私有化(private)类的属性，提供公共的(public)方法进行获取、设置。
 *    举例2：设计类时，如果有的方法不需要对外暴露，只在内部使用，则可以声明为private的
 *    举例3：单例模式（后面讲）
 *
 * 5. Java规范的几种权限修饰：从小到大的顺序为：
 *    private  < 缺省 < protected < public
 *
 *    可以使用如上的4种权限修饰来修饰类的内部成员；
 *    针对于类来讲，只能使用public、缺省的权限进行修饰。
 *
 *
 * @author shkstart
 * @create 11:50
 */
public class AnimalTest {
    public static void main(String[] args) {
        Animal ani1 = new Animal();
        ani1.eat();
        ani1.sleep();

        ani1.name = "熊大";
//        ani1.legs = -1223; //针对于实际问题来讲，不合法！
        System.out.println(ani1.name);

        ani1.setLegs(-1223);
//        ani1.legs = -12;  //当legs声明为private之后，不可以在AnimalTest类中调用。

        System.out.println(ani1.getLegs());//0

        //非法
//        ani1.getLegs() = -12;

        int legs = ani1.getLegs();
        legs = -12;

        System.out.println(ani1.getLegs());


    }
}

class Animal{//动物类

    String name;
    private int legs;//腿的个数  当使用private修饰以后，表示只能在此类内部使用



    public void eat(){
        System.out.println("动物进食");
    }

    public void sleep(){
        System.out.println("动物睡觉");
    }

    //针对legs属性的设置
    public void setLegs(int leg){
        if(leg < 0 || leg % 2 != 0){
            System.out.println("输入的数据非法！");
        }else{
            legs = leg;
        }
    }
    //针对legs属性的获取
    public int getLegs(){
        return legs;
    }

    private int age;
    //set方法
    public void setAge(int a){
        age = a;
    }
    //get方法
    public int getAge(){
        return age;
    }
    //不要将get()和set()合并!
//    public int doAge(int a){
//        age = a;
//        return age;
//    }
}
