package com.atguigu.java;

import org.junit.Test;

/**
 *
 * 1. 为什么要引入包装类？为了使得基本数据类型的变量具备类的特征
 *
 * 2. 掌握：8种基本数据类型与其对应的包装类
 *
 * 3. 掌握：基本数据类型、包装类、String三者之间的转换
 *
 *
 *
 * @author shkstart
 * @create 16:58
 */
public class WrapperTest {

    //1. 基本数据类型 ---> 包装类：调用包装类的构造器 ① Xxx(xxx x)  ② Xxx(String x)
    @Test
    public void test1(){
        int num = 10;

        Integer int1 = new Integer(num);
        System.out.println(int1.toString());

        float f1 = 12.3F;
        Float f2 = new Float(f1);
        System.out.println(f2.toString());

        String s1 = "123";
//        s1 = "123a"; //会报NumberFormatException数字类型转换的异常
        Integer int2 = new Integer(s1);
        System.out.println(int2.toString());

        boolean b1 = true;
        Boolean b2 = new Boolean(b1);
        System.out.println(b2.toString());

        String s2 = "true";
        s2 = "TruE";//结果为true
        s2 = "true1";// 编译通过，运行结果为：false
        Boolean b3 = new Boolean(s2);
        System.out.println(b3);

    }
    //2. 包装类 ---> 基本数据类型：调用包装类Xxx的xxxValue()
    @Test
    public void test2(){
        Integer int1 = new Integer(10);

        int i = int1.intValue();
        System.out.println(i);

        Boolean b1 = new Boolean(true);
        boolean b2 = b1.booleanValue();


        Double d1 = new Double(12.3);
        double d2 = d1.doubleValue();

    }
    @Test
    public void test3(){
        Account acct1 = new Account();
        System.out.println(acct1.balance1);//0.0
        System.out.println(acct1.balance2);//null

        System.out.println(acct1.isFlag1);//flase
        System.out.println(acct1.isFlag2);//null
    }

    //3. jdk5.0 新特性：自动的装箱、自动的拆箱
    @Test
    public void test4(){
        int num = 10;
        Integer int1 = num;//自动装箱
        System.out.println(int1.toString());
        Integer int2 = 20;//自动装箱

        Boolean b1 = true;//自动装箱

        int num2 = int1;//自动拆箱

        boolean b2 = b1;//自动拆箱

        Integer sum = int1 + int2; //自动拆箱 ---> 自动装箱

    }

    //4. 基本数据类型、包装类 ---> String: ① 与 "" 做连接运算 ② 调用String中重载的valueOf(xxx x)
    @Test
    public void test5(){
        int n1 = 10;
        //方式1：
        String s1 = n1 + "";
        //方式2：
        String s2 = String.valueOf(n1);

        boolean b1 = true;
        String s3 = String.valueOf(b1);

        System.out.println(s2);
        System.out.println(s3);

    }

    //5. String --> 基本数据类型、包装类:调用包装类的parseXxx(String s)
    @Test
    public void test6(){
        String s1 = "123";
        String s2 = s1 + 1; //结果为1231

        int i1 = Integer.parseInt(s1);
        int i2 = i1 + 1;//结果为124

        System.out.println(s2);
        System.out.println(i2);

        String s3 = "true";
        boolean b1 = Boolean.parseBoolean(s3);//结果为true
        s3 = "true1";
        boolean b2 = Boolean.parseBoolean(s3);
        System.out.println(b2);//false

        String s4 = "123a";
        //int i3 = Integer.parseInt(s4);//报NumberFormatException异常
        //System.out.println(i3);

        String s5 = "123.4";
        double d1 = Double.parseDouble(s5);
        System.out.println(d1);//123.4

        //int i4 = Integer.parseInt(s5);//报NumberFormatException异常
        //System.out.println(i4);

        String s6 = "123";
        double d2 = Double.parseDouble(s6);
        System.out.println(d2);


    }


}

class Account{
    double balance1;
    Double balance2;

    boolean isFlag1;
    Boolean isFlag2;
}