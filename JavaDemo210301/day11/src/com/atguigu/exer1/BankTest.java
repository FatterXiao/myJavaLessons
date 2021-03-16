package com.atguigu.exer1;

/**
 * @author shkstart
 * @create 10:33
 */
public class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        bank.addCustomer("康","孙");
        bank.addCustomer("智","吕");

        System.out.println("银行客户个数为：" + bank.getNumOfCustomers());

        Customer customer = bank.getCustomer(1);
        if(customer == null){
            System.out.println("未找到指定的客户");
        }else{
            customer.setAccount(new Account(2000));
            System.out.println("给客户添加账户成功");
        }

        bank.getCustomer(1).getAccount().withdraw(500);
    }
}






