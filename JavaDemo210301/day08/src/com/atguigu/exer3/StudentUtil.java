package com.atguigu.exer3;

/**
 * 学生类的工具类
 *
 * @author shkstart
 * @create 14:38
 */
public class StudentUtil {

    /**
     *  打印出指定年级的学生信息
     * @param stus 指定的学生数组
     * @param state 指定的年级
     */
    public void printStudentWithState(Student[] stus,int state){
        for(int i = 0;i <stus.length;i++){
            if(state == stus[i].state){
                Student s = stus[i];
                System.out.println(s.getInfo());
            }
        }
    }

    /**
     * 遍历指定的学生数组中的学生信息
     * @param stus
     */
    public void printStudent(Student[] stus){
        for(int i = 0;i <stus.length;i++){
            Student s = stus[i];
            System.out.println(s.getInfo());
        }
    }

    /**
     * 对学生数组进行排序
     */
    public void sortStudents(Student[] stus,String sort){
        if("ascend".equals(sort)){ //ascend:升序
            for(int i = 0;i < stus.length - 1;i++){
                for(int j = 0;j < stus.length - 1 -i;j++){
                    if(stus[j].score > stus[j + 1].score){
                        //正确的：
                        Student temp = stus[j];
                        stus[j] = stus[j + 1];
                        stus[j + 1] = temp;
                    }
                }
            }
        }else if("descend".equals(sort)){ //descend：降序
            for(int i = 0;i < stus.length - 1;i++){
                for(int j = 0;j < stus.length - 1 -i;j++){
                    if(stus[j].score < stus[j + 1].score){
                        //正确的：
                        Student temp = stus[j];
                        stus[j] = stus[j + 1];
                        stus[j + 1] = temp;
                    }
                }
            }
        }else{
            System.out.println("指定的排序方式有误！");
        }

    }
}
