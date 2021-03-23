package com.atguigu.exer1;

/**
 * @author shkstart
 * @create 15:25
 */
public class CommonEmployee extends  Employee{

    public CommonEmployee(String name, int id, double salary) {
        super(name, id, salary);
    }

    public CommonEmployee() {

    }

    @Override
    public void work() {
        System.out.println("普通员工在一线工作");
    }
}
