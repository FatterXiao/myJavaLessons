package com.atguigu.day10.exer_doc.exer01;

public class Test {
    public static void main(String[] args) {
        /*
            - 创建一个Customer ，名字叫 Jane Smith,
            - 他有一个账号为1000，余额为2000元，年利率为 1.23％ 的账户
         */
        // 1. 创建一个Customer ，名字叫 Jane Smith
        Customer customer = new Customer("Jame","Smith");
        Account account = new Account();
        // 2. 他有一个账号为1000，余额为2000元，年利率为 1.23％ 的账户
        account.setId(1000); // 账户id
        account.setBalance(2000);// 余额
        account.setAnnualInterestRate(0.0123);// 年利率
        customer.setAccount(account);

        // 3.存入 100 元，再取出960元。再取出2000元
        // 打印出Jane Smith 的基本信息
        Account tempAccount = customer.getAccount();
        tempAccount.deposit(100);
        tempAccount.withdraw(960);
        tempAccount.withdraw(2000);

        // 4. 打印消费者信息
        customer.Info();

    }
}
