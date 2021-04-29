package com.atguigu.exer1;

/**
 * @author shkstart
 * @create 15:23
 */
public class Manager extends Employee {

    private double bonus;//奖金

    public Manager() {
    }

    public Manager(double bonus) {
        this.bonus = bonus;
    }

    public Manager(String name, int id, double salary, double bonus) {
        super(name, id, salary);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("管理者监督员工的工作");
    }
}
