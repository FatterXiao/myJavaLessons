package com.atguigu.day14.part08ppt;

public class HourlyEmployee extends Employee {
    private  int wage;
    private  int hour;

    public HourlyEmployee(String name, String number, MyDate birthday) {
        super(name, number, birthday);
    }

    @Override
    public double earnings() {
        return wage * hour;
    }

    @Override
    public String toString() {
        return "HourlyEmployee{" +
                "name=" + super.getName() +
                ", number=" + super.getNumber() +
                ", birthday=" + super.getBirthday() +
                '}';
    }
}
