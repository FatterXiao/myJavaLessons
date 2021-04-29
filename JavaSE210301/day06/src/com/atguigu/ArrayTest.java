package com.atguigu;

/**
 * 一、数组的理解
 * 数组，可以看做是多个相同数据类型的变量按照一定顺序排列的组合（或集合）
 *
 *
 *  二、变量的分类：基本数据类型（8种） vs  引用数据类型（类、接口、数组）
 *      变量的声明格式：数据类型  变量名  = 变量值
 *
 *  三、一维数组的使用
 *  1. 数组的声明与定义
 *  2. 数组元素的调用
 *  3. 数组的属性：长度
 *  4. 数组的遍历
 *
 *  5. 数组元素的默认值  见：ArrayTest1.java
 *  6. 数组的内存解析  (有难度)
 *
 *  四、数组相关的概念
 *  1. 数组名
 *  2. 数组元素
 *  3. 数组的索引（角标、下角标）
 *  4. 数组的长度:数组中元素的个数
 *
 * 五、说明
 * 1. 不管是静态初始化，还是动态初始化，只要数组初始化完成，其长度就是确定的。
 * 2. 数组一旦初始化完成，其长度就不可变。
 * 3. 数组属于引用数据类型；
 *    数组的元素既可以是基本数据类型，也可以是引用数据类型。比如：int[] \ boolean[] \ char[] \ double[] \ String[]
 *
 * @author shkstart
 * @create 10:34
 */
public class ArrayTest {
    public static void main(String args[]) {
        //数据类型  变量名  = 变量值
        double price1 = 34.32;
        double price2 = 23.32;

        //1. 定义数组
        //1.1 数组的声明
        double[] prices;
        //1.2 数组的初始化
        //静态初始化方式：数组变量的赋值与数组元素的赋值同时进行。
        prices = new double[]{34.32,23.32,12.35};
        int[] nums = new int[]{1,2,3,4,5};

        //动态初始化方式：数组变量的赋值与数组元素的赋值分开进行。
        String[] names = new String[5];

        //错误的定义方式
//        int[] ids1 = new int[3]{3,4,5};
//        int[3] ids2 = new int[]{3,4,5};
//        int[3] ids3 = new int[3];

        //也是正确的方式
        int[] arr1 = {1,2,3}; //类型推断
        int arr2[] = new int[]{1,2,3};

        //2. 数组元素的调用:使用角标的方式进行调用
        //数组元素的角标是从0开始的，到数组的长度-1结束。
        System.out.println(prices[0]);
        System.out.println(nums[3]);

        names[0] = "张奥";
        names[1] = "陈亚飞";
        names[4] = "肖华";
//        names[5] = "郑璇"; 运行报错

        //3. 数组的长度：length
        System.out.println(names.length);//5
        System.out.println(nums.length);//5

        //4. 数组的遍历
//        System.out.println(nums[0]);
//        System.out.println(nums[1]);
//        System.out.println(nums[2]);
//        System.out.println(nums[3]);
//        System.out.println(nums[4]);

        for(int i = 0;i < nums.length;i++){//for(int i = 0;i < 5;i++){
            System.out.println(nums[i]);
        }
    }
}
