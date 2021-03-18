package com.atguigu.day12.part07doc.doc01;

public class Test {
    public static void main(String[] args) {
//        Account account = new Account(1122,20000,0.045);
//        System.out.println("当前余额:" + account.getBalance());
//
//        account.withdraw(25000);
//        account.deposit(300);
//        System.out.println("当前余额:" + account.getBalance());

        CheckAccount checkAccount = new CheckAccount(1122,20000,0.045,5000);

        checkAccount.withdraw(5000);
        System.out.println(checkAccount.toString());
        checkAccount.withdraw(18000);
        System.out.println(checkAccount.toString());
        checkAccount.withdraw(3000);
        System.out.println(checkAccount.toString());

    }
}
