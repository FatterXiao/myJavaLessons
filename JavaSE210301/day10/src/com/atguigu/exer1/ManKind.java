package com.atguigu.exer1;

/**
 *
 * 定义一个ManKind类，包括
 * 成员变量int sex和int salary；
 * 方法void manOrWoman()：根据sex的值显示“man”(sex==1)或者“woman”(sex==0)；
 * 方法void employeed()：根据salary的值显示“no job”(salary==0)或者“ job”(salary!=0)。
 *
 *
 * @author shkstart
 * @create 15:25
 */
public class ManKind {
    private int sex;
    private int salary;

    public void manOrWoman(){
        if(sex == 1){
            System.out.println("Man");
        }else if(sex == 0){
            System.out.println("Woman");
        }
    }

    public void employeed(){
        if(salary == 0){
            System.out.println("no Job!");
        }else{
            System.out.println("Job!");
        }
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
