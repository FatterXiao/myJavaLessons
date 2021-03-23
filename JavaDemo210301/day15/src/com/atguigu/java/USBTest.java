package com.atguigu.java;

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
        //1. 创建了接口的实现类的对象
        Printer printer = new Printer();
//        operate(printer);
        //2. 创建了接口的实现类的匿名对象
//        operate(new KeyBoard());

        //3. 创建接口的匿名实现类的对象
        USB usb1 = new USB(){
            public void start(){
                System.out.println("mp3开始工作");
            }

            public void stop(){
                System.out.println("mp3结束工作");
            }
        };
//        operate(usb1);

        //4. 创建接口的匿名实现类的匿名对象
        operate(new USB(){

            @Override
            public void start() {
                System.out.println("电纸书开始工作");
            }

            @Override
            public void stop() {
                System.out.println("电纸书结束工作");
            }
        });
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