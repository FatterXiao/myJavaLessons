package com.atguigu;

/**
 * 5. 测试数组元素的默认值
 *        如果数组的元素是整型，则数组元素的默认值为：0
 *        如果数组的元素是浮点类型，则数组元素的默认值为：0.0
 *        如果数组的元素是boolean类型，则数组元素的默认值为：false
 *        如果数组的元素是char类型，则数组元素的默认值为：0 或 \u0000
 *
 *        如果数组的元素是引用数据类型，则数组元素的默认值为：null
 *
 *
 *   说明：数组元素的类型可以是基本数据类型，也可以是引用数据类型。
 *
 *
 *
 * @author shkstart
 * @create 11:26
 */
public class ArrayTest1 {
    public static void main(String[] args) {

        int[] arr1 = new int[5];

        for (int i = 0; i < arr1.length; i++) {
            System.out.println(arr1[i]);
        }
        System.out.println();
        //byte[] \ short[] \ long[]
        long[] arr2 = new long[3];
        System.out.println(arr2[0]);

        System.out.println();
        double[] arr3 = new double[10];
        System.out.println(arr3[0]);

        System.out.println();
        boolean[] arr4 = new boolean[10];
        System.out.println(arr4[0]);

        System.out.println();
        char[] arr5 = new char[5];
        for(int i = 0;i < arr5.length;i++){
            System.out.println("****" + arr5[i] + "####");
        }

        System.out.println(arr5[0] == ' ');//false
        System.out.println(arr5[0] == '0');//false
        System.out.println(arr5[0] == 0);//true

        System.out.println();
        String[] arr6 = new String[5];
        for(int i = 0;i < arr6.length;i++){
            System.out.println(arr6[i]);
        }

        System.out.println(arr6[0] == null);//true
        System.out.println(arr6[0] == "null");//false
    }
}
