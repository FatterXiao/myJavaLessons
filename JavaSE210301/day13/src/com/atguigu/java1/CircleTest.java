package com.atguigu.java1;

/**
 * static的应用举例
 *
 * @author shkstart
 * @create 14:40
 */
public class CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(1.3);
        Circle c2 = new Circle(2.3);

        System.out.println(c1);
        System.out.println(c2);

//        System.out.println(c1.total);
//        System.out.println(c2.total);
        System.out.println("创建的对象的个数为：" + Circle.getTotal());

        Circle c3 = new Circle();
        System.out.println(c3);
        System.out.println("创建的对象的个数为：" + Circle.getTotal());
    }
}

class Circle{
    private double radius;
    private int id; //自动累加赋值

    private static int init = 1001;

    private static int total;

    public Circle(double radius){
        this();
        this.radius = radius;
//        this.id = init++;
//        total++;
    }

    public Circle(){
        this.id = init++;
        total++;

    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                ", id=" + id +
                '}';
    }

    public int getId() {
        return id;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static int getTotal() {
        return total;
    }
}
