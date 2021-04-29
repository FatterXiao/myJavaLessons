package com.atguigu.java3.dao;

import com.atguigu.java2.javabean.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 通用的针对于数据表的CRUD操作
 *
 * @author shkstart
 * @create 16:15
 */
public class BaseDAO {
    private QueryRunner runner = new QueryRunner();

    //通用的增删改操作
    public int update(Connection conn,String sql,Object ... objs) throws SQLException {
        return runner.update(conn,sql,objs);
    }

    //查询操作1:查询表中的一条记录，以一个对象的方式返回
    public <T> T getInstance(Connection conn,String sql,Class<T> clazz,Object ... objs) throws SQLException {
        BeanHandler<T> handler = new BeanHandler<T>(clazz);
        T t = runner.query(conn, sql, handler, objs);
        return t;
    }

    //查询操作2:查询表中的多条记录，以多个对象构成的集合的方式返回
    public <T> List<T> getList(Connection conn, String sql, Class<T> clazz, Object ... objs) throws SQLException {
        BeanListHandler<T> handler = new BeanListHandler<T>(clazz);
        List<T> list = runner.query(conn, sql, handler, objs);
        return list;
    }

    //查询操作3：查询表中的特殊值
    public <T> T getValue(Connection connection,String sql,Object ... objs) throws SQLException {
        ScalarHandler handler = new ScalarHandler();
        T value = (T) runner.query(connection, sql, handler, objs);
        return value;
    }

}
