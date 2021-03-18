package com.atguigu.part6.methodexpands.exer03;

/*
    - 知识点：方法的重载
 */
public class MyArrays {
    /**
     * 使用二分查找法在arr数组中查找value的下标，
     * 如果value不存在，就返回-1，
     * 如果数组arr不是有序的，结果将不一定正确
     * 默认数组 有小到大排列
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch(int[] arr, int value) {
        int head = 0;
        int tail = arr.length - 1;
        int mid = (head + tail) / 2;
        while (head <= tail) {

            int midValue = arr[mid];

            if (midValue == value) {
                return mid;
            }
            if (midValue > value) {
                mid--;
                tail = mid;
                continue;
            }
            if (midValue < value) {
                mid++;
                head = mid;
                continue;
            }
            mid = (head + tail) / 2;

        }

        return -1;
    }

    /**
     * 使用二分查找法在arr数组中查找value的下标，
     * 如果value不存在，就返回-1，
     * 如果数组arr不是有序的，结果将不一定正确
     *
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch(char[] arr, char value) {

        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else if (value < arr[mid]) {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     * 使用二分查找法在arr数组中查找value的下标，如果value不存在，就返回-1，如果数组arr不是有序的，结果将不一定正确
     * @param arr
     * @param value
     * @return
     */
    public int binarySearch(double[] arr, int value) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;

        while (left <= right) {
            if (arr[mid] == value) {
                return mid;
            } else if (value > arr[mid]) {
                left = mid + 1;
            } else if (value < arr[mid]) {
                right = mid - 1;
            }
            mid = (left + right) / 2;
        }
        return -1;
    }

    /**
     *
     * @param arr
     * @param length
     * @return
     */
    public int[] copy(int[] arr, int length) {
        // (1)创建新数组
        int[] newArr = new int[length];

        // (2)复制元素
        for (int i = 0; i < arr.length && i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    /**
     *
     * @param arr
     * @param length
     * @return
     */
    public char[] copy(char[] arr, int length) {
        // (1)创建新数组
        char[] newArr = new char[length];

        // (2)复制元素
        for (int i = 0; i < arr.length && i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    /**
     * int数组冒泡排序;
     * 从小到大排序
     * @param arr
     */
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - 1 - i; j++) {
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
