package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author shkstart
 * @create 10:09
 */
public class PropertiesTest {
    @Test
    public void test1() throws IOException {

        Properties pros = new Properties();
        FileInputStream fis = new FileInputStream(new File("info.properties"));
        pros.load(fis);

        String name = pros.getProperty("name");

        String pwd = pros.getProperty("password");

        System.out.println("name = " + name + ", pwd = " + pwd);

    }
}
