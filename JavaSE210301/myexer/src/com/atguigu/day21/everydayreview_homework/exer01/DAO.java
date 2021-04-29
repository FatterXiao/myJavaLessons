package com.atguigu.day21.everydayreview_homework.exer01;

import java.util.*;

/**
 * 定义个泛型类 DAO<T>，在其中定义一个Map 成员变量，Map 的键为 String 类型，值为 T 类型。
 *
 * 分别创建以下方法：
 * public void save(String id,T entity)： 保存 T 类型的对象到 Map 成员变量中
 * public T get(String id)：从 map 中获取 id 对应的对象
 * public void update(String id,T entity)：替换 map 中key为id的内容,改为 entity 对象
 * public List<T> list()：返回 map 中存放的所有 T 对象
 * public void delete(String id)：删除指定 id 对象
 *
 * 定义一个 User 类：
 * 该类包含：private成员变量（int类型） id，age；（String 类型）name。
 *
 * 定义一个测试类：
 * 创建 DAO 类的对象， 分别调用其 save、get、update、list、delete 方法来操作 User 对象，
 * 使用 Junit 单元测试类进行测试。
 * @author Mr.Helianthus
 * @create 2021-03-30 7:16 PM
 */
public class DAO<T> {
    private Map<String,T> map;

    public DAO() {
        map = new HashMap<>();
    }

    /**
     * 保存 T 类型的对象到 Map 成员变量中
     * @param id
     * @param entity
     */
    public void save(String id,T entity){
        map.put(id,entity);
    }

    /**
     * 从 map 中获取 id 对应的对象
     * @param id
     * @return
     */
    public T get(String id){
        return map.get(id);
    }

    /**
     * 替换 map 中key为id的内容,改为 entity 对象
     * @param id
     * @param entity
     */
    public void update(String id,T entity){
        this.map.put(id,entity);
    }

    /**
     * 返回 map 中存放的所有 T 对象
     * @return
     */
    public List<T> list(){
        Collection<T> values = map.values();
//        List<T> list = new ArrayList<>(values.size()); // 避免扩容
//        Iterator<T> iterator = values.iterator();
//        while(iterator.hasNext()){
//            list.add(iterator.next());
//        }
//
//        // 方式二：
////        list.addAll(values);
//        return list;
        return  new ArrayList<T>(values);
    }

    /**
     * 删除指定 id 对象
     * @param id
     */
    public void delete(String id){
        map.remove(id);
    }
}
