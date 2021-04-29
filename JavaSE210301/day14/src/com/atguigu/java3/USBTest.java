package com.atguigu.java3;

/**
 *
 * 体会接口的规范！
 *
 * 接口，也存在多态性！
 *
 * @author shkstart
 * @create 16:42
 */
public class USBTest {

    public static void main(String[] args) {
        Printer printer = new Printer();
        operate(printer);

        operate(new KeyBoard());
    }

    public static void operate(USB usb){ //USB usb = new Printer();

        System.out.println("========检测外部设备=========");

        usb.start();

        System.out.println("==========具体的数据传输过程===========");

        usb.stop();
    }

}


interface  USB{
    //常量：定义的USB的尺寸等

    void start();

    void stop();
}

class Printer implements USB{//打印机

    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机结束工作");
    }
}

class KeyBoard implements USB{

    @Override
    public void start() {
        System.out.println("键盘开始工作");
    }

    @Override
    public void stop() {
        System.out.println("键盘结束工作");
    }
}