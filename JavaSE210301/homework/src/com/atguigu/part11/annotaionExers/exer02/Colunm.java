package com.atguigu.part11.annotaionExers.exer02;

import javax.xml.bind.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明自定义注解@Column
 * （1）加上String类型的配置参数name，表示表格的列名
 * （2）加上String类型的配置参数type，表示表格的列数据类型
 * （3）并限定@Column的使用位置在属性上
 * （4）并指定生命周期为“运行时”
 * @author Mr.Helianthus
 * @create 2021-03-26 8:08 PM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Colunm {
    /**
     * 表格的列名
     * @return
     */
    String name();

    /**
     * 表格的列数据类型
     * @return
     */
    String type();
}
