package com.atguigu.exer;

import java.util.Scanner;
import java.util.Vector;

/**
 * 利用Vector代替数组处理：从键盘读入学生成绩（以负数代表输入结束），找出最高分，
 * 并输出学生成绩等级。
 * <p>
 * 提示：数组一旦创建，长度就固定不变，所以在创建数组前就需要知道它的长度。
 * 而向量类java.util.Vector可以根据需要动态伸缩。
 * <p>
 * 创建Vector对象：Vector v=new Vector();
 * 给向量添加元素：v.addElement(Object obj);   //obj必须是对象
 * 取出向量中的元素：Object  obj=v.elementAt(0);
 * 注意第一个元素的下标是0，返回值是Object类型的。
 * 计算向量的长度：v.size();
 * 若与最高分相差10分内：A等；20分内：B等；
 * 30分内：C等；其它：D等
 *
 * @author shkstart
 * @create 11:12
 */
public class ScoreTest {

    public static void main(String[] args) {

        //1. 实例化Vector
        Vector v = new Vector();
        //2. 实例化Scanner
        Scanner scann = new Scanner(System.in);

        //3. 通过循环的方式，多次从键盘获取学生成绩
        int maxScore = 0;//记录最高分
        for(;;){
            System.out.println("请输入学生的成绩（以负数代表输入结束）：");
            int score = scann.nextInt();

            //判断score是否是负数，如果是，退出循环
            if(score < 0){
                break;
            }

            //4. 调用Vector的addElement(Object obj)
            //方式1：
//            v.add(new Integer(score));//jdk5.0之前的做法
            //方式2：
            v.addElement(score);//自动装箱

            //5. 获取学生成绩的最高分
            if(maxScore < score){
                maxScore = score;
            }
        }
        //6. 遍历各个学生的成绩，并根据其与最高分的差值，计算等级
        for(int i = 0; i < v.size();i++){
            char grade;
            //jdk5之前的做法
//            Object obj = v.elementAt(i);
//            Integer int1 = (Integer) obj;
//            int score = int1.intValue();

            //jdk5及之后的做法
            int score = (int) v.elementAt(i);
            if(score >= maxScore - 10){
                grade = 'A';
            }else if(score >= maxScore - 20){
                grade = 'B';
            }else if(score >= maxScore - 30){
                grade = 'C';
            }else{
                grade = 'D';
            }
            System.out.println("student " + i +" score is " + score + " grade is " + grade);
        }

    }
}
