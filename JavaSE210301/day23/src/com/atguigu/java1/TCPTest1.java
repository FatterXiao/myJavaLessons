package com.atguigu.java1;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 例题1：客户端发送内容给服务端，服务端将内容打印到控制台上。
 *
 * @author shkstart
 * @create 14:47
 */
public class TCPTest1 {
    @Test
    public void client()  { //客户端
        Socket socket = null;
        OutputStream os = null;
        try {
            //1. 封装Socket对象
            //1.1 指名对方的ip地址
            InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
            //1.2 指名对方的端口号
            int port = 8989;

            socket = new Socket(inetAddress,port);
            //2. 通过socket获取输出流，并写出数据
            os = socket.getOutputStream();
            os.write("你好，我是客户端".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3. 关闭相应的资源
            try {
                if(os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }



    }

    @Test
    public void server()  { //服务器端
        ServerSocket serverSocket = null;
        Socket socket = null;//accept():是一个阻塞式的方法。
        InputStream is = null;
        try {
            //1. 封装ServerSocket的对象
            int port = 8989;
            serverSocket = new ServerSocket(port);
            //2. 接收来自于客户端的socket
            socket = serverSocket.accept();

            //3. 获取客户端发送过来的流数据
            is = socket.getInputStream();
            byte[] buffer = new byte[1024];
            int len;
            while((len = is.read(buffer)) != -1){
                String str = new String(buffer,0,len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //通常服务器端不会关闭
            try {
                if(serverSocket != null)
                    serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
