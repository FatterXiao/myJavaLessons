package com.atguigu.myproject02;

/**
 * CustomerList为Customer对象的管理模块，内部使用数组管理一组Customer对象
 */
public class CustomerList {
    /**
     * 用来保存客户对象的数组
     */
    private Customer[] customers;

    /**
     * 记录已保存客户对象的数量
     */
    private int total = 0;

    /**
     * 构造器，用来初始化customers数组
     * @param capicaty 指定customers数组的最大空间
     */
    public CustomerList(int capicaty) {
        customers = new Customer[capicaty];
    }


    /**
     * 将参数customer添加组中已有记录的最后一个客户对象记录之后
     * @param customer customer指定要添加的客户对象
     * @return 添加成功返回true；false表示数组已满，无法添加
     */
    public boolean addCustomer(Customer customer){
        if(total < customers.length){
            // 添加用户，用户数量 +1
            customers[total++] = customer;
            return true;
        }

        return false;
    }

    /**
     * 用参数customer替换数组中由index指定的对象
     * @param index  index指定所替换对象在数组中的位置，从0开始
     * @param cust customer指定替换的新客户对象
     * @return 替换成功返回true；false表示索引无效，无法替换
     */
    public boolean replaceCustomer(int index, Customer cust){
        if(index < 0 || index >= total){
            return false;
        }
        customers[index] = cust;
        return true;
    }

    /**
     * 从数组中删除参数index指定索引位置的客户对象记录
     * @param index  index指定所删除对象在数组中的索引位置，从0开始
     * @return 删除成功返回true；false表示索引无效，无法删除
     */
    public boolean deleteCustomer(int index){
        if(index < 0 || index >= total){
            return false;
        }
        // "i < total-1"
        for (int i = index; i < total-1; i++) {
            customers[i] = customers[i+1];
        }
        customers[total-1] = null;
        total--;
        return  true;
    }

    /**
     * 返回数组中记录的所有客户对象
     * @return  Customer[] 数组中包含了当前所有客户对象，该数组长度与对象个数相同
     */
    public Customer[] getAllCustomers(){
        if(total <= 0){
            return null;
        }
        Customer[] tempCust = new Customer[total];
        for (int i = 0; i < total; i++) {
            tempCust[i] = customers[i];
        }
        
        return tempCust;
    }

    /**
     * 返回参数index指定索引位置的客户对象记录
     * @param index  指定所要获取的客户在数组中的索引位置，从0开始
     * @return 封装了客户信息的Customer对象
     */
    public Customer getCustomer(int index){
        // "index < total"
        if(index >=0 && index < total){
            return customers[index];
        }
        return null;
    }

    /**
     * 获取用户总数
     * @return
     */
    public int getTotal(){
        return total;
    }

}
