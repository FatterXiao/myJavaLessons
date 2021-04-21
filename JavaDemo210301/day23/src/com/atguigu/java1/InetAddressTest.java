package com.atguigu.java1;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * 一、要想实现网络通信，需要解决的两个问题：
 * 1. 如何准确地定位网络上一台或多台主机；定位主机上的特定的应用
 * 2. 找到主机后如何可靠高效地进行数据传输
 *
 * 二、实现网络传输的两个要素：
 * 要素一：IP地址、端口号
 * 要素二：TCP/IP协议
 *
 * 三、IP地址：使用InetAddress类表示
 *   3.1 IP地址分类方式1：IPV4 和 IPV6
 *      IPV4：4个字节组成，4个0-255。
 *      IPV6：128位（16个字节），写成8个无符号整数，每个整数用四个十六进制位表示，数之间用冒号（：）分开，
 *            如：3ffe:3201:1401:1280:c8ff:fe4d:db39:1984
 *
 *    IP地址分类方式2：公网地址(万维网使用)和私有地址(局域网使用)。
 *              192.168.开头的就是私有址址，范围即为192.168.0.0--192.168.255.255
 *
 *    3.2 本地回路地址：127.0.0.1
 *    3.3 域名
 *     www.atguigu.com   www.baidu.com   www.360.com  www.vip.com
 *     www.mi.com   www.jd.com
 *  四、端口号：标识正在计算机上运行的进程（程序）
 *    > 不同的进程有不同的端口号
 *    > 被规定为一个 16 位的整数 0~65535
 *
 *
 * @author shkstart
 * @create 11:48
 */
public class InetAddressTest {
    public static void main(String[] args) {

        try {
            InetAddress inetAddress = InetAddress.getByName("192.168.13.57");
            System.out.println(inetAddress);

            InetAddress inetAddress1 = InetAddress.getByName("www.atguigu.com");
            System.out.println(inetAddress1);//www.atguigu.com/36.156.81.239

            //常用方法
            //getHostName():获取主机名
            System.out.println(inetAddress1.getHostName());
            //getHostAddress():获取主机地址
            System.out.println(inetAddress1.getHostAddress());

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }
}
