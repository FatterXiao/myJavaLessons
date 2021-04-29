package com.atguigu.part6.attribution.exer02;

/*
    声明公民类Citizen，包含属性：姓名，生日，身份证号，
    其中姓名是String类型，生日是MyDate类型，身份证号也是String类型。

​	声明Test03测试类，在main方法中创建你们家庭成员的几个对象，并打印信息。
 */
public class CitizenTest {
    public static void main(String[] args) {
        MyDate babaDate = new MyDate(1967,5,2);
        Citizen citizenBaBa = new Citizen("小头爸爸",babaDate,"1111111");
        citizenBaBa.showDetail();

        MyDate mamaDate = new MyDate(1970,6,1);
        Citizen citizenMaMa = new Citizen("围裙妈妈",mamaDate,"2222222");
        citizenMaMa.showDetail();

        MyDate selfData = new MyDate(1995,6,12);
        Citizen citizenSelf = new Citizen("大头儿子",selfData,"3333333");
        citizenSelf.showDetail();

    }
}
