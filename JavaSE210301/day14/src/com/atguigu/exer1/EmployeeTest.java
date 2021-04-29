package com.atguigu.exer1;

/**
 * @author shkstart
 * @create 15:26
 */
public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager("Tom", 1001, 3000, 2000);

        manager.work();

        CommonEmployee commonEmployee = new CommonEmployee();
        commonEmployee.work();
    }
}
