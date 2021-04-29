package com.atguigu.day10.exer_doc.exer02;

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
     * 打印用户信息
     */
    public void Info(){
        System.out.println("用户姓名：" + this.firstName + " " + this.lastName);
        if (this.account != null) {
             System.out.println("余额：" + this.account.getBalance());
        }
    }
}
