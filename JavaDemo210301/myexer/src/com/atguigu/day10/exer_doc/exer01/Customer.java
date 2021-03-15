package com.atguigu.day10.exer_doc.exer01;

public class Customer {
    private String firstName;
    private String lastName;
    private Account account;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * 打印客户信息
     */
    public void Info() {
        System.out.println("Customer [" + firstName + "," + lastName + "] has a account: id is "
                + account.getId() + ",annualInterestRate is " + account.getAnnualInterestRate()*100 + "%, balance is " +
                 account.getBalance());
    }
}
