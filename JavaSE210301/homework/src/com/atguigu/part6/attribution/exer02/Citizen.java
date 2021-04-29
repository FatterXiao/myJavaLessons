package com.atguigu.part6.attribution.exer02;

/*
    包含属性：姓名，生日，身份证号，其中姓名是String类型，生日是MyDate类型，身份证号也是String类型。
 */
public class Citizen {
    String name;
    MyDate birthday;
    String idNumber;

    public Citizen(){}

    public Citizen(String name, MyDate birthday, String idNumber) {
        this.name = name;
        this.birthday = birthday;
        this.idNumber = idNumber;
    }

    public void showDetail(){
        StringBuilder sb = new StringBuilder();
        sb.append("name: " + name +";\n");
        sb.append("birthday: " + birthday.year + "/" + birthday.month + "/" + birthday.day + ";\n");
        sb.append("idNumber: " + idNumber + ";\n");

        System.out.println(sb.toString());
    }
}
