package com.atguigu.day15.inner_class_exers;

public class InnerClassTest {
    public static void main(String[] args) {
        Person.Dog dog = new Person.Dog();
        Person person = new Person();
        Person.Bird bird = person.new Bird();
    }


}

class Person {
    String name = "Tom";

    // 静态内部类
    public static class Dog{
        public void shout(){
            System.out.println("汪~汪~汪~");
        }
    }

    // 非静态内部类
    public class Bird{
        String name = "布谷鸟";

        public void shout(){
            System.out.println("喳~喳~喳~");
            Person.this.eat();
        }
    }

    public void eat(){
        int num = 1;
        System.out.println("人吃饭");

    }

}
