package com.atguigu.myproject02;

/**
 * CustomerView为主模块，负责菜单的显示和处理用户操作
 */
public class CustomerView {

    CustomerList customerList = new CustomerList(10);
    ;

    public CustomerView() {
        Customer customer = new Customer("孙鱼鱼", '男', 26, "18746524479", "sunFish@126.com");
        customerList.addCustomer(customer);
        customer = new Customer("曹鱼鱼", '男', 27, "1974879479", "caoFish@126.com");
        customerList.addCustomer(customer);
    }


    public void enterMainMenu() {


        boolean isFlag = true;
        while (isFlag) {
            System.out.println("-----------------客户信息管理软件-----------------\n");

            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");

            System.out.print("                   请选择(1-5)：");
            char menuChar = CMUtility.readMenuSelection();

            switch (menuChar) {
                case '1':
                    // 1 添 加 客 户
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    // 3 删 除 客 户
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.print("确认是否退出(Y/N)：");
                    char exitChar = CMUtility.readConfirmSelection();
                    if (exitChar == 'Y') {
                        isFlag = false;
                    }
                    break;

            }


        }

    }


    /**
     * 添 加 客 户
     */
    private void addNewCustomer() {
        System.out.println("---------------------添加客户---------------------\n");

        System.out.print("姓名：");
        String name = CMUtility.readString(5);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String telephone = CMUtility.readString(15);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name, gender, age, telephone, email);
        boolean isAdded = customerList.addCustomer(customer);
        if (isAdded) {
            System.out.println("=====================添加完成=====================");
        } else {
            System.out.println("=====================添加失败=====================");
        }


    }


    /**
     * 修改信息
     */
    private void modifyCustomer() {
        System.out.println("---------------------修改客户---------------------");
        int recieve;
        int total;
        while (true) {
            System.out.print("请选择待修改客户编号(-1退出)：");
            recieve = CMUtility.readInt();
            if (recieve == -1) {
                return;
            }

            total = customerList.getTotal();
            if (recieve > total || total == 0 || recieve <= 0) {
                System.out.println("无法找到指定客户！");
                continue;
            }
            // 此时 index = total -1;
            Customer customer = customerList.getCustomer(total - 1);
            System.out.print("姓名(" + customer.getName() + "):");
            String name = CMUtility.readString(8, customer.getName());
            System.out.print("性别(" + customer.getGender() + "):");
            char gender = CMUtility.readChar(customer.getGender());
            System.out.print("年龄(" + customer.getAge() + "):");
            int age = CMUtility.readInt(customer.getAge());
            System.out.print("电话(" + customer.getPhone() + "):");
            String telephone = CMUtility.readString(18, customer.getPhone());
            System.out.print("邮箱(" + customer.getEmail() + "):");
            String email = CMUtility.readString(30, customer.getEmail());

            Customer temp = new Customer(name, gender, age, telephone, email);
            boolean isModified = customerList.replaceCustomer(recieve - 1, temp);
            if (isModified) {
                System.out.println("=====================修改完成=====================");
            } else {
                System.out.println("=====================修改失败=====================");
            }
            return;


        }
    }


    /**
     * 删 除 客 户
     */
    private void deleteCustomer() {
        System.out.println("---------------------删除客户---------------------");
        for (; ; ) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            int receive = CMUtility.readInt();
            if (receive == -1) {
                return;
            }
            int total = customerList.getTotal();
            if (receive > total || total == 0 || receive <=0) {
                System.out.println("无法找到指定客户！");
                continue;
            }

            System.out.print("确认是否删除(Y/N)：");
            char isExit = CMUtility.readConfirmSelection();
            if (isExit == 'N') {
                return;
            }

            // index = total - 1;
            boolean isSucceed = customerList.deleteCustomer(receive - 1);
            if (isSucceed) {
                System.out.println("=====================删除完成=====================");
            } else {
                System.out.println("=====================删除失败=====================");
            }
            return;
        }

    }


    /**
     * 客 户 列 表
     */
    private void listAllCustomers() {
        System.out.println("---------------------------客户列表---------------------------");
        System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t\t邮箱");
        Customer[] allCustomers = customerList.getAllCustomers();
        int length = allCustomers.length;
        for (int i = 0; i < length; i++) {
            System.out.println((i + 1) + "\t\t" + allCustomers[i].getDetial());
        }
        System.out.println("=========================客户列表完成=========================");
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

}
