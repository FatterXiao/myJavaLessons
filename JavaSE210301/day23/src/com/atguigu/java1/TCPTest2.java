package com.atguigu.java1;

import com.sun.deploy.trace.SocketTraceListener;
import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 例题2.客户端发送文件给服务端，服务端将文件保存在本地。
 *
 * @author shkstart
 * @create 15:16
 */
public class TCPTest2 {

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

        //4.关闭资源
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
        FileOutputStream fos = new FileOutputStream(new File("yangm4.png"));
        //4. 数据的读取和写出的过程
        byte[] buffer = new byte[1024];
        int len;
        while((len = is.read(buffer)) != -1){
            fos.write(buffer,0,len);
        }
        //5. 关闭资源
        fos.close();
        is.close();
        socket.close();

        serverSocket.close();

    }

}
