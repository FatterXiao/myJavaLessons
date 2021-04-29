package com.atguigu.java2;


/**
 * 抽象类的应用：模板方法的设计模式
 *
 * @author shkstart
 * @create 14:15
 */
public class TemplateTest {

    public static void main(String[] args) {
        Template temp = new SubTemplate1();
        temp.spendTime();
    }

}

abstract class Template{

    /**
     * 计算某段代码执行所需要的花费的时间
     */
    public void spendTime(){

        long start = System.currentTimeMillis();

        //执行某段代码
        this.code();

        long end = System.currentTimeMillis();

        System.out.println("花费的时间为：" + (end - start));

    }

    protected abstract void code();

}

class SubTemplate1 extends Template{

    @Override
    protected void code() {
        boolean isFlag = true;
        for(int i = 2 ;i <= 10000;i++){
            for(int j = 2;j <= Math.sqrt(i);j++){
                if(i % j == 0){
                    isFlag = false;
                    break;
                }
            }

            if(isFlag){
                System.out.println(i);
            }
            isFlag = true;

        }

    }
}

class SubTemplate2 extends Template{

    @Override
    protected void code() {

    }
}
