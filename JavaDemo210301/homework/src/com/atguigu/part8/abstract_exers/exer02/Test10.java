package com.atguigu.part8.abstract_exers.exer02;

public class Test10 {
    public static void main(String[] args) {
        Person[] all = new Person[2];
        all[0] = new Woman();
        all[1] = new Man();

        for (int i = 0; i < all.length; i++) {
            all[i].pee();
        }
    }
}
