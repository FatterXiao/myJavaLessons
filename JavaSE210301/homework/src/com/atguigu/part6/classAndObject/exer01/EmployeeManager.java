package com.atguigu.part6.classAndObject.exer01;

import org.junit.Test;

public class EmployeeManager {

    /**
     * 遍历打印员工数组中的每个员工的详细信息
     * @param all
     */
    public void print(Employee[] all){
        if(all == null){
            return;
        }

        for (int i = 0; i < all.length; i++) {
            all[i].printInfo();
        }
    }

    /**
     * 将all员工数组按照年龄从高到低排序
     * @param all
     */
    public void sort(Employee[] all){
        int length = all.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if(all[j].age < all[j+1].age){
                    Employee temp = all[j];
                    all[j] = all[j+1];
                    all[j+1] = temp;
                }
            }
        }
    }


    /**
     * 将all员工数组的每一个员工的工资，增加increament
     * @param all
     * @param increament
     */
    public void addSalary(Employee[] all, double increament){
        for (int i = 0; i < all.length; i++) {
            all[i].salary += increament;
        }
    }


    @Test
    public void test(){
        Employee[] all = new Employee[5];
        all[0] = new Employee();
        all[0].setInfo(1,"张三",10000,23);

        all[1] = new Employee();
        all[1].setInfo(2,"李四",12000,23);

        all[2] = new Employee();
        all[2].setInfo(3,"王五",8000,18);

        all[3] = new Employee();
        all[3].setInfo(4,"赵六",6000,20);

        all[4] = new Employee();
        all[4].setInfo(5,"钱七",15000,21);

        EmployeeManager em = new EmployeeManager();

        em.print(all);
        System.out.println("------------------------------------------");

        em.sort(all);
        em.print(all);
        System.out.println("------------------------------------------");

        em.addSalary(all, 200);
        em.print(all);
    }
}
