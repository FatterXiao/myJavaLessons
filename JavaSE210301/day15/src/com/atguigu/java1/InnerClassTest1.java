package com.atguigu.java1;

/**
 *
 * 关于局部内部类的常见使用的掌握
 *
 * @author shkstart
 * @create 11:09
 */
public class InnerClassTest1 {

    //局部内部类的如下场景少见
    public void method(){
        //内部类
        class InnerClass{

        }

        //使用内部类
    }

    public Comparable getInstance(){
        //内部提供一个接口的实现类
//        class MyComparable implements Comparable{
//
//            @Override
//            public int compareTo(Object o) {
//                return 0;
//            }
//        }
//
//        return new MyComparable();

        //上述代码可以修改为：创建接口的匿名实现类的匿名对象
        return new Comparable(){

            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}
