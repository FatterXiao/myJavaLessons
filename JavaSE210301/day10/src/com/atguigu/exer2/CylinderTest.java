package com.atguigu.exer2;

/**
 * 在CylinderTest类中创建Cylinder类的对象，设置圆柱的底面半径和高，并输出圆柱的体积
 *
 * @author shkstart
 * @create 15:37
 */
public class CylinderTest {
    public static void main(String[] args) {
        Cylinder cy = new Cylinder();

//        cy.setRadius(3.4);
//        cy.setLength(1.2);

        System.out.println("圆柱的体积为：" + cy.findVolume());
        System.out.println("圆柱的底面积为：" + cy.findArea());
    }
}
