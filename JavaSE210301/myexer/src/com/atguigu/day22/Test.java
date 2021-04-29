package com.atguigu.day22;

import java.io.*;

/**
 * @author Mr.Helianthus
 * @create 2021-03-31 2:42 PM
 */
public class Test {

    @org.junit.Test
    public void test()   {
        FileWriter fw = null;
        try {
            File file = new File("io_test.txt");

            fw = new FileWriter(file);
            fw.write("abcdefesd");

            System.out.println("==== 写入成功 ====");
            System.out.println(file.getAbsoluteFile());

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                fw.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    @org.junit.Test
    public void test1(){
        FileReader fr = null;
        try {
            fr = new FileReader(new File("io_test.txt"));
            char[] cbuffer = new char[5];
            int len;
            while((len = fr.read(cbuffer)) != -1){
                System.out.println(new String(cbuffer,0,len));
            }
        } catch (IOException e) {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }


    }

}
