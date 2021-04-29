package com.atguigu.exer;

/**
 * 定义一个ComparableCircle类，继承Circle类并且实现CompareObject接口。
 * 在ComparableCircle类中给出接口中方法compareTo的实现体，用来比较两个圆的半径大小。
 *
 * @author shkstart
 * @create 11:39
 */
public class ComparableCircle extends Circle implements CompareObject{

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle() {
    }

    @Override
    public int compareTo(Object o) throws Exception{
        if(this == o){
            return 0;
        }
        if(o instanceof ComparableCircle){
            ComparableCircle c = (ComparableCircle)o;

//            return (this.getRadius() > c.getRadius())? 1 : ((this.getRadius() == c.getRadius())? 0 : -1);

            return Double.compare(this.getRadius(),c.getRadius());
        }

//        throw new RuntimeException("输入的类型不匹配");
        throw new Exception("输入的类型不匹配");
    }
}
