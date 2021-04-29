package com.atguigu.java2;

/**
 * abstract关键字的使用：
 *
 * abstract class Account{
 *     double balance;//余额
 *
 *     public abstract void withdraw(double amt);//取钱的操作
 *
 *     public void deposit(double amt){}
 *
 * }
 *
 * class SavingAccount extends Account{}//储蓄账户
 *
 * class CheckingAccount extends Account{} //信用卡账户
 *
 * ...
 *
 *
 *class Customer{
 *     Accoun acct;
 *     public void setAccount(Account acct){
 *         this.acct = acct;
 *     }
 *}
 *
 *
 * 1. abstract:抽象的
 * 2. abstract可以用来修饰：类、方法
 *
 * 3. abstract修饰类：抽象类
 *      > 不能实例化
 *      > 抽象类中可以没有抽象方法；但是抽象方法所属的类一定是抽象类。
 *
 * 4. abstract修饰方法：抽象方法 (此方法仅保留了方法的声明，没有方法具体的实现，即没有方法体)
 *      > 实际开发中，抽象方法就需要被子类重写。
 *      > 子类继承抽象类之后，必须重写所有的抽象方法，方可实例化。
 *        子类继承抽象类之后，如果没有重写父类中的所有的抽象方法，则子类仍为一个抽象类。
 *
 *
 * @author shkstart
 * @create 11:22
 */
public class AbstractTest {
    public static void main(String[] args) {
//        Person p1 = new Person();
//        p1.eat();

        Student s1 = new Student();
        s1.eat();
        s1.walk();
    }

}

abstract class Creature{
    public abstract void breath();//呼吸
}

abstract class Person extends Creature{
    String name;
    int age;

    public abstract void eat();

    public void walk(){
        System.out.println("人：走路");
    }
}

class Student extends Person{
    String major;

    public void eat(){
        System.out.println("学生：吃饭");
    }
    public void walk(){
        System.out.println("学生：走路");
    }

    @Override
    public void breath() {
        System.out.println("学生应该呼吸新鲜空气");
    }
}

abstract class Worker extends Person{

}