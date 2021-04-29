package com.atguigu.part8.abstract_exers.exer01;

public class C extends B {
    int numc = 30;
    @Override
    void showB() {
        System.out.println(super.numb);
    }

    @Override
    void showA() {
        System.out.println(super.numa);
    }

    public void showC(){
        System.out.println(numc);
    }
}
