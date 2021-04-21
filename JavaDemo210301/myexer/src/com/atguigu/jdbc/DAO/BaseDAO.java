package com.atguigu.jdbc.DAO;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Mr.Helianthus
 * @create 2021-04-11 10:16 PM
 */
public abstract class BaseDAO {
    private QueryRunner runner = new QueryRunner();

    //通用的增、删、改
    public int update(Connection conn,String sql,Object... args) throws SQLException {
        return runner.update(conn,sql,args);
    }

    // 查询单条数据
    public <T> T getInstance(Connection conn,String sql,Class<T> clazz,Object...params) throws SQLException {
        BeanHandler<T> handler = new BeanHandler<T>(clazz);
        T t = runner.query(conn, sql, handler, params);
        return t;
    }


    // 查询出多条数据
    public <T> List<T> getList(Connection conn, String sql, Class<T> clazz, Object...params) throws SQLException {
        BeanListHandler<T> handler = new BeanListHandler<T>(clazz);
        List<T> t = runner.query(conn, sql, handler, params);
        return t;
    }

    // 查询表中的特殊值
    public <T> T getValue(Connection conn,String sql,Object... params) throws SQLException {
        ScalarHandler handler = new ScalarHandler();
        T value = (T) runner.query(conn, sql, handler, params);
        return value;
    }


}
