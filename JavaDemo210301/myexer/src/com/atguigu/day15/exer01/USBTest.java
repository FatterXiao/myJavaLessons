package com.atguigu.day15.exer01;

public class USBTest {
    public static void main(String[] args) {
            USB usb = new USB() {
                @Override
                public void start() {
                    System.out.println("嘻嘻");
                }

                @Override
                public void stop() {
                    System.out.println("哈哈");
                }
            };
    }
}
