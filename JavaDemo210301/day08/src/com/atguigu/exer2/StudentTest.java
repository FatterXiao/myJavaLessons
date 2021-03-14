package com.atguigu.exer2;

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
public class StudentTest {
    public static void main(String[] args) {
        //太繁琐！不现实！
//        Student s1 = new Student();
//        s1.number = 1;
//        s1.state = (int)(Math.random() * 6 + 1);
//        s1.score = (int)(Math.random() * 101);
//
//        Student s2 = new Student();
//        s2.number = 1;
//        s2.state = (int)(Math.random() * 6 + 1);
//        s2.score = (int)(Math.random() * 101);
//
//        Student s3 = new Student();
//        s3.number = 1;
//        s3.state = (int)(Math.random() * 6 + 1);
//        s3.score = (int)(Math.random() * 101);

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
        for(int i = 0;i <stus.length;i++){
            if(3 == stus[i].state){
                Student s = stus[i];
                System.out.println("学生信息为：number = " + s.number + ", state = " + s.state + ", score = " + s.score);
            }
        }

        //问题二：使用冒泡排序按学生成绩排序，并遍历所有学生信息
        //排序前：
        System.out.println("排序前：");
        for(int i = 0;i <stus.length;i++){
            Student s = stus[i];
            System.out.println("学生信息为：number = " + s.number + ", state = " + s.state + ", score = " + s.score);
        }

        //冒泡排序
        for(int i = 0;i < stus.length - 1;i++){
            for(int j = 0;j < stus.length - 1 -i;j++){
                if(stus[j].score > stus[j + 1].score){
                    //错误的！
//                    int score = stus[j].score;
//                    stus[j].score = stus[j + 1].score;
//                    stus[j + 1].score = score;
                    //正确的：
                    Student temp = stus[j];
                    stus[j] = stus[j + 1];
                    stus[j + 1] = temp;
                }
            }
        }
        //排序后：
        System.out.println("排序后：");
        for(int i = 0;i <stus.length;i++){
            Student s = stus[i];
            System.out.println("学生信息为：number = " + s.number + ", state = " + s.state + ", score = " + s.score);
        }
    }
}
