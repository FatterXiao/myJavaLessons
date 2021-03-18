package com.atguigu.part6.methodexpands.exer01;

import org.junit.Test;

/*
    - 知识点：可变参数
    -
 */
public class Count {

    /**
     * 求0~n个整数的累加和，如果没有传参，就返回0
     * @param nums
     * @return
     */
    public long sum(int... nums){
        long sum = 0L;
        int length = nums.length;

        for (int i = 0; i < length; i++) {
            sum += nums[i];
        }
        return sum;
    }


    /**
     * 求1~n个整数中的最大值
     * @param a
     * @param others
     * @return
     */
    public int max(int a, int... others){
        int max = a;
        int length = others.length;
        for (int i = 0; i < length; i++) {
            max = max < others[i] ? others[i] : max;
        }
        return max;
    }


    /**
     * 求0~n个字符串的拼接结果
     * @param strings
     * @return
     */
    public String concat(String...  strings){
        String result = "";
        int length = strings.length;
        for (int i = 0; i < length; i++) {
            result += strings[i];
        }
        return result;
    }

    /**
     * 判断0~n个整数是否都是偶数，如果都是偶数，返回true，否则返回false
     * @param nums
     * @return
     */
    public boolean isEven(int... nums){
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if((nums[i] & 1) != 0){
                return false;
            }
        }

        return true;
    }

    @Test
    public void test(){
        Count c = new Count();
        System.out.println("1,2,3,4,5的总和：" + c.sum(1,2,3,4,5));
        System.out.println("3,4,2,1的最大值是：" + c.max(3,4,2,1));
        System.out.println("尚，硅，谷，好拼接的结果：" + c.concat("尚","硅","谷","好"));
        System.out.println("2,4,6,8是否都是偶数：" + c.isEven(2,4,6,8));
    }
}

