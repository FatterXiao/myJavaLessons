package com.atguigu.java;

/**
 * 1.概念：
 * 形参：方法声明时，小括号内的参数
 * 实参：方法调用时，实际传递给形参变量的值
 *
 *
 * 2. 方法形参的传递机制：值传递！
 *  如果形参是基本数据类型的变量，则将实参基本数据类型变量存储的变量值赋值给形参。
 *  如果形参是引用数据类型的变量，则将实参引用数据类型变量存储的null值或者对象的首地址值赋值给形参。
 *
 * @author shkstart
 * @create 10:11
 */
public class ValueTransferTest1 {
    public static void main(String[] args) {

        int m = 10;
        int n = 5;
        System.out.println("m = " + m +", n = " + n);
        //交换两个变量的值
        //方式一：成功交换了
//        int temp = m;
//        m = n;
//        n = temp;
        //方式二：失败！没有实现交换
        ValueTransferTest1 test = new ValueTransferTest1();
        test.swap(m,n);


        System.out.println("m = " + m +", n = " + n);

    }

    public void swap(int m ,int n){
        int temp = m;
        m = n;
        n = temp;
    }
}
