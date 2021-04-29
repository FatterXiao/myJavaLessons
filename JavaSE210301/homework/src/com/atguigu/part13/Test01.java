package com.atguigu.part13;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 * @author Mr.Helianthus
 * @create 2021-03-29 9:12 PM
 */
public class Test01 {
    /*
        随机验证码。
        - 随机生成十组六位字符组成的验证码。
        - 验证码由大小写字母、数字字符组成
     */
    public static void main(String[] args) {
        char[] arr = new char[26+26+10];
        int len = arr.length;

        //使用字符数组保存原始字符
        for (int i = 0; i < arr.length; i++) {
            if(i<10){//前10个放数字
                arr[i] = (char)(i+48);
            }else if(i<10+26){//中间26个放大写字母
                arr[i] = (char)(i+65-10);
            }else{//剩下的放小写字母
                arr[i] = (char)(i+97-10-26);
            }
        }

        //随机生成10组验证码
        ArrayList list = new ArrayList();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            String str = "";
            HashMap map = new HashMap();
            map.put("123","1234");

        }

    }


}
