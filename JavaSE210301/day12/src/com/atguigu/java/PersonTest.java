package com.atguigu.java;

import java.util.Date;

/**
 * 面向对象的特征之三：多态性
 *
 *  1.多态的理解：一种事物的多种形态
 *
 *  2. 子类对象的多态性：子类的对象赋给父类的引用 （或父类的引用指向子类的对象)
 *
 *  3.在多态的前提下，通过父类的引用调用方法只能是父类中声明的方法；（编译期）
 *    其次，真正运行时，执行的是子类重写父类的方法。（运行期）
 *    总结：编译看左边，运行看右边 （虚方法调用）
 *
 *
 * 4. 多态的使用前提：① 类的继承关系  ② 子类重写父类的方法
 *
 * 5. 类的多态性指的“编译看左边，运行看右边”不适用于属性
 * @author shkstart
 * @create 10:10
 */
public class PersonTest {
    public static void main(String[] args) {

        //我们熟悉的场景：
        Person p1 = new Person();
        p1.eat();

        Man m1 = new Man();
        m1.eat();
        m1.earnMoney();

        int m = 10;
        int n = m;

        //基本数据类型中存在数据类型提升规则
        long l = m;
        System.out.println("##########多态的核心内容：###########");
        //子类对象的多态性：子类的对象赋给父类的引用 （或父类的引用指向子类的对象)
        Person p2 = new Man();
        Person p3 = new Woman();

        //多态的应用：虚方法调用：在多态的前提下，通过父类的引用调用方法只能是父类中声明的方法；（编译期）
        // 其次，真正运行时，执行的是子类重写父类的方法。（运行期）
        p2.eat();
        p2.walk();
//        p2.earnMoney();//编译不通过

        //属性不存在多态性
        System.out.println(p2.id);//1001

        System.out.println("#########多态性的拓展：############");
        Person p4 = new Man();
//        p4.earnMoney();//编译不通过
//        System.out.println(p4.isSmoking);//编译不通过
        //先明确：创建的子类Man的实例，在内存中是存在其特有的属性和方法的。
        //那如何调用？需要使用强转符：()
        Man m2 = (Man)p4;
        System.out.println(m2.isSmoking);
        m2.earnMoney();
        /*
        进行强转时，可能出现ClassCastException异常。
        建议在强转前，判断是否可以是指定的子类的类型。使用instanceof实现
         */
//        Woman w1 = (Woman)p4;
//        w1.goShopping();
        /*
        * 格式： a instanceof A ：判断对象a是否是类A的实例
        * 如果是，则返回true；如果不是，返回false。
        *
        * 推论：如果a instanceof A返回true,则 a instanceof SuperA也返回true。其中SuperA是类A的父类
        *
        * */
        if(p4 instanceof Woman){
            Woman w1 = (Woman)p4;
            w1.goShopping();
        }else{
            System.out.println("不好意思，认错了！");
        }

        if(p4 instanceof Man){
            System.out.println("我是一个男人");
        }

        if(p4 instanceof Person){
            System.out.println("我是一个人");
        }

        if(p4 instanceof Object){
            System.out.println("我是一个Object");
        }



        String s1 = new String("hello");
//        Date d1 = (String)s1;//编译不通过
    }
}
