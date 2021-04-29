package com.atguigu.p2;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 * @author shkstart
 * @create 11:54
 */
public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        customerList.addCustomer(new Customer("张三",'男',23,"13012341234","zhangs@gmail.com"));
        customerList.addCustomer(new Customer("李四",'男',43,"13012341234","zhangs@gmail.com"));
    }

    //进入主界面
    public void enterMainMenu(){
        boolean isFlag = true;
        while(isFlag){

            System.out.println("-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch(menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
//                    System.out.println("退出");
                    System.out.print("确认是否退出(Y/N)：");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
                    break;
            }
        }

    }
    //添加客户
    private void addNewCustomer(){
//        System.out.println("添加客户");
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(8);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(25);

        Customer customer = new Customer(name, gender, age, phone, email);
        boolean addSuccessed = customerList.addCustomer(customer);
        if(addSuccessed){
            System.out.println("---------------------添加完成---------------------");
        }else{
            System.out.println("很遗憾，客户列表已满，添加失败！");
        }



    }
    //修改客户
    private void modifyCustomer(){
//        System.out.println("修改客户");
        System.out.println("---------------------修改客户---------------------");

        Customer customer;
        int number;
        for(;;){
            System.out.print("请选择待修改客户编号(-1退出)：");
            number = CMUtility.readInt();

            if(number == -1){
                return; //结束方法
            }

            customer = customerList.getCustomer(number-1);
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }

        }

        //代码能执行到此，其实就意味着找到了指定编号的客户。下面进行修改即可
        System.out.print("姓名(" + customer.getName() + ")：");
        String name = CMUtility.readString(8, customer.getName());
        System.out.print("性别(" + customer.getGender() + ")：");
        char gender = CMUtility.readChar(customer.getGender());
        System.out.print("年龄("+ customer.getAge() +")：");
        int age = CMUtility.readInt(customer.getAge());
        System.out.print("电话("+ customer.getPhone() +")：");
        String phone = CMUtility.readString(13, customer.getPhone());
        System.out.print("邮箱("+ customer.getEmail() +")：");
        String email = CMUtility.readString(25, customer.getEmail());

        Customer cust = new Customer(name,gender,age,phone,email);
        boolean replaceSuccessed = customerList.replaceCustomer(number-1, cust);
        if(replaceSuccessed){
            System.out.println("---------------------修改完成---------------------");
        }else{
            System.out.println("---------------------修改失败---------------------");
        }
    }
    //删除客户
    private void deleteCustomer(){
//        System.out.println("删除客户");
        System.out.println("---------------------删除客户---------------------");
        Customer customer;
        int number;
        for(;;){
            System.out.print("请选择待删除客户编号(-1退出)：");
            number = CMUtility.readInt();

            if(number == -1){
                return; //结束方法
            }

            customer = customerList.getCustomer(number-1);
            if(customer == null){
                System.out.println("无法找到指定客户！");
            }else{
                break;
            }

        }
        //代码能执行到此，其实就意味着找到了指定编号的客户。下面进行删除即可
        System.out.print("确认是否删除(Y/N)：");
        char isDelete = CMUtility.readConfirmSelection();
        if(isDelete == 'Y'){
            boolean deleteSuccessed = customerList.deleteCustomer(number - 1);
            if(deleteSuccessed){
                System.out.println("---------------------删除完成---------------------");
            }else{
                System.out.println("---------------------删除失败---------------------");
            }
        }

    }
    //显示客户列表
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t\t邮箱");

        //思路1：
//        Customer[] customers = customerList.getAllCustomers();
//        if(customers.length == 0){
//            System.out.println("客户列表中没有任何客户信息！");
//        }else{
//
//        }
        //思路2
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("客户列表中没有任何客户信息！");
        }else{
            Customer[] customers = customerList.getAllCustomers();
            for(int i = 0;i <customers.length;i++){
                Customer cust = customers[i];
                System.out.println(i + 1 + "\t\t" + cust.getDetails());
            }
        }

        System.out.println("-------------------------客户列表完成-------------------------");

    }
    //主方法
    public static void main(String[] args){
        CustomerView view = new CustomerView();
        view.enterMainMenu();
    }

}
