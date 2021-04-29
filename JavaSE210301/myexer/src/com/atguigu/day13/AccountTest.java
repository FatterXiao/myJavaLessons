package com.atguigu.day13;

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account("1234");
        Account account1 = new Account("2234");
        Account account2 = new Account("3234");

        System.out.println(account.toString());
        System.out.println(account1.toString());
        System.out.println(account2.toString());
    }
}
