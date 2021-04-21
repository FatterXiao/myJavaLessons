package com.atguigu.java1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author shkstart
 * @create 16:25
 */
public class URLTest1 {

    public static void main(String[] args) {


        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("http://192.168.13.136:8080/examples/wbb1.png");

            urlConnection = (HttpURLConnection) url.openConnection();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream(new File("wbb.png"));
            byte[] buffer = new byte[1024];
            int len;
            while ((len = is.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            System.out.println("下载完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (urlConnection != null)
                urlConnection.disconnect();//断开连接
        }


    }
}
