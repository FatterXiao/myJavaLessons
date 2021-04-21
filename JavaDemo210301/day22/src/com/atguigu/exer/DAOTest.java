package com.atguigu.exer;

import java.util.List;

/**
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 *
 *
 *
 *
 * @author shkstart
 * @create 9:34
 */
public class DAOTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<User>();

        dao.save("1",new User(1001,32,"周杰伦"));
        dao.save("2",new User(1002,22,"昆凌"));

        dao.update("2",new User(1003,25,"蔡依林"));

        List<User> list = dao.list();
        System.out.println(list);

    }
}
