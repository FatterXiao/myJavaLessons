package com.atguigu.java;

/**
 * @author shkstart
 * @create 14:54
 */
public class ArrayUtilTest {
    public static void main(String[] args) {

        ArrayUtil util = new ArrayUtil();

        int[] arr = new int[]{3,42,2,53,65,24,65,87,-95,-84,0,45};

        int max = util.getMax(arr);
        System.out.println(max);
    }
}
