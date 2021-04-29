package com.atguigu.day10.exer_doc.exer02;

public class Account {
    /**
     * 账户余额
     */
    private double balance;

    /**
     * 初始化账户余额
     * @param balance
     */
    public Account(double balance) {
        this.balance = balance;
    }

    /**
     * 查询账户余额
     * @return
     */
    public double getBalance() {
        return balance;
    }

    /**
     * 存款
     */
    public void deposit(double amount){
         balance += amount;
    }

    /**
     * 取款
     * @param amount
     */
    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("取款金额已经超出账户余额，取款失败。");
            return;
        }

        balance -= amount;
    }

}
