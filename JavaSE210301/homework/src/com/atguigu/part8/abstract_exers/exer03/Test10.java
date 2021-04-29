package com.atguigu.part8.abstract_exers.exer03;

public class Test10 {
    public static void main(String[] args) {
        Person[] all = new Person[3];
        all[0] = new Chinese();
        all[1] = new American();
        all[2] = new Indian();

        for (int i = 0; i < all.length; i++) {
            all[i].eat();
        }
    }
}
