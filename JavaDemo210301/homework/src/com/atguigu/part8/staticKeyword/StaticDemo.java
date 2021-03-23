package com.atguigu.part8.staticKeyword;

public class StaticDemo {
    public static void main(String[] args) {
        /*
            x : 4 5 6
            y : 1 2 3
         */
        System.out.println(new SDText().x + "," + new SDText().y + "," + new SDText().x);
        // 4 3 6
    }
}

class SDText {
    static SDText sd = new SDText();
    static int x = 3;
    static int y;

    public SDText() {
        x++;
        y++;
    }
}
