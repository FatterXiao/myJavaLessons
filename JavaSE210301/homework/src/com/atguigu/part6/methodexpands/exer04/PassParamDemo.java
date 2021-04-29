package com.atguigu.part6.methodexpands.exer04;

import org.junit.Test;

public class PassParamDemo {
    public void doubleNumber(int x) {
        x *= 2;
    }

    public void toUpperCase(char letter) {
        letter = (char) (letter - 32);
    }

    public void expandCircle(Circle c, double times) {
        c.radius *= times;
    }

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // ========================= test  ========================
    @Test
    public void test() {
        PassParamDemo p = new PassParamDemo();

        int x = 1;
        p.doubleNumber(x);
        System.out.println("x = " + x);

        char letter = 'a';
        p.toUpperCase(letter);
        System.out.println(letter);

        Circle c = new Circle();
        c.radius = 1.0;

        p.expandCircle(c, 5);
        System.out.println("半径：" + c.radius);

        int[] arr = {3, 4, 2, 7, 1};
        p.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}

