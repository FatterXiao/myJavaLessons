package com.atguigu.day08.exer_ppt.exer01;

import java.util.Random;

/*
    定义类Student，包含三个属性：学号number(int)，年级state(int)，成绩score(int)。 创建20个学生对象，
    学号为1到20，年级和成绩都由随机数确定。
    问题一：打印出3年级(state值为3）的学生信息。
    问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息

    提示：
    1) 生成随机数：Math.random()，返回值类型double;
    2) 四舍五入取整：Math.round(double d)，返回值类型long。
 */
public class StudentUtil {


    /**
     * 打印所有学生的信息
     * @param students
     */
    public void printStudentDetails(Student[] students) {
        int length = students.length;
        for (int i = 0; i < length; i++) {
            System.out.println(students[i].getInfo());
        }
    }

    /**
     * 根据年级打印出学生信息
     *
     * @param students
     * @param grade    需要打印的年级
     */
    public void printStudentDetailByGrade(Student[] students, int grade) {
        int length = students.length;
        for (int i = 0; i < length - 1; i++) {
            if (students[i].state == grade) {
                System.out.println(students[i].getInfo());
            }
        }
    }

    /**
     * 创建学生，学号由1开始依次定义，年级(1-6)和成绩(0-100)都由随机数确定
     *
     * @param number
     * @return
     */
    public Student[] createStudents(int number) {
        if (number <= 0) {
            System.out.println("创建的学生数量错误：" + number);
            return null;
        }
        Random random = new Random();
        Student[] students = new Student[number];
        int length = students.length;
        for (int i = 0; i < length ; i++) {
            students[i] = new Student();
            students[i].number = i + 1;
            students[i].state = random.nextInt(6) + 1;
            students[i].score = random.nextInt(101);
        }

        return students;
    }

    /**
     * 使用冒泡排序按学生成绩，自小到大
     *
     * @param students
     */
    public void sort(Student[] students) {
        if (students == null) {
            System.out.println("【错误】：没有学生信息。");
            return;
        }

        int length = students.length;
        if (length == 1) {
            return;
        }

        for (int i = 0; i < length-1 ; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if (students[j].score > students[j+1].score) {
                    Student temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                }
            }
        }

    }


}
