package com.atguigu.java2;

/**
 * 一、枚举类：类的对象只有有限个，确定的。
 *
 * 二、举例如下：
 * 星期：Monday(星期一)、......、Sunday(星期天)
 * 性别：Man(男)、Woman(女)
 * 季节：Spring(春节)......Winter(冬天)
 * 支付方式：Cash（现金）、WeChatPay（微信）、Alipay(支付宝)、BankCard(银行卡)、CreditCard(信用卡)
 * 就职状态：Busy、Free、Vocation、Dimission
 * 订单状态：Nonpayment（未付款）、Paid（已付款）、Delivered（已发货）、Return（退货）、Checked（已确认）、Fulfilled（已配货）
 * 线程状态：创建、就绪、运行、阻塞、死亡
 *
 * 三、当需要定义一组常量时，强烈建议使用枚举类
 *
 *  补充：如果枚举类的对象只有一个，则也是单例模式的体现。
 *
 * 四、如何定义枚举类？
 * 方式一：自定义类的方式
 * 方式二：使用enum关键字 （jdk5.0）
 *
 * @author shkstart
 * @create 16:46
 */
public class EnumTest {
    public static void main(String[] args) {
        Season spring = Season.SPRING;
        System.out.println(spring);
        System.out.println(spring.getSeasonName());
        System.out.println(spring.getSeasonDesc());
    }
}

class Season{//季节

    //对象的实例变量
    private final String seasonName;//季节的名称
    private final String seasonDesc;//季节的描述
    //提供私有的构造器
    private Season(String seasonName,String seasonDesc){
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }

    //内部提供4个枚举类的对象
    public static final Season  SPRING = new Season("春天","春暖花开");
    public static final Season  SUMMER = new Season("夏天","夏日炎炎");
    public static final Season  AUTUMN = new Season("秋天","秋高气爽");
    public static final Season  WINTER = new Season("冬天","白雪皑皑");

    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDesc='" + seasonDesc + '\'' +
                '}';
    }
}
