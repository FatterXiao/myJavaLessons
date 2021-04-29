package com.atguigu.part8.interface_exers.exer04;

public class Test {
    public static void main(String[] args) {
        Worker w = new Worker();
        Apple a1 = new Apple(5, "青色");
        Apple a2 = new Apple(3, "红色");

        w.pickApple(new CompareBig(), a1, a2);
        w.pickApple(new CompareColor(), a1, a2);
    }
}
