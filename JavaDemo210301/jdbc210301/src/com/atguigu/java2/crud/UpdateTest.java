package com.atguigu.java2.crud;

import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 在获取了数据库的连接之后，就可以针对数据库下的相应的表进行CRUD操作。
 *
 * 下面测试增加、删除、修改的操作
 *
 * @author shkstart
 * @create 11:36
 */
public class UpdateTest {

    //使用QueryRunner之前，需要导入commons-dbutils-1.6.jar
    //测试向customers表中添加一条记录
    @Test
    public void test1(){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            //获取数据库的连接
            connection = JDBCUtils.getConnection();
            //提供一条添加数据的sql语句
            String sql = "INSERT INTO customers(name,email,birth) values('杨俊','yangj@126.com','1996-09-09')";
            //执行添加操作
            int count = runner.update(connection,sql);
            System.out.println("添加了" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }
    //测试向customers表中删除一条记录
    @Test
    public void test2(){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            //获取数据库的连接
            connection = JDBCUtils.getConnection();
            //提供一条删除数据的sql语句
            String sql = "delete from customers where id >= 19";
            //执行添加操作
            int count = runner.update(connection,sql);
            System.out.println("删除了" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }

    //测试向customers表中删除一条记录
    @Test
    public void test3(){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            //获取数据库的连接
            connection = JDBCUtils.getConnection();
            //提供一条删除数据的sql语句
            String sql = "delete from customers where id = ?";
            //update的参数3：填充占位符
            //执行添加操作
            int count = runner.update(connection,sql,18);
            System.out.println("删除了" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }

    @Test
    public void test4(){
        Connection connection = null;
        try {
            QueryRunner runner = new QueryRunner();
            //获取数据库的连接
            connection = JDBCUtils.getConnection();
            //提供一条添加数据的sql语句
            String sql = "INSERT INTO customers(name,email,birth) values(?,?,?)";
            //执行添加操作
            int count = runner.update(connection,sql,"Tom","tom@126.com","2000-09-09");
            System.out.println("添加了" + count + "条记录");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.closeResouce(connection);
        }
    }

}
