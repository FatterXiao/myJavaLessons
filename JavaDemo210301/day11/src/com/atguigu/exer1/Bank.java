package com.atguigu.exer1;

/**
 * @author shkstart
 * @create 10:26
 */
public class Bank {//银行类
    private Customer[] customers = new Customer[10]; //用于保存银行中的多个客户
    private int numberOfCusotomers;//用于记录银行中实际的客户个数

    public Bank(){
//        customers = new Customer[10];
    }
    // addCustomer 方法必须依照参数（姓，名）构造一个新的 Customer对象，
    // 然后把它放到 customer 数组中。还必须把 numberOfCustomers 属性的值加 1。
    public void addCustomer(String f,String l){
        if(numberOfCusotomers < customers.length){
            Customer cust = new Customer(f,l);

//        customers[numberOfCusotomers] = cust;
//        numberOfCusotomers++;
            //合并
            customers[numberOfCusotomers++] = cust;
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }
    }
    //	getNumOfCustomers 方法返回 numberofCustomers 属性值
    public int getNumOfCustomers(){

        return numberOfCusotomers;
    }

    //getCustomer方法返回与给出的index参数相关的客户
    public Customer getCustomer(int index){
        if(index < 0 || index >= numberOfCusotomers){
            return null;
        }

        return customers[index];

    }

}
