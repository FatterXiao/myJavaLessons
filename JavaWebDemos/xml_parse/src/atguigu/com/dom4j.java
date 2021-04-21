package atguigu.com;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-17 10:17 AM
 */
public class dom4j {
    public static void main(String[] args) throws DocumentException {
        // 读取xml文件
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read("xml_parse/students.xml");
        // 获取根节点
        Element rootElement = document.getRootElement();
        List<Element> students = rootElement.elements("student");
        for(Element student:students){
            String id = student.attributeValue("id");
            String age = student.elementText("age");
            String gender = student.elementText("gender");
            String name = student.elementText("name");
            String address = student.elementText("address");

            Student studentTemp = new Student(id, name, age, gender, address);
            System.out.println(studentTemp);
        }

    }
}
