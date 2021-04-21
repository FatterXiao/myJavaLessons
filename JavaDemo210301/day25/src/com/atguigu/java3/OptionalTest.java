package com.atguigu.java3;

import org.junit.Test;

import java.util.Optional;

/**
 * @author shkstart
 * @create 17:22
 */
public class OptionalTest {

    @Test
    public void test(){

        String star = "邓丽君";
        star = null;
        //ofNullable(T t): 返回一个封装了t对象的Optional的实例
        //此时形参t是有可能为null的
        Optional<String> optional = Optional.ofNullable(star);

        String otherStar = "成龙";
        //orElse(T t1):如果Optional对象内部封装的t对象不为null，则将t返回。
        //如果Optional对象内部封装的t对象为null，则将t1返回。
        String finalStar = optional.orElse(otherStar);
        System.out.println(finalStar.toString());

    }


}
