package com.atguigu.extral_exers.exer02;

/**
 * 2.
 * 1个字符串中可能包含a-z中的多个字符，字符也可能重复，
 * 例如：String data = “aabcexmkduyruieiopxzkkkkasdfjxjdsds”;
 * 写一个程序，对于给定一个这样的字符串求出字符串出现次数最多的那个字母以及出现的次数（若次数最多的字母有多个，则全部求出）
 * @author Mr.Helianthus
 * @create 2021-04-07 12:15 PM
 */
public class Test {
    public static void main(String[] args) {
        test();
    }

    public static void test(){
        String str = "aabcexmkduyruieiopxzkkkkasdfjxjdsds";
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z]","");
        char[] arr = str.toCharArray();

        int[] counts = new int[26];// 记录26个字母的次数
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            counts[arr[i]-97]++;
        }

        int max = counts[0];
        for (int i = 1; i < counts.length; i++) {
            if(max < counts[i]){
                max = counts[i];
            }
        }

        //打印最大值和字母
        for (int i = 0; i < counts.length; i++) {
            if(counts[i] == max){
                //i=0   'a'字母
                //i=1   'b'字母
                System.out.println(((char)(i+97)) + "出现了" + max + "次");
            }
        }

    }
}
