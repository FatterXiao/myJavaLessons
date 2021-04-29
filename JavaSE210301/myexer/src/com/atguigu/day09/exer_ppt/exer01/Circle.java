package com.atguigu.day09.exer_ppt.exer01;

public class Circle {
    double raduis ;

    public Circle(){

    }

    public Circle(double raduis){
        this.raduis = raduis;
    }

    public double getArea(){
        return  raduis * raduis * Math.PI;
    }

}
