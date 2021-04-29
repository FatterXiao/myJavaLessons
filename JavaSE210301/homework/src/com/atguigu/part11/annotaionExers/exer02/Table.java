package com.atguigu.part11.annotaionExers.exer02;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 声明自定义注解@Table
 ​	（1）加上String类型的配置参数value
 ​	（2）并限定@Table的使用位置为类上
 ​	（3）并指定生命周期为“运行时”
 * @author Mr.Helianthus
 * @create 2021-03-26 8:04 PM
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value();
}
