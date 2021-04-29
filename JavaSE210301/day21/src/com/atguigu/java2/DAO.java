package com.atguigu.java2;

import java.util.List;

/**
 * DAO: data(base) access object
 *
 * @author shkstart
 * @create 16:26
 */
public class DAO<T> {

    //增
    public void add(T t){

    }
    //删
    public T delete(int id){
        return null;
    }

    //改
    public void update(int id,T data){

    }

    //查
    public T getInstance(int id){
        return null;
    }

    public List<T> getForList(){
        return null;
    }


    //泛型方法
    //比如：获取表中的条目数、表中字段的最大值、最小值（最大的生日）等
    public <E> E getValue(){

        return null;
    }


}
