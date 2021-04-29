package com.atguigu.day15.part08ppt;

import java.math.BigDecimal;

public class ComparableCircle extends Circle implements CompareObject {
    private  Circle circle;

    public ComparableCircle() {
        circle = getInstance();
    }

    @Override
    public int compareTo(Object o) {
        if(!(o instanceof  Circle)){
            return -1;
        }
        Circle temp = (Circle)o;
        double res = circle.getRadius() - temp.getRadius() ;
        if(circle.getRadius() - temp.getRadius() < 0.0000001){
            return 0;
        }
        if(circle.getRadius() - temp.getRadius() > 0){
            return 1;
        }
        return -1;

    }
}
