package com.atguigu.exer3;

/**
 * 创建20个学生对象，学号为1到20，年级([1,6])和成绩([0-100])都由随机数确定。
 *  * 问题一：打印出3年级(state值为3）的学生信息。
 *  * 问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
 *  *
 *  * 提示：
 *  * 1) 生成随机数：Math.random()，返回值类型double;
 *  * 2) 四舍五入取整：Math.round(double d)，返回值类型long。
 *
 * @author shkstart
 * @create 14:14
 */
public class StudentTest { //测试类
    public static void main(String[] args) {
        //数组是引用数据类型，数组的元素可以是基本数据类型，也可以是引用数据类型:
        //String[] arr = new String[10]
        //int[][] arr1 = new int[10][];
        //Student[] arr2 = new Student[10];

        //创建对象数组
         Student[] stus = new Student[20];
         for(int i = 0;i < stus.length;i++){
             //给数组元素赋值
             stus[i] = new Student();
             //给数组元素(对象)的属性赋值
             stus[i].number = i + 1;
             stus[i].state = (int)(Math.random() * 6 + 1);
             stus[i].score = (int)(Math.random() * 101);
         }


         //问题一：打印出3年级(state值为3）的学生信息。
        StudentUtil util = new StudentUtil();
         util.printStudentWithState(stus,3);

        //问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
        //排序前：
        System.out.println("排序前：");
        util.printStudent(stus);

        //冒泡排序
        util.sortStudents(stus,"descend");

        //排序后：
        System.out.println("排序后：");
        util.printStudent(stus);
    }
}
