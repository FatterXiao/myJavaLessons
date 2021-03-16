package com.atguigu.part7.inherit.exer01;

public class Child extends People {
    People father;

    public Child(String name) {
        System.out.print("3");
        father = new People(name + " F");
    }

    public Child() {
        System.out.print("4");
    }
}
