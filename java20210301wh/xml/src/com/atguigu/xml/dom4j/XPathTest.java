package com.atguigu.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.util.List;

public class XPathTest {
    public static void main(String[] args) throws DocumentException {
        //1.创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2.解析XML文件得到Document对象
        Document document = saxReader.read("xml/students.xml");
        //需求：指定获取id属性值为4的student标签
//        Element stuEle = (Element) document.selectSingleNode("//student[@id='4']");
        Element stuEle = (Element) document.selectSingleNode("/students/student[@id='4']");
        //获取id属性
        String id = stuEle.attributeValue("id");
        System.out.println(id);
        //获取name标签中的文本值
        String name = stuEle.elementText("name");
        //获取gender标签中的文本值
        String gender = stuEle.elementText("gender");
        System.out.println(gender);
        //获取age标签中的文本值
        String age = stuEle.elementText("age");
        System.out.println(age);
        //获取address标签中的文本值
        String address = stuEle.elementText("address");
        System.out.println(address);
        //封装Student对象
        Student student = new Student(id, name, age, gender, address);
        System.out.println(student);
    }
}
