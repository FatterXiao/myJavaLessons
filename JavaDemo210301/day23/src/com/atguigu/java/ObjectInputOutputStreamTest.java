package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 测试对象流的使用
 *
 * ObjectInputStream \ ObjectOutputStream
 *
 * 什么是对象的序列化机制？
 * 对象序列化机制允许把内存中的Java对象转换成平台无关的二进制流，
 * 从而允许把这种二进制流持久地保存在磁盘上，或通过网络将这种二进制
 * 流传输到另一个网络节点。//当其它程序获取了这种二进制流，就可以恢
 * 复成原来的Java对象。
 *
 * @author shkstart
 * @create 9:52
 */
public class ObjectInputOutputStreamTest {

    //序列化过程：将内存中的java对象保存在文件中。使用ObjectOutputStream实现
    @Test
    public void test1() throws IOException {
        //1.
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("object.txt"));
        //2.
        oos.writeObject(new String("Tom"));
        oos.flush();//刷新

        oos.writeObject(new String("Jerry"));
        oos.flush();//刷新

        oos.writeObject(new Person("荣鹏",23,new Pet("大黄")));
        oos.flush();//刷新

        //3.
        oos.close();

    }
    //反序列化过程：将磁盘文件中的数据还原为内存中的java对象。 使用ObjectInputStream实现
    @Test
    public void test2() throws IOException, ClassNotFoundException {
        //1.
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("object.txt"));
        //2.
        String str1 = (String) ois.readObject();
        String str2 = (String) ois.readObject();
        Person p = (Person) ois.readObject();

        System.out.println(str1);
        System.out.println(str2);
        System.out.println(p);

        //3.
        ois.close();
    }

}
