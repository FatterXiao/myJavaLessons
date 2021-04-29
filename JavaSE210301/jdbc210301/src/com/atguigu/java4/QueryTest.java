package com.atguigu.java4;

import com.atguigu.java1.util.JDBCUtils;
import com.atguigu.java2.javabean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.junit.Test;

import java.sql.Connection;

/**
 * 当表中的字段名与类中的属性名不同时，为了能够正确给类的对象的属性赋值。需要sql中以类中属性的名作为表中字段的别名出现。
 *
 * @author shkstart
 * @create 16:57
 */
public class QueryTest {
    @Test
    public void test1() {
        Connection connection = null;

        try {
            //1. 获取数据库的连接
            connection = JDBCUtils.getConnection();
            //2. 创建QueryRunner的实例
            QueryRunner runner = new QueryRunner();

            //3. 调用query()方法
            String sql = "SELECT order_id orderId,order_name orderName,order_date orderDate FROM `order` WHERE order_id = ?";
            //创建一个ResultSetHandler实现类的对象
            ResultSetHandler<Order> handler = new BeanHandler<>(Order.class);
            Order order = runner.query(connection, sql, handler, 1);
            System.out.println(order);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //4. 关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }
}
