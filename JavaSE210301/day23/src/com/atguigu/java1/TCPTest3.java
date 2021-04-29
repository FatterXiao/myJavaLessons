package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 例题3.从客户端发送文件给服务端，服务端保存到本地。并返回“发送成功”给客户端。并关闭相应的连接。
 *
 * @author shkstart
 * @create 15:27
 */
public class TCPTest3 {

    //注意：异常的处理还是应该使用try-catch-finally
    @Test
    public void client() throws IOException {
        //1. 创建Socket
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 8989);
        //2. 提供输入流、输出流
        FileInputStream fis = new FileInputStream(new File("yangm.png"));
        OutputStream os = socket.getOutputStream();
        //3. 读取和写出的过程
        byte[] buffer = new byte[1024];
        int len;
        while((len = fis.read(buffer)) != -1){
            os.write(buffer,0,len);
        }

        System.out.println("图片发送完成");
        //显式执行数据发送完成，告知服务器端
        socket.shutdownOutput();

        //4.接收来自于服务器端的数据
        InputStream is = socket.getInputStream();
        byte[] newBuffer = new byte[1024];
        int newLen;
        while((newLen = is.read(newBuffer)) != -1){
            String str = new String(newBuffer,0,newLen);
            System.out.print(str);
        }

        //5.关闭资源
        os.close();
        fis.close();
        socket.close();

    }

    @Test
    public void server() throws IOException {

        //1. 创建ServerSocket
        ServerSocket serverSocket = new ServerSocket(8989);
        //2. 通过ServerSocket，接收来自于客户端的socket
        Socket socket = serverSocket.accept();

        System.out.println("接收到了来自于" + socket.getInetAddress().getHostAddress() + "的数据");

        //3. 创建输入流、输出流
        InputStream is = socket.getInputStream();
        FileOutputStream fos = new FileOutputStream(new File("yangm7.png"));
        //4. 数据的读取和写出的过程
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }

        System.out.println("Server:图片接收完成");

        //5.服务器端发送“接收成功"给客户端
        OutputStream os = socket.getOutputStream();
        os.write("接收成功".getBytes());

        //6. 关闭资源
        fos.close();
        is.close();
        socket.close();

        serverSocket.close();

    }
}
