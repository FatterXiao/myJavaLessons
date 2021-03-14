package com.atguigu;

/**
 *
 *
 * 1. 数组属于引用数据类型；
 *   数组的元素既可以是基本数据类型，也可以是引用数据类型。如果数组的元素还是数组的话，则构成了多维数组
 *
 * 2. 二维数组的使用
 *    1) 数组的声明与定义
 *    2) 数组元素的调用
 *    3) 数组的属性：长度
 *    4) 数组的遍历
 *    5) 数组元素的默认值  见：ArrayTest3.java
 *    6) 数组的内存解析  (有难度)
 *
 * @author shkstart
 * @create 15:12
 */
public class ArrayTest2 {
    public static void main(String[] args) {
        //理解
        String[] star1 = new String[]{"陈伟霆","13121341234"};
        String[] star2 = new String[]{"刘诗诗","13221341234"};
        //一维数组star1,star2又作为了另一个一维数组stars的元素，则构成二维数组
        String[][] stars = new String[][]{star1,star2};//二维数组

        //1. 数组的声明与定义
        int[][] arr1;
        arr1 = new int[][]{{1,2,3},{5,6,7},{7,8}};//静态初始化

        //动态初始化方式1
        int[][] arr2 = new int[4][3];
        //动态初始化方式2
        int[][] arr3 = new int[5][];

        //错误的写法
//        int[][] arr4 = new int[4][3]{{1,2,3},{5,6,7},{7,8}};
//        int[][] arr5 = new int[][3];

        //正确的其他写法
        int arr6[][] = new int[4][3];
        int[] arr7[] = new int[4][];
        int[][] arr8 = {{1,2,3},{5,6,7},{7,8}};//类型推断

        //2. 数组元素的调用
        // 通过角标的方式进行调用
        System.out.println(arr1[0][0]);
        System.out.println(arr1[2][0]);

        arr6[1][2] = 12;

        //3. 数组的属性：长度
        System.out.println(arr1.length);//3
        System.out.println(arr1[2].length);//2

        //4. 数组的遍历
        for(int i = 0;i < arr1.length;i++){
            for(int j = 0;j < arr1[i].length;j++){

                System.out.print(arr1[i][j] +"\t");
            }
            System.out.println();
        }
    }
}
