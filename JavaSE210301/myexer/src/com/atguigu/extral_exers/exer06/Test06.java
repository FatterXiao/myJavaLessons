package com.atguigu.extral_exers.exer06;

/**
 * @author Mr.Helianthus
 * @create 2021-04-08 12:32 AM
 */
public class Test06 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,5,3,2,4,2};
        System.out.println(splitFind(arr));
    }

    public static int splitFind(int[] array) {
        if (null == array || array.length == 0) {
            return -1;
        }
        int length = array.length;

        int head, tall, index;
        head = 0;
        tall = length - 1;
        index = length / 2;
        int total = 0;
        for (int i : array) {
            total += i;
        }
        do {
            int totalLeft = 0;
            for (int le = 0; le < index; le++) {
                totalLeft += array[le];
            }
            int doubleValue=(total - array[index]);
            if (totalLeft*2 < doubleValue) {
                head=index;
                index = index + (length - index) / 2;
            } else if (totalLeft*2 > doubleValue) {
                tall=index;
                index = head + (index - head) / 2;
            } else {
                return index;
            }
        } while (index > head && index < tall);
        return -1;
    }
}
