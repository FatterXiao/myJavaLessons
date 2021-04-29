package com.atguigu.day17.exer;

import java.util.Arrays;
import java.util.Comparator;

public class CompareableTest {
    public static void main(String[] args) {
        Goods g1 = new Goods("A0",20);
        Goods g2 = new Goods("A1",30);
        Goods g3 = new Goods("AB",20);
        Goods g4 = new Goods("A",22);
        Goods g5 = new Goods("A",26.2);
        Goods g6 = new Goods("A",23);
        Goods g7 = new Goods("A",27);
        Goods g8 = new Goods("B",28);

        Goods[] goods = new Goods[]{g1,g2,g3,g4,g5,g6,g7,g8};
        System.out.println(Arrays.toString(goods));
        System.out.println();
        Arrays.sort(goods);// 按照价格排序

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {


                return 0;
            }
        };
        System.out.println(Arrays.toString(goods));

    }
}
