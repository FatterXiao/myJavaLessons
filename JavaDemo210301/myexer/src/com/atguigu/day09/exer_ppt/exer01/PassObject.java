package com.atguigu.day09.exer_ppt.exer01;

public class PassObject {
    public void printAreas(Circle circle,int time){
        System.out.println("Radius\t\tArea");
        for (int i = 1; i <= time ; i++) {
            circle.raduis = i;
            System.out.println(i + "\t\t" + circle.getArea());
        }
    }
}
