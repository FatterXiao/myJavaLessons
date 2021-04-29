package com.atguigu.exer;

/**
 *
 * 编写一个类实现银行账户的概念，包含的属性有“帐号”、“密码”、“存款余额”、“利率”、“最小余额”，定义封装这些属性的方法。账号要自动生成。
 * 编写主类，使用银行账户类，输入、输出3个储户的上述信息。
 * 考虑：哪些属性可以设计成static属性。
 *
 * @author shkstart
 * @create 15:34
 */
public class AccountTest {
    public static void main(String[] args) {
        Account acct1 = new Account();
        Account acct2 = new Account("qwerty",2000);

        System.out.println(acct1);
        System.out.println(acct2);

        System.out.println(Account.getMinbalance());
        System.out.println(Account.getInterestRate());
    }
}

class Account{
    private int id;
    private String password = "000000";
    private double balance;//余额
    private static double interestRate = 0.01;//利率
    private static double minbalance = 1;//最小余额

    private static int init = 1001;//用于自动声明id的

    public Account() {
        this.id = init++;
    }

    public Account(String password, double balance) {
        this();
        this.password = password;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public static double getMinbalance() {
        return minbalance;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public static double getInterestRate() {
        return interestRate;
    }

    public static void setInterestRate(double interestRate) {
        Account.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
