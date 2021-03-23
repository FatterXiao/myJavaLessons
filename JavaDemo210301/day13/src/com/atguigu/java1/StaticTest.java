package com.atguigu.java1;

/**
 * static关键字的使用
 *
 * 1. static:静态的
 * 2. static可以用来修饰：属性、方法、代码块、内部类。
 *
 * 3. static修饰属性：
 *      > 使用static修饰的属性，被类的多个对象“共享”
 *      > static修饰的属性，在内存中只有一份：存放在静态域中（静态域存放在方法区中）
 *         对比：不使用static修饰的属性，每个对象拥有一份，此属性存放在堆空间的当前对象的内存空间里。
 *      > 静态变量随着类的加载而加载
 *        非静态变量随着对象的创建而加载
 *      >  是否能够调用：（从生命周期的角度解释即可）
 *                  类变量        实例变量
 *         类        yes           no
 *         对象      yes           yes
 *
 * 4. 变量的分类： 4.1 按照数据类型分：基本数据类型  vs 引用数据类型
 *                4.2 按照类中声明的位置：成员变量 (静态变量 vs 非静态变量 ；类变量 vs 实例变量)
 *                                      局部变量(方法内、方法形参、构造器内、构造器形参、..)
 *
 *  思考： 开发中涉及一个类时，是否要将此属性设置为static的呢？
 *         > 我们可以判断是否类的多个对象此属性的值需要是相同的，如果需要相同，则可以考虑共享。
 *         > 开发中的一些常量有时常设计为static的。
 *
 *         比如：Math.PI ， System.out
 *
 * 5. static修饰方法：静态方法
 *       > 随着类的加载而加载
 *       > 方法的调用 （从生命周期的角度解释即可）
 *                      静态方法      非静态方法
 *            类        yes           no
 *            对象      yes           yes
 *       > 非静态的方法内，可以调用当前类的非静态的属性、非静态的方法，也可以调用静态的属性、静态的方法
 *         静态的方法内，可以调用静态的属性、静态的方法，不能调用当前类的非静态的属性、非静态的方法
 *
 *     比如：main() 、 Arrays工具类（Arrays.toString() / equals() / sort(int[] arr)/binarySearch())、
 *          Math的 random() \ sqrt() ; 项目一和项目二中的工具类
 *
 *    思考： 开发中涉及一个类时，是否要将此方法设置为static的呢？
 *          > 后续设计相关的工具类的话，往往将其内部的方法声明为static的
 *          > 操作静态属性的方法，通常都是静态方法
 *
 *
 *
 * @author shkstart
 * @create 11:39
 */
public class StaticTest {
    public static void main(String[] args) {
        Chinese c1 = new Chinese();
        c1.name = "谷爱凌";
        c1.age = 20;
        c1.nation = "CHN";

        Chinese c2 = new Chinese();
        c2.name = "周杰伦";
        c2.age = 40;
        c2.nation = "中国";

        System.out.println(c1);
        System.out.println(c2);

        System.out.println(Chinese.nation);

//        System.out.println(Chinese.name);

        System.out.println(c1.name);
        System.out.println(c1.nation);

        //#############静态方法的使用####################
        c1.show();
        c1.info();

        Chinese.info();
//        Chinese.show();//编译不通过


        //#######################
        StaticTest.test2();
        test2();
    }

    public static void test2(){
        System.out.println("用于测试");
    }
}

class Chinese{
    //实例变量
    String name;
    int age;
    //类变量
    static String nation;//国籍

    @Override
    public String toString() {
        return "Chinese{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                '}';
    }
    //非静态的方法
    public void show(){
        System.out.println("name : " + name +", age : " + age);
        System.out.println("nation : " +nation);

        this.info();
    }

    public static void info(){
        //编译通过：可以调用静态的结构
        System.out.println("我是一个中国人");
        System.out.println("nation : " +nation);
        Chinese.test1();

        //编译不通过：不可以调用非静态的结构
//        System.out.println("name : " + name +", age : " + age);
//        show();

    }

    public static void test1(){
        System.out.println("用于测试");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static String getNation() {
        return nation;
    }

    public static void setNation(String nation) {
        Chinese.nation = nation;
    }
}
