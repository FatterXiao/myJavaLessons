package com.atguigu.extral_exers.exer08;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Mr.Helianthus
 * @create 2021-04-07 8:13 PM
 */
public class Test {
    public static void main(String[] args) {
        String content = "中中国55kkfff";
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        while (content.length() > 0){
            Character c = content.charAt(0);
            content = content.substring(1);
            Integer count = map.get(c);
            if (count == null) {
                map.put(c, 1);
            } else {
                map.put(c, count + 1);
            }
        }

        Set<Map.Entry<Character, Integer>> entrySet = map.entrySet();
        for (Map.Entry<Character, Integer> entry : entrySet) {
            System.out.println(entry);
        }
    }
}
