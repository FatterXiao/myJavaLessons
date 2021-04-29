package com.atguigu.exer;

import java.util.Arrays;

/**
 * 使用二维数组打印一个 10 行杨辉三角。
 *
 * 【提示】
 *  1. 第一行有 1 个元素, 第 n 行有 n 个元素
 *  2. 每一行的第一个元素和最后一个元素都是 1
 *  3. 从第三行开始, 对于非第一个元素和最后一个元素的元素。即：
 *   yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
 *
 *
 *   说明：笔试中数组是作为算法考察的一大门类（另一大门类就是考察String）；
 *        数组中的考察，其中一部分是创建特殊要求的数组。比如：杨辉三角，回形数等。
 *
 *   拓展1：
 *   创建一个长度为6的int型数组，要求数组元素的值都在1-30之间，且是随机赋值。
 *   同时，要求元素的值各不相同。
 *   拓展2：
 *   回形数
 *
 * @author shkstart
 * @create 9:21
 */
public class YangHuiAngleTest {

    /**
     * 打印杨辉三角
     */
    public static void YangHuiAngle(){
        //1. 创建一个二维数组
        int[][] yangHui = new int[10][];

        //2. 通过循环的方式，创建内层的数组
        for(int i = 0;i < yangHui.length;i++){
            yangHui[i] = new int[i + 1];
            //3. 给数组元素赋值
            //3.1 给每行的首末元素赋值为1
            yangHui[i][0] = yangHui[i][i] = 1;
            //3.2 给每行的非首末元素赋值：yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
            //if(i > 1){
            for(int j = 1;j < yangHui[i].length - 1;j++){ // "j = 1":从第2个值开始打印；"j < yangHui[i].length - 1":打印到倒数第2个值
                yangHui[i][j] = yangHui[i-1][j-1] + yangHui[i-1][j];
            }
            //}
        }

        //4. 二维数组的遍历
        for(int i = 0;i < yangHui.length;i++){
            for(int j = 0;j < yangHui[i].length;j++){
                System.out.print(yangHui[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     *  - main 函数
     * @param args
     */
    public static void main(String[] args) {

        PrintYangHuiAngle(10);
    }

    /**
     * 打印杨辉三角
     * @param lines 需要打印的行数
     */
    public static void PrintYangHuiAngle(int lines){
        if(lines <= 0){
            System.out.println("输入行数错误。");
            return;
        }

        int[][] yanghui = new int[lines][];

        for (int i = 0; i < yanghui.length ; i++) {
            yanghui[i] = new int[i + 1];

            yanghui[i][0] = yanghui[i][i] = 1;
            for (int j = 1; j < yanghui[i].length - 1; j++) {
                yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
            }
        }

        for (int i = 0; i < yanghui.length; i++) {
            for (int j = 0; j < yanghui[i].length; j++) {
                System.out.print(yanghui[i][j] + "\t");
            }
            System.out.println();

        }
    }
}
