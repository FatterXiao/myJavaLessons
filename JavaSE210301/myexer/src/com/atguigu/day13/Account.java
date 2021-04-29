package com.atguigu.day13;

public class Account {
    private  int accountID;
    private String password;
    private double balance;
    private static int count = 1001;

    public static double rate = 0.045;
    /**
     * 最小开卡金额
     */
    public static double limitMoney = 100;

    public Account(){
        this.balance = 20000;
        accountID = count++;
    }

    public Account(String password) {
        this();
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccountID() {
        return accountID;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
