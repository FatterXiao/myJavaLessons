package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author shkstart
 * @create 15:42
 */
public class UDPTest {

    @Test
    public void sender() throws IOException {//发送端
        //创建socket的实例
        DatagramSocket socket = new DatagramSocket();
        //封装数据、目的地到数据报中
        byte[] buffer = "hello,I am sender!".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length, InetAddress.getLocalHost(),9090);
        //发送数据报
        socket.send(packet);
        //关闭资源
        socket.close();

    }

    @Test
    public void receiver() throws IOException {//接收端
        //创建socket的实例
        DatagramSocket socket = new DatagramSocket(9090);
        //封装一个数据报
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);
        //接收数据到数据报中
        socket.receive(packet);
        //读取数据并显示到控制台上
        String str = new String(packet.getData(),0,packet.getLength());
        System.out.println(str);
        //关闭资源
        socket.close();
    }
}
