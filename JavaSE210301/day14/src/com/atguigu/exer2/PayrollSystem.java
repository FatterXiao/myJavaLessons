package com.atguigu.exer2;

import java.util.Calendar;
import java.util.Scanner;

/**
 * 定义PayrollSystem类，
 * 创建Employee变量数组并初始化，该数组存放各类雇员对象的引用。
 * 利用循环结构遍历数组元素，输出各个对象的类型,name,number,birthday,以及该对象生日。
 * <p>
 * 当键盘输入本月月份值时，如果本月是某个Employee对象的生日，还要输出增加工资信息。
 *
 * @author dj
 * @create 2021-03-16 20:18
 */
public class PayrollSystem {

    Employee[] employees = new Employee[2];

    public static void main(String[] args) {
        PayrollSystem test = new PayrollSystem();
        test.employees[0] = new SalariedEmployee("江学振", "1001", new MyDate(1995, 3, 4), 20000);
        test.employees[1] = new HourlyEmployee("荣鹏", "1002", new MyDate(1996, 4, 3), 100, 176);

        //方式1：
//        Scanner scan = new Scanner(System.in);
//        System.out.println("请输入当前的月份：");
//        int month = scan.nextInt();

        //方式2：
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
//        System.out.println(month);

        for (int i = 0; i < test.employees.length; i++) {
            System.out.println(test.employees[i]);
            double bonus = 0;
            if (month == test.employees[i].getBirthday().getMonth()) {
                System.out.println("生日快乐！奖100块钱");
                bonus = 100;
            }

            System.out.println("员工工资为：" + (test.employees[i].earnings() + bonus));
        }
    }


}
