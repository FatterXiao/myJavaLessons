package com.atguigu.extral_exers.exer01;

/**
 * 示例：replace(“aabbccbb”, “bb”, “dd”);  结果：aadccdd
 * 注意：不能使用String及StringBuffer等类的replace等现成的替换API方法
 * @author Mr.Helianthus
 * @create 2021-04-07 10:41 PM
 */
public class Test {
    public static void main(String[] args) {
        String str = "aabbccddee";
        System.out.println(myReplace(str, "dd", "qq"));
    }

    /**
     *
     * @param sourceStr
     * @param targetStr
     * @param replaceStr
     * @return
     */
    public static String myReplace(String sourceStr, String targetStr, String replaceStr) {
        //将要操作的字符串转化为字符数组；
        char[] val = sourceStr.toCharArray();
        char[] s1 = targetStr.toCharArray();
        char[] s2 = replaceStr.toCharArray();
        //记录字符串的长度
        int len = sourceStr.length();
        //创建一个存储新的值的字符数组 长度为 原来的长度加上要替换的减去目标字符
        char[] cur = new char[len + s2.length - s1.length];
        //寻找要替换的位置的下标
        //index用来遍历s1
        int index = 0;
        int i = 0;
        int x = 0;
        for (i = 0; i < val.length; i++) {
            if (val[i] == s1[index]) {
                if (index == s1.length - 1) {
                    break;
                }
                index++;
            } else {
                if (val.length - i < s1.length) {
                    break;
                }
                //如果不符合 将index赋值为0 继续下一次的遍历
                index = 0;
            }
        }
        //用x来存储s1开始的下标
        x = i - s1.length + 1;

        //第一段进行赋值
        for (int k = 0; k < x; k++) {
            cur[k] = val[k];
        }
        //替换部分赋值
        //用m来存储s2的下标
        int m = 0;
        for (int k = x; k < x + s2.length; k++) {
            cur[k] = s2[m];
            m++;
            //如果m=s2的长度 说明执行完毕
            if (m == s2.length) {
                break;
            }
        }
        //第三段赋值
        int n = x + s1.length;
        for (int k = x + s2.length; k < cur.length; k++) {
            cur[k] = val[n];
            n++;
            if (n == val.length) {
                break;
            }
        }

        String s=new String(cur);
        System.out.println(s.toString());
        return s;
    }

}
