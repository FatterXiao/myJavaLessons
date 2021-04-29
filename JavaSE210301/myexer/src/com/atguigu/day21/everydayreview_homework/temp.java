package com.atguigu.day21.everydayreview_homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-03-30 8:50 PM
 */
public class temp {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(34);
        list.add("AA");
        list.add("AA");
        list.add("AA");
        list.add("CC");

        List dest = Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);
        System.out.println(dest);
    }
}
