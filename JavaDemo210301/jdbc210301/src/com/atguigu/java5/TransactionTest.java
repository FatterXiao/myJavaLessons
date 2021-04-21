package com.atguigu.java5;

import com.atguigu.java1.util.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 1. 一旦断开数据库的连接，数据就会自动提交。
 *
 * 2. 一旦提交了数据，就不可以回滚。
 *
 * 3. 要想数据可以回滚，不能提交数据
 *   ① 保证多个DML操作在同一个连接中
 *   ② 保证DML操作默认执行完以后不能提交数据
 *
 * @author shkstart
 * @create 17:05
 */
public class TransactionTest {

    /*
    * AA向BB转账100
    *
    * update user_table set balance = balance - 100 where user = 'AA'
    *
    * update user_table set balance = balance + 100 where user = 'BB'
    *
    * */
    @Test
    public void test(){

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            //1. 设置数据不要默认提交
            connection.setAutoCommit(false);


            QueryRunner runner = new QueryRunner();
            String sql1 = "update user_table set balance = balance - 100 where user = ?";
            runner.update(connection,sql1,"AA");

           //出现异常了！比如：网络拥堵
            System.out.println(10 / 0);

            String sql2 = "update user_table set balance = balance + 100 where user = ?";
            runner.update(connection,sql2,"BB");

            //2.提交数据
            connection.commit();

        } catch (Exception e) {
            e.printStackTrace();

            //3.
            try {
                if(connection != null)
                    connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        } finally {
            JDBCUtils.closeResouce(connection);
        }



    }

}
