package com.atguigu.java1;

/**
 * 多态的使用的好处
 *
 * 应用一：如下
 *
 * 应用二：
 *   public boolean equals(Object obj){}
 *
 * 应用三：
 * class Account{
 *
 * }
 *
 * class CheckingAccount extends Account{}//信用卡账户
 *
 * class SavingAccount extends Account{}//储蓄卡账户
 * ...
 *
 * class Customer{
 *
 *     Account acct;
 *
 *     public void setAccount(Account acct){
 *         this.acct = acct;
 *     }
 *
 * }
 *
 * @author shkstart
 * @create 10:35
 */
public class AnimalTest {

    public static void main(String[] args) {
        AnimalTest test = new AnimalTest();
        Dog dog = new Dog();
        test.func(dog);

        test.func(new Cat());
    }

    public void func(Animal animal){ // Animal animal = new Dog();
        animal.eat();
        animal.jump();

        //编译不通过
//        animal.shout();

        if(animal instanceof Dog){
            Dog dog = (Dog)animal;
            dog.shout();
        }else if(animal instanceof Cat){
            Cat cat = (Cat)animal;
            cat.catchFish();
        }
    }

//    public void func(Dog dog){
//        dog.eat();
//        dog.jump();
//    }
//
//    public void func(Cat cat){
//        cat.eat();
//        cat.jump();
//    }
//
//    //....

}

class Animal{

    public void eat(){
        System.out.println("动物进食");
    }

    public void jump(){
        System.out.println("动物跳");
    }

}

class Dog extends Animal{
    public void eat(){
        System.out.println("狗吃骨头");
    }

    public void jump(){
        System.out.println("狗急跳墙");
    }

    public void shout(){
        System.out.println("狗吠");
    }
}
class Cat extends Animal{
    public void eat(){
        System.out.println("猫吃老鼠");
    }

    public void jump(){
        System.out.println("猫跳");
    }
    public void catchFish(){
        System.out.println("猫抓鱼");
    }
}

