package com.atguigu.part8.interface_exers.exer02;

public class Test {
    public static void main(String[] args) {
        Star star = new Star();
        star.shine();

        System.out.println("======================");
        Universe universe = new Sun();
        universe.doAnything();
        if(universe instanceof Sun){
            Sun sun = (Sun)universe;
            sun.shine();
        }
    }
}
