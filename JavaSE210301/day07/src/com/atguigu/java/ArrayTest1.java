package com.atguigu.java;

/**
 * 数组的常见算法二：复制、反转、查找、遍历
 * @author shkstart
 * @create 10:21
 */
public class ArrayTest1 {

    public static void main(String[] args) {
        int[] arr = new int[]{3,42,2,53,65,24,65,87,-95,-84,0,45};

        //复制
        int[] arrCopy = new int[arr.length];
        for (int i = 0; i < arrCopy.length; i++) {
            arrCopy[i] = arr[i];
        }


        //遍历
        for (int i = 0; i < arr.length; i++) {
            if(i == 0){
                System.out.print("{");
            }else if(i == arr.length - 1){
                System.out.print(arr[i] + "}");
                break;
            }

            System.out.print(arr[i] +",");
        }

        //反转方式一：
        for(int i = 0,j = arr.length - 1; i < j ;i++,j--){ // 结束条件"i < j",奇数时不需要判别
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        //反转方式二：
//        for(int i = 0;i < arr.length / 2;i++){
//            int temp = arr[i];
//            arr[i] = arr[arr.length - 1 - i];
//            arr[arr.length - 1 - i] = temp;
//        }

        System.out.println();
        //遍历arr1
        for (int i = 0; i < arr.length; i++) {
            if(i == 0){
                System.out.print("{");
            }else if(i == arr.length - 1){
                System.out.print(arr[i] + "}");
                break;
            }
            System.out.print(arr[i] +",");
        }

        //查找(或搜索):如果查找到了，打印其在数组中的索引；如果没找到，打印没有找到的提示
        //线性查找
        int target = 244;
        boolean isFlag = true;
        for(int i = 0;i < arr.length;i++){
            if(target == arr[i]){
                System.out.println("查找到了" + target +"元素，索引位置为：" + i);
                isFlag = false;
                break;
            }
        }

        if(isFlag){
            System.out.println("不好意思，没找到");
        }

        //二分法查找：了解
        //二分法查找：要求此数组必须是有序的。
        int[] arr3 = new int[]{-99,-54,-2,0,2,33,43,256,999};
        boolean isFlag1 = true;
        int number = 256;
        number = 25;
        int head = 0;//首索引位置
        int end = arr3.length - 1;//尾索引位置
        while(head <= end){
            int middle = (head + end) / 2;
            if(arr3[middle] == number){
                System.out.println("找到指定的元素，索引为：" + middle);
                isFlag1 = false;
                break;
            }else if(arr3[middle] > number){
                end = middle - 1;
            }else{//arr3[middle] < number
                head = middle + 1;
            }
        }

        if(isFlag1){
            System.out.println("未找打指定的元素");
        }

    }
}
