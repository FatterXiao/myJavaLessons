package com.atguigu.part8.interface_exers.exer04;

public class Apple {
    private double size;// 大小
    private String color;// 颜色

    public Apple(double size, String color) {
        super();
        this.size = size;
        this.color = color;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}
