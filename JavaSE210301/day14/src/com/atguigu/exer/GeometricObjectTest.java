package com.atguigu.exer;

/**
 * 定义一个测试类GeometricObjectTest，
 * 编写equalsArea方法测试两个对象的面积是否相等（注意方法的参数类型，利用动态绑定技术），
 * 编写displayGeometricObject方法显示对象的面积（注意方法的参数类型，利用动态绑定技术）。
 *
 * @author shkstart
 * @create 12:00
 */
public class GeometricObjectTest {
    public static void main(String[] args) {
        GeometricObjectTest test = new GeometricObjectTest();

        Circle circle = new Circle(2.3, "red", 1.0);
        test.displayGeometricObject(circle);

        MyRectangle myRectangle = new MyRectangle(3.4, 2.3, "blue", 2.0);
        test.displayGeometricObject(myRectangle);

        test.equalsArea(circle,myRectangle);
    }

    public void equalsArea(GeometricObject o1,GeometricObject o2){
        boolean isEqual = o1.findArea() == o2.findArea();
        if(isEqual){
            System.out.println("面积相等");
        }else{
            System.out.println("面积不相等");
        }
    }

    public void displayGeometricObject(GeometricObject o ){
        System.out.println("几何图形的面积为：" + o.findArea());
    }
}
