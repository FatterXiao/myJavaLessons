package com.atguigu.exer;

/**
 * 定义一个测试类InterfaceTest，创建两个ComparableCircle对象，调用compareTo方法比较两个类的半径大小。
 *
 * @author shkstart
 * @create 11:46
 */
public class InterfaceTest {
    public static void main(String[] args) {
        CompareObject c1 = new ComparableCircle(2.3);
        CompareObject c2 = new ComparableCircle(2.4);

        try {
            System.out.println(c1.compareTo(c2));
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            System.out.println(c1.compareTo(new String("hello")));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
