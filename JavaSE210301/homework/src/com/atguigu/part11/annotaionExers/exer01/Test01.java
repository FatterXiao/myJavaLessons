package com.atguigu.part11.annotaionExers.exer01;

public class Test01 {
    @SuppressWarnings({"unuse"})
    public static void main(String[] args) {
        ShapTools.printRectangle();
        ShapTools.printRectangle(3, 10, "#");
    }
}

/**
 * @author Mr.Nick
 * @version v1.0
 * @since version 1.0
 */
class ShapTools{
    @Deprecated
    public static void printRectangle(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void printRectangle(int line, int column, String sign){
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(sign);
            }
            System.out.println();
        }
    }
}