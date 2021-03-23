package com.atguigu.day14.part08ppt;

public class PayrollSystem {
    private Employee[] employees;
    private  int total = 0;
    private static final double BONUSBYBIRTH = 1000;

    public PayrollSystem(int employNumbers) {
        this.employees = new Employee[employNumbers];
    }

    public void addEmployee(Employee employee){
        if(total > employees.length){
            // error
            return;
        }

        employees[total-1] = employee;
        total++;
    }

    public void showDetials(){
        if(total <= 1){
            System.out.println("当前系统中不存在用户。");
            return;
        }

        int length = employees.length;
        for (int i = 0; i < length; i++) {
            System.out.println(employees[i].getClass() + employees[i].toString());
        }
    }

    public void raiseSalary(int month){
        if(total <= 0){
            return;
        }
        int length = employees.length;
        for (int i = 0; i < length; i++) {
            if(employees[i].getBirthday().getMonth() == month){
                //employees[i]
            }

        }
    }
}
