package com.atguigu.exer2;


/**
 *
 * 参照SalariedEmployee类定义HourlyEmployee类，实现按小时计算工资的员工处理。该类包括：
 * private成员变量wage和hour；
 * 实现父类的抽象方法earnings(),该方法返回wage*hour值；
 * toString()方法输出员工类型信息及员工的name，number,birthday。
 *
 *
 * @author dj
 * @create 2021-03-16 20:14
 */
public class HourlyEmployee extends Employee {
    private double wage;//单位小时的工资
    private int hour;//月工作小时数

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, String number, MyDate birthday, double wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    /**
     * 返回员工的月工资
     * @return
     */
    @Override
    public double earnings() {
        return wage * hour;
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String toString(){
        return "HourlyEmployee" + super.toString();
    }
}
