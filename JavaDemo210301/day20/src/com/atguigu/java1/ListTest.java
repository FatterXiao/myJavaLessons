package com.atguigu.java1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**一、
 * java.util.Collection:存储一个一个的数据
 *  *      |----java.util.List:存储有序的、可重复的数据。  ----> “动态”数组
 *  *              |---- ArrayList : List的主要实现类；线程不安全的，效率高；底层使用Object[]存储
 *                 |---- LinkedList ：对于频繁的插入、删除操作，效率高，建议使用此类；底层使用双向链表存储
 *                 |---- Vector : List的古老实现类；线程安全的，效率低；底层使用Object[]存储
 *  *      |----java.util.Set:存储无序的、不可重复的数据   ----> 高中学的"集合"
 *  *              |---- HashSet \ LinkedHashSet \TreeSet
 *
 *
 * 二、面试题：区分ArrayList、LinkedList、Vector
 *
 * 三、数据结构：① 数据的逻辑关系？ ② 数据的存储结构： 顺序表(数组)、链表 ； ADT(abtract data tye):栈、队列、树、图
 *
 *      顺序表：尾部添加、查询、修改的效率高O(1)，插入、删除操作的效率低O(n)
 *      链表:插入、删除操作的效率高O(1),尾部添加、查询、修改的效率低O(n)
 *
 * 四、（对应着集合内容对大家要求的层次三）
 *  4.1 ArrayList 的底层源码：
 *  在jdk7中：
 *  ArrayList list = new ArrayList();// 底层创建了长度为10的Object[] elementData
 *
 *  list.add(128);//elementData[0] = new Integer(128);
 *  ...
 *  当要存储第11个元素时，需要扩容，默认为原来的1.5倍，并将原有的元素复制到新的数组中。
 *  ...
 *  在jdk8中：
 *  ArrayList list = new ArrayList();//底层的Object[] elementData初始化为{}
 *  list.add(128); //首次添加一个元素，elementData重新初始化为长度为10的数组，并elementData[0] = new Integer(128);
 *  ...
 *  当要存储第11个元素时，需要扩容，默认为原来的1.5倍，并将原有的元素复制到新的数组中。
 *  ...
 *
 * 4.2 Vector的底层源码：
 * 在jdk7和jdk8中是相同的操作：
 * Vector vec = new Vector();//底层创建了长度为10的Object[] elementData
 * vec.add(128);//elementData[0] = new Integer(128);
 * ....
 * 当要存储第11个元素时，需要扩容，默认为原来的2倍，并将原有的元素复制到新的数组中。
 * ....
 *
 * 4.3 LinkedList的底层源码：
 *
 * LinkedList list = new LinkedList();
 * list.add(128);//
 * ...
 * 不断的添加即可，不涉及扩容的问题。
 *
 * 证明底层是双向链表：
 *   private static class Node<E> {
 *         E item;
 *         Node<E> next;
 *         Node<E> prev;
 *
 *         Node(Node<E> prev, E element, Node<E> next) {
 *             this.item = element;
 *             this.next = next;
 *             this.prev = prev;
 *         }
 *     }
 *
 *
 * 五、启示：
 * 1. 如果开发中要使用ArrayList,在大体清楚元素个数情况下，建议使用
 *    ArrayList(int capacity)
 * 2. 对于频繁的插入、删除操作，建议使用LinkedList
 *
 * @author shkstart
 * @create 10:31
 */
public class ListTest {
    /*
    void add(int index, Object ele):在index位置插入ele元素
    boolean addAll(int index, Collection eles):从index位置开始将eles中的所有元素添加进来
    Object get(int index):获取指定index位置的元素
    int indexOf(Object obj):返回obj在集合中首次出现的位置
    int lastIndexOf(Object obj):返回obj在当前集合中末次出现的位置
    Object remove(int index):移除指定index位置的元素，并返回此元素
    Object set(int index, Object ele):设置指定index位置的元素为ele
    List subList(int fromIndex, int toIndex):返回从fromIndex到toIndex位置的子集合

    总结：
    增：add(Object obj)
    删：remove(Object obj) / remove(int index)
    改：set(int index, Object ele)
    查：get(int index)
    插：add(int index, Object ele)
    长度：size()
    遍历：使用Iterator、增强for、一般的for

     */
    @Test
    public void test1(){
        List list = new ArrayList();
        list.add(1);//自动装箱
        list.add("AA");

        list.remove(new Integer(1));

        System.out.println(list);


    }
    @Test
    public void test2(){
        List list = new ArrayList();
        list.add(1);//自动装箱
        list.add("AA");
        list.add("BB");
        list.add("MM");
        //遍历方式1：
        for(int i = 0; i < list.size();i++){
            System.out.println(list.get(i));
        }
        //遍历方式2：
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //遍历方式3：
        for(Object obj : list){
            System.out.println(obj);
        }
    }

}
