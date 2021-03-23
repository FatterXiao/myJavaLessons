package com.atguigu.day14.part08ppt;

public class SalariedEmployee extends Employee {
    private double monthlySalary;

    public SalariedEmployee(String name, String number, MyDate birthday) {
        super(name, number, birthday);
    }

    @Override
    public double earnings() {
        return  monthlySalary;
    }

    @Override
    public String toString() {
        return "SalariedEmployee{" +
                "name=" + super.getName() +
                ",number=" + super.getNumber() +
                ",birthday=" + super.getBirthday() +
                '}';
    }
}
