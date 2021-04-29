package com.atguigu.java1;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * URL: 统一资源定位符，它表示 Internet 上某一资源的地址。
 *
 * 比如：http://192.168.13.136:8080/examples/wbb.png?keyword=apple
 *      协议    ip地址         端口号  资源地址        参数列表
 *
 *
 * @author shkstart
 * @create 16:18
 */
public class URLTest {

    public static void main(String[] args) {
        try {

            URL url = new URL("http://192.168.13.136:8080/examples/wbb.png?keyword=apple");
//            public String getProtocol(  )     获取该URL的协议名
//            public String getHost(  )           获取该URL的主机名
//            public String getPort(  )            获取该URL的端口号
//            public String getPath(  )           获取该URL的文件路径
//            public String getFile(  )             获取该URL的文件名
//            public String getQuery(   )        获取该URL的查询名

            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());

        } catch (MalformedURLException e) {
            e.printStackTrace();

        }


    }

}
