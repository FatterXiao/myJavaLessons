package com.atguigu.java1;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 *
 * 1. File类及后续的各种流都声明在java.io 包下
 * 2. File类的对象代表一个文件(.java，.mp3，.doc ，.txt，.avi )或文件目录
 * 3. File通常都是作为IO流的端点出现的。从代码上看，将File类的对象作为参数传递到IO流的构造器中。
 * 4. File类中涉及到文件或文件目录的新建、路径名、大小、删除等操作。具体读取文件内容的行为，File
 *   是无能为力的，必须使用流来操作。
 *
 * @author shkstart
 * @create 10:10
 */
public class FileTest {
    /*
    * File类的实例化
    * public File(String pathname)
    *
    * public File(String parent,String child)
        以parent为父路径，child为子路径创建File对象。
    *
    * public File(File parent,String child)
        根据一个父File对象和子文件路径创建File对象

        *文件（或文件目录）的路径
        * 绝对路径：包含盘符在内的文件或文件目录的完整路径。比如：C:\Program Files (x86)\Bonjour\abc.txt
        * 相对路径：通常都是相较于当前工程或当前module
        *
    * */
//    String str = "我是一个\"好\"人";
//    System.out.println(str);
    @Test
    public void test1(){
        //表示文件
        File file1 = new File("hello.txt");
        File file2 = new File("abc/nello.txt");
        //表示文件目录
        File file3 = new File("C:\\Program Files (x86)\\Bonjour");

        //File(String parent,String child)
        File file4 = new File("C:\\Program Files (x86)\\Bonjour","abc.txt");

        //public File(File parent,String child)
        File file5 = new File(file3,"abc.txt");

    }

    /**
     * File类的获取功能
     * public String getAbsolutePath()：获取绝对路径
     * public File getAbsoluteFile()：获取绝对路径表示的文件
     * public String getPath() ：获取路径
     * public String getName() ：获取名称
     * public String getParent()：获取上层文件目录路径。若无，返回null
     * public long length() ：获取文件长度（即：字节数）。不能获取目录的长度。
     * public long lastModified() ：获取最后一次的修改时间，毫秒值
     *

     */

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        file1 = new File("d:\\io\\hello.txt");
        file1 = new File("d:\\io");
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getAbsoluteFile());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println(file1.getAbsoluteFile().getParent());
    }

    //练习：创建一个与hello.txt文件在相同文件目录下的另一个名为abc.txt文件
    @Test
    public void test3(){
        File file1 = new File("hello.txt");

        //File(String parent,String child)
        File dest = new File(file1.getAbsoluteFile().getParent(),"abc.txt");
    }

   /* public String[] list() ：获取指定目录下的所有文件或者文件目录的名称数组
     * public File[] listFiles() ：获取指定目录下的所有文件或者文件目录的File数组
    */
   @Test
   public void test4(){
       File file1 = new File("D:\\code210301");
       File[] files = file1.listFiles();
       for(File f : files){
           System.out.println(f);
       }
   }
   /*
   * public boolean isDirectory()：判断是否是文件目录
    public boolean isFile() ：判断是否是文件
    public boolean exists() ：判断是否存在
    public boolean canRead() ：判断是否可读
    public boolean canWrite() ：判断是否可写
    public boolean isHidden() ：判断是否隐藏

   * */
   @Test
   public void test5(){
       File file1 = new File("D:\\code210301");
       file1 = new File("d:\\io\\hello.txt");
       System.out.println(file1.isDirectory());
       System.out.println(file1.isFile());
       System.out.println(file1.exists());//磁盘中是否存在此文件或文件目录
       System.out.println(file1.canRead());
       System.out.println(file1.canWrite());
       System.out.println(file1.isHidden());
   }

   //思考：如何遍历一个文件目录下的所有的文件
    @Test
    public void test6(){
        File file = new File("D:\\code210301");
        printFileName(file);
    }
    public void printFileName(File file){
        if(file.isFile()){
            System.out.println(file.getAbsolutePath());
        }else{
            File[] files = file.listFiles();
            for(File f : files){
                printFileName(f);
            }

        }
    }

    //思考1：获取指定文件目录的大小
    //思考2：删除指定的文件目录

    /*
    *   public boolean createNewFile() ：创建文件。若文件存在，则不创建，返回false
        public boolean mkdir() ：创建文件目录。如果此文件目录存在，就不创建了。如果此文件目录的上层目录不存在，也不创建。
        public boolean mkdirs() ：创建文件目录。如果上层文件目录不存在，一并创建

        * public boolean delete()：删除文件或者文件夹
    * */
    @Test
    public void test7() throws IOException {
        File file1 = new File("d:\\io\\abc.txt");

        if(!file1.exists()){//若文件不存在
            System.out.println(file1.createNewFile()? "创建成功" : "创建失败");
        }else{//若文件存在
            System.out.println(file1.delete()? "删除成功":"删除失败");
        }
    }

    @Test
    public void test8(){
        //mkdir():如果要创建的文件目录已存在，则创建失败。
        //        如果要创建的文件目录的上层目录不存在，则创建失败。
        File file1 = new File("d:\\io\\io2\\io3");

//        System.out.println(file1.mkdir()? "创建成功" : "创建失败");
        //mkdirs():如果要创建的文件目录的上层目录不存在，则一并创建
        //         如果要创建的文件目录已存在，则创建失败。
        System.out.println(file1.mkdirs()? "创建成功" : "创建失败");

        file1.delete();

    }
}
