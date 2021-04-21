package com.atguigu.xml.dom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        //1.创建解析器对象
        SAXReader saxReader = new SAXReader();
        //2.解析XML文件得到Document对象
        Document document = saxReader.read("xml/students.xml");
        //3.获取根标签
        Element rootElement = document.getRootElement();
        //4.获取跟标签下所有的子标签student
        List<Element> stus = rootElement.elements("student");
        //5.遍历得到每一个student标签
        for (Element stu : stus) {
            //获取id属性值
            String id = stu.attributeValue("id");
            System.out.println(id);
            //获取name标签
//            Element nameEle = stu.element("name");
            //获取name标签中的文本值
//            String name = nameEle.getText();
            //获取name标签中的文本值
            String name = stu.elementText("name");
            System.out.println(name);
            //获取gender标签中的文本值
            String gender = stu.elementText("gender");
            System.out.println(gender);
            //获取age标签中的文本值
            String age = stu.elementText("age");
            System.out.println(age);
            //获取address标签中的文本值
            String address = stu.elementText("address");
            System.out.println(address);
            //封装Student对象
            Student student = new Student(id, name, age, gender, address);
            System.out.println(student);
        }
    }
}
