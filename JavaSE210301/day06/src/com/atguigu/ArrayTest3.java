package com.atguigu;

/**
 * 测试二维数组元素的默认值
 *    约定：arr1的元素称为外层元素，arr1[0]的元素称为内层元素
 *
 *   针对格式1：int[][] arr1 = new int[4][3];
 *      外层元素的值为：数组的类型和对应的指向一维数组的地址
 *      内层元素的值为：与一维数组的默认值相同
 *          如果数组的元素是整型，则数组元素的默认值为：0
 *          如果数组的元素是浮点类型，则数组元素的默认值为：0.0
 *          如果数组的元素是boolean类型，则数组元素的默认值为：false
 *          如果数组的元素是char类型，则数组元素的默认值为：0 或 \u0000
 *          如果数组的元素是引用数据类型，则数组元素的默认值为：null
 *
 *   针对格式2：int[][] arr2 = new int[4][];
 *       外层元素的值为：null
 *       内层元素的值为：报空指针异常的错误。
 *
 *
 *
 * @author shkstart
 * @create 15:40
 */
public class ArrayTest3 {

    public static void main(String[] args) {
        int[][] arr1 = new int[4][3];
        System.out.println(arr1[0]);//[I@1540e19d --"["代表一维数组，"[["二维数组；"I"代表int类型数据
        System.out.println(arr1[1]);//[I@677327b6
        System.out.println(arr1[2]);//[I@14ae5a5
        System.out.println(arr1[3]);//[I@7f31245a

        double[][] arr2 = new double[3][2];
        System.out.println(arr2[0]);//[D@6d6f6e28

        String[][] arr3 = new String[3][4];
        System.out.println(arr3[0]);//[Ljava.lang.String;@135fbaa4 -- "L"代表引用类型数据

        System.out.println(arr1[0][0]);//0
        System.out.println(arr2[0][0]);//0.0
        System.out.println(arr3[0][0]);//null

        System.out.println("############针对格式2##############");
        int[][] arr4 = new int[4][];
        System.out.println(arr4[0]);//null
        System.out.println(arr4[1]);//null
        System.out.println(arr4[2]);//null
        System.out.println(arr4[3]);//null

        double[][] arr5 = new double[3][];
        System.out.println(arr5[0]);//null

        //System.out.println(arr4[0][0]);//报错

        //最后一行代码报错，但是在开发中，我们确实有可能要遍历或操作二维数组的内层元素。
        //当报错的话，表明没有给外层元素进行赋值。则赋值之后即可。
        arr4[0] = new int[4];
        arr4[1] = new int[]{1,2,4};
        System.out.println(arr4[0][0]);//0
    }

}
