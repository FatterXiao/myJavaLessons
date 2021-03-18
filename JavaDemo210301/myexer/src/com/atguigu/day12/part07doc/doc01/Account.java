package com.atguigu.day12.part07doc.doc01;

import org.junit.Test;

public class Account {

    private int id; // 用户id
    private double balance; // 余额
    private double annuallnterestRate; // 年利率

    public Account() {

    }

    public Account(int id, double balance, double annuallnterestRate) {
        this.id = id;
        this.balance = balance;
        this.annuallnterestRate = annuallnterestRate;
    }

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

    public double getAnnuallnterestRate() {
        return annuallnterestRate;
    }

    public void setAnnuallnterestRate(double annuallnterestRate) {
        this.annuallnterestRate = annuallnterestRate;
    }

    /**
     * 返回月利率
     *
     * @return
     */
    public double getMonthlyInterest() {
        return 0.0;
    }

    /**
     * 取款
     *
     * @param amount
     */
    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("余额不足，无法完成取款。");
            return;
        }
        balance -= amount;
    }

    /**
     * 存款
     *
     * @param amount
     */
    public void deposit(double amount) {
        balance += amount;
    }



}
