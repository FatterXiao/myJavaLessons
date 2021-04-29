package com.atguigu.java;

/**
 * @author shkstart
 * @create 9:29
 */
class Customer{
    public Customer(Account acct, int age) {
        this.acct = acct;
        this.age = age;
    }

    public Customer() {
    }

    Account acct;
    int age;


}

class Account{
    double balance;

    public Account(double balance) {
        this.balance = balance;
    }

    public Account() {
    }
}

public class CopyTest {
    public static void main(String[] args) {
        //引用复制
        Customer c1 = new Customer();
        Customer c2 = c1;


        //对象复制之浅拷贝
        Account acct1 = new Account(2000);
        Customer c3 = new Customer(acct1,20);
        Customer c4 = new Customer(acct1,20);

        //对象复制之深拷贝
        Account acct2 = new Account(2000);
        Customer c5 = new Customer(acct2,20);

    }
}

