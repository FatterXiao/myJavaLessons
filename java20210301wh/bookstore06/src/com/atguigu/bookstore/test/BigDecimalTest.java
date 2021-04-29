package com.atguigu.bookstore.test;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalTest {

    /*
       测试通过BigDecimal解决double计算精度问题
    */
    @Test
    public void testBigDecimal(){
        BigDecimal a = new BigDecimal(10);
        BigDecimal b = new BigDecimal(5);
        //加
        BigDecimal add = a.add(b);
        System.out.println(add);
        //减
        BigDecimal subtract = a.subtract(b);
        System.out.println(subtract);
        //乘
        BigDecimal multiply = a.multiply(b);
        System.out.println(multiply);
        //除
        BigDecimal divide = a.divide(b);
        System.out.println(divide);
        //处理double类型计算精度问题，使用的是BigDecimal的String类型的构造器
        BigDecimal bigDecimal = new BigDecimal(0.01);
        BigDecimal bigDecimal1 = new BigDecimal(0.09);
        //加
        BigDecimal add1 = bigDecimal.add(bigDecimal1);
        System.out.println(add1);
        BigDecimal str1 = new BigDecimal("0.01");
        BigDecimal str2 = new BigDecimal("0.09");
        //加
        BigDecimal add2 = str1.add(str2);
        //转换为doule类型的值
        double doubleValue = add2.doubleValue();
        System.out.println(doubleValue);
    }
}
