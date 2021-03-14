package com.atguigu.exer;

/**
 * 声明一个日期类型MyDate：有属性：年year,月month，日day。
 *
 * 创建2个日期对象，分别赋值为：你的出生日期，你对象的出生日期，并显示信息。
 *
 *
 * 小结：
 *  基本数据类型的变量就根据其类型存储相应的值。比如：int i = 5; char c = 'a'
 *  引用数据类型的变量存储的值就两种情况：① null ② 对象或数组实体在堆空间中存储位置的首地址值。
 *
 * @author shkstart
 * @create 9:25
 */
public class MyDateTest { //测试MyDate类
    public static void main(String[] args) {
        MyDate myDate1 = new MyDate();

        myDate1.year = 2021;
        myDate1.month = 3;
        myDate1.day = 8;

        System.out.println(myDate1.getInfo());

        MyDate myDate2 = myDate1;//不能称为重新创建了一个对象！

        MyDate myDate3 = new MyDate();

        myDate3.year = 2021;
        myDate3.month = 11;
        myDate3.day = 11;

        System.out.println(myDate3.getInfo());

        //创建多个MyDate类对象构成的数组
        MyDate[] arr = new MyDate[5];
        System.out.println(arr);//[Lcom.atguigu.exer.MyDate;@1540e19d

        for(int i = 0;i < arr.length;i++){
            arr[i] = new MyDate();
            //System.out.println(arr[i]);//com.atguigu.exer.MyDate@各个地址值
            //正确的写法
//            System.out.println(arr[i].getInfo());
            //正确的写法
            arr[i].show();
            //正确的写法
            System.out.println(arr[i].show1());
            //错误的写法
//            System.out.println(arr[i].show());
        }
    }
}

class MyDate{

    int year;
    int month;
    int day;

    public String getInfo(){
        return "对象的信息为：year = " + year + ",month = " + month + ",day = " + day;
    }

    public void show(){
        System.out.println("对象的信息为：year = " + year + ",month = " + month + ",day = " + day);
    }

    public String show1(){
        System.out.println("对象的信息为：year = " + year + ",month = " + month + ",day = " + day);
        return null;
    }
}


