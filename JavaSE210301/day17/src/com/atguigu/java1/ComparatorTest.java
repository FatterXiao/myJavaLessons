package com.atguigu.java1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 测试定制排序：
 * ① 创建一个Comparator实现类的对象
 * ② 重写compare():在compare()方法中，指明排序的方式
 *
 * @author shkstart
 * @create 15:14
 */
public class ComparatorTest {

    @Test
    public void test1(){
        Goods g1 = new Goods("Razer", 120);
        Goods g2 = new Goods("Lenovo", 23);
        Goods g3 = new Goods("HP", 56.43);
        Goods g4 = new Goods("Logitech", 56.43);
        Goods g5 = new Goods("Asus", 56.43);

        Goods[] arr = new Goods[]{g1,g2,g3,g4,g5};

        System.out.println(Arrays.toString(arr));

        //定制排序
        //① 创建一个Comparator实现类的对象
        Comparator comparator = new Comparator(){
            //② 重写compare()
            //在compare()方法中，指明排序的方式
            //需求：按照商品价格从小到大排序，如果价格相同，接着按照商品名称排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;

                    int comparePrice = Double.compare(g1.getPrice(), g2.getPrice());
                    if(comparePrice != 0){
                        return comparePrice;
                    }
                    //接着比较商品名称
                    return -g1.getName().compareTo(g2.getName());

                }
                throw new RuntimeException("输入的数据类型不匹配");
            }
        };


        Comparator comparator1 = new Comparator(){
            //② 重写compare()
            //在compare()方法中，指明排序的方式
            //需求：按照商品价格从小到大排序，如果价格相同，接着按照商品名称排序
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods){
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;

                    int comparePrice = Double.compare(g1.getPrice(), g2.getPrice());
                    return comparePrice;

                }
                throw new RuntimeException("输入的数据类型不匹配");
            }
        };
        Arrays.sort(arr,comparator1);


        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
        String[] arr = new String[]{"Tom","Kite","Abel","Kitty","Tonny","Jack"};

        System.out.println(Arrays.toString(arr));

        Arrays.sort(arr,new Comparator(){

            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String && o2 instanceof String){
                    String s1 = (String)o1;
                    String s2 = (String)o2;
                    return -s1.compareTo(s2);
                }
                throw new RuntimeException("输入的数据类型不匹配");
            }
        });

        System.out.println(Arrays.toString(arr));
    }

}
