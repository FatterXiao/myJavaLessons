package com.atguigu.java;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

/**
 * @author shkstart
 * @create 11:25
 */
public class CommonIOTest {
    public static void main(String[] args) {

        try {
            FileUtils.copyFile(new File("day23\\yangm.png"),new File("day23\\yangm2.png"));
            System.out.println("ε€εΆζε");
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
