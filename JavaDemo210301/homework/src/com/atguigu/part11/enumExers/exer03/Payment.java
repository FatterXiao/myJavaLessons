package com.atguigu.part11.enumExers.exer03;

/*
    案例：
​	1、声明可支付接口Payable：
​		包含抽象方法：void pay();
​	2、声明支付枚举类Payment：
​	（1）创建常量对象：支付宝（ALIPAY），微信（WECHAT），信用卡（CREDIT_CARD），储蓄卡（DEPOSIT_CARD）
​	（2）枚举类Payment实现接口Payable
​	①支付宝/微信：对接口的实现是打印“扫码支付”
​	②信用卡/储蓄卡：对接口的实现是打印“输入卡号支付”
​	3、在测试类中，获取所有支付对象，并调用它们的pay()
 */
public enum Payment implements Payable{
    ALIPAY{
        @Override
        public void pay() {
            System.out.println("扫码支付");

        }
    },
    WECHAT{
        @Override
        public void pay() {
            System.out.println("扫码支付");
        }
    },
    CREDIT_CARD,
    DEPOSIT_CARD;

    @Override
    public void pay() {
        System.out.println("输入卡号支付");
    }
}
