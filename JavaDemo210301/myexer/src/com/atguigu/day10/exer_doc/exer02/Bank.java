package com.atguigu.day10.exer_doc.exer02;


public class Bank {
    private Customer[] customers;
    private  int numberOfCustomers;

    public Bank() {
    }

    /**
     * 添加用户
     */
    public void addCustomer(String firstName,String lastName){
        Customer tempCustomer = new Customer(firstName,lastName);
        if (this.customers == null) {
            customers = new Customer[1];
            customers[0] = tempCustomer;
            numberOfCustomers++;
            return;
        }
        int length = customers.length;
        Customer[] tempArray = new Customer[length+1];
        for (int i = 0; i < length; i++) {
            tempArray[i] = customers[i];
        }

        tempArray[length] = tempCustomer;
        this.customers = tempArray;

        numberOfCustomers++;
    }

    /**
     * 查询用户总数
     * @return
     */
    public int getNumOfCustomers(){
        return numberOfCustomers;
    }

    /**
     * 回与给出的index参数相关的客户
     * @param index
     */
    public Customer getCustomer(int index){
        if(customers == null){
            return null;
        }
        int length = customers.length;
        if(index > length-1){
            System.out.println("当前可查询的用户索引为： 0——" + (length -1));
            System.out.println("索引index= " + index + "已经超出可查询范围。");
            return null;
        }

        return customers[index];
    }

    /**
     * 打印所有用户信息
     */
    public void printCustomers(){
        if(this.customers == null){
            System.out.println("打印错误，用户列表为空。");
            return;
        }

        int length = this.customers.length;
        for (int i = 0; i < length; i++) {
            customers[i].Info();
        }
    }
}
