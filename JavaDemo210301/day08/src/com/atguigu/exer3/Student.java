package com.atguigu.exer3;

/**
 * 4. 对象数组题目：升级！
 * 定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。
 *
 * @author shkstart
 * @create 14:14
 */
public class Student {
    int number;//学号
    int state;//年级
    int score;//成绩

    public String getInfo() {

        return "学生信息为：number = " + number + ", state = " + state + ", score = " + score;
    }
}
