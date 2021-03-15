package com.atguigu.day10.exer_doc.exer01;

/*
    写一个名为Account的类模拟账户。该类的属性和方法如下图所示。
    该类包括的属性：账号id，余额balance，年利率annualInterestRate；包含的方法：访问器方法（getter和setter方法），
    取款方法withdraw()，存款方法deposit()。

    提示：在提款方法withdraw中，需要判断用户余额是否能够满足提款数额的要求，如果不能，应给出提示。
 */
public class Account {
    /**
     * 账号id
     */
    private int id;
    /**
     * 余额balance
     */
    private double balance;
    /**
     * 年利率annualInterestRate
     */
    private double annualInterestRate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }


    /**
     * 取钱
     * @param amount 取款金额
     */
    public void withdraw(double amount) {
        if(amount > balance){
            System.out.println("无法取款，所剩余额不足。");
            return;
        }

        balance -= amount;
        System.out.println("成功取出：" + amount);
    }


    /**
     * 存钱
     * @param amount
     */
    public void deposit (double amount){
        if(amount < 0){
            System.out.println("存款金额错误：" + amount);
            return;
        }

        balance += amount;
        System.out.println("成功存入： " + amount);
    }
}
