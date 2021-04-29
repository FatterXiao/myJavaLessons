package com.atguigu.part5.exer08;

/*
    根据标准答案【ADBCD】，每题2分共10分，求出每名学生最终得分。
 */
public class GradesTest {
    public static void main(String[] args) {
        //标准答案：
        char[] answer = {'A','D','B','C','D'};

        //学生的答案
        char[] shang = {'D','C','B','A','D'};
        char[] gui = {'A','D','B','C','D'};
        char[] gu = {'A','D','B','C','A'};
        char[] hao = {'A','B','C','D','D'};

        //求出每名学生最终得分。
        int shangFen = 0;
        for(int i=0; i<shang.length; i++){
            if(shang[i] == answer[i]){
                shangFen +=2;
            }
        }
        System.out.println("小尚的分数：" + shangFen);

        int guiFen = 0;
        for(int i=0; i<gui.length; i++){
            if(gui[i] == answer[i]){
                guiFen +=2;
            }
        }
        System.out.println("小硅的分数：" + guiFen);

        int guFen = 0;
        for(int i=0; i<gu.length; i++){
            if(gu[i] == answer[i]){
                guFen +=2;
            }
        }
        System.out.println("小谷的分数：" + guFen);

        int haoFen = 0;
        for(int i=0; i<hao.length; i++){
            if(hao[i] == answer[i]){
                haoFen +=2;
            }
        }
        System.out.println("小好的分数：" + haoFen);
    }

}
