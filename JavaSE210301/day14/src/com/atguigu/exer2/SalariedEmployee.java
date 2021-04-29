package com.atguigu.exer2;


/**
 * 定义SalariedEmployee类继承Employee类，实现按月计算工资的员工处理。
 * 该类包括：private成员变量monthlySalary；
 * 实现父类的抽象方法earnings(),该方法返回monthlySalary值；
 * toString()方法输出员工类型信息及员工的name，number,birthday。
 *
 * 月结工资
 * @author dj
 * @create 2021-03-16 20:00
 */
public class SalariedEmployee extends Employee {

    private double monthlySalary;//月工资

    public SalariedEmployee() {
    }

    public SalariedEmployee(String name, String number, double monthlySalary) {
        super(name, number);
        this.monthlySalary = monthlySalary;
    }

    public SalariedEmployee(String name, String number, MyDate birthday, double monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    /**
     * 返回员工工资，月结
     * @return
     */
    @Override
    public double earnings() {
        return monthlySalary;
    }

    public String toString(){
        return "SalariedEmployee" + super.toString() ;
    }
}
