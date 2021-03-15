package com.atguigu.exer2;

/**
 * @author shkstart
 * @create 15:34
 */
public class Cylinder extends Circle{//圆柱类
    private double length;//高度

    public Cylinder(){
        length = 1;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume(){//返回圆柱的体积
//        return Math.PI * getRadius() * getRadius() * length;
        return findArea() * length;
    }


}
