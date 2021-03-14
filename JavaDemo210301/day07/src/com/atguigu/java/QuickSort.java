package com.atguigu.java;

/**
 * 快速排序
 * 通过一趟排序将待排序记录分割成独立的两部分，其中一部分记录的关键字均比另一部分关键字小，
 * 则分别对这两部分继续进行排序，直到整个序列有序。
 * @author shkstart
 * 2018-12-17
 */
public class QuickSort {
	/**
	 * 交换数组中i和j位置的数据
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	private static void subSort(int[] data, int start, int end) {
		if (start < end) { // 9, -16, 30, 23, -30, -49, 25, 21, 30
			int pivot = data[start];
			int low = start;
			int high = end + 1;
			while (true) {
			    // 从低到高，找到第一个 大于pivot的值
				while (low < end && data[++low] - pivot <= 0) //data[low] <= pivot
					;
				// 从高到低，找到第一个 小于pivot的值
				while (high > start && data[--high] - pivot >= 0) // data[high] >= pivot
					;
				if (low < high) {
					swap(data, low, high);
				} else {
					break;
				}
			}
			swap(data, start, high);
			
			subSort(data, start, high - 1);//递归调用
			subSort(data, high + 1, end);
		}
	}
	public static void quickSort(int[] data){
		subSort(data,0,data.length-1);
	}
	
	
	public static void main(String[] args) {
		int[] data = { 9, -16, 30, 23, -30, -49, 25, 21, 30 };
		System.out.println("排序之前：\n" + java.util.Arrays.toString(data));
		quickSort(data);
		System.out.println("排序之后：\n" + java.util.Arrays.toString(data));
	}
}
