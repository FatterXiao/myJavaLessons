package com.atguigu.part8.interface_exers.exer01;

public interface A {
    void showA();
    default void showB(){
        System.out.println("The default method showB of interface A is showign message.");
    }
}
