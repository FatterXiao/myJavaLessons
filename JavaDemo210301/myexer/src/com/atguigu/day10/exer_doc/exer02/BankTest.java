package com.atguigu.day10.exer_doc.exer02;

public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addCustomer("Xiao","Ming");
        bank.addCustomer("Xiao","Hong");
        bank.addCustomer("Xiao","Pang");
        bank.addCustomer("Xiao","Shou");

        bank.printCustomers();
        System.out.println("用户总数：" + bank.getNumOfCustomers());

        int index = 2;
        Customer temp = bank.getCustomer(index);
        System.out.print("index = " + index + "时, " );
        temp.Info();

    }
}
