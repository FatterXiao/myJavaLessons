package com.atguigu.exer;

/**
 *
 * 3.写一个测试程序。
 * （1）	创建一个Customer ，名字叫 Jane Smith, 他有一个账号为1000，余额为2000元，年利率为 1.23％ 的账户。
 * （2）	对Jane Smith操作。
 * 存入 100 元，再取出960元。再取出2000元。
 * 打印出Jane Smith 的基本信息
 * @author shkstart
 * @create 10:02
 */
public class CustomerTest {
    public static void main(String[] args) {

        Customer cust = new Customer("Jane","Smith");

        Account acct = new Account(1000,2000,0.0123);
        cust.setAccount(acct);

        //合并
//        cust.setAccount(new Account(1000,2000,0.0123));

        //存入 100 元，再取出960元。再取出2000元。
        cust.getAccount().deposit(100);
        cust.getAccount().withdraw(960);
        cust.getAccount().withdraw(2000);

        System.out.println("Customer[" + cust.getFirstName() + "," +cust.getLastName() + "] has a account : id is " +
                cust.getAccount().getId() + ",annualInterestRate is " + cust.getAccount().getAnnualInterestRate()*100 + "%,balance is " +
                cust.getAccount().getBalance());


    }

}
