package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 一、框架
 *  java.util.Map:存储一对一对的数据 (key-value) ----> 高中学的"函数" y = f(x)   y = 2 * x + 1 (x1,y1),(x2,y2)
 *       |---- HashMap:Map的主要实现类；线程不安全、效率高；可以存储null的key和value;底层使用Entry[](或Node[])
 *              |---- LinkedHashMap:HashMap的子类，可以实现按照添加的顺序实现遍历操作。对于频繁的遍历，建议使用此类。
 *                                  此类实际上是在HashMap结构的基础上，给每一个Node元素添加了一对指针，指向其前一个和后一个元素。
 *       |---- TreeMap：可以按照添加的元素node的key的指定的属性的大小顺序实现遍历操作。使用红黑树实现的数据存储。
 *       |---- Hashtable： Map的古老实现类；线程安全，效率低；不可以存储null的key或value;底层使用Entry[](或Node[])
 *              |---- Properties：是Hashtable的子类，主要用来处理属性文件的。其key和value都是String类型。
 *
 *
 *  "大处着眼，小处着手"
 *
 *   class Person{
 *       String name;
 *       int age;
 *
 *   }
 *
 *   Person p1 = new Person("Tom",12);
 *
 *   Map map = new HashMap();
 *   map.put("name","Tom");
 *   map.put("age",12);
 *
 *   二、
 *   面试题：HashMap与Hashtable的区别
 *
 *   三、
 *   HashMap的底层源码分析：
 *   jdk7的实现:
 *   HashMap map = new HashMap(); //底层创建了一个长度为16的Entry[] table
 *   ....
 *   map.put(key1,value1);//添加一个key1-value1。 key1,value1封装为entry对象的两个属性，将entry对象放到数组table中。具体
 *   应该放在table中的哪个位置呢？具体过程为：
 *
 *   1. 调用key1所属类的hashCode(),计算出key1的哈希值1，此哈希值1经过某个算法（hash()）之后，得到哈希值2。此哈希值2就决定了key1-value1
 *   封装为的entry1在数组table中的位置。假设此位置为索引i。
 *   2. 如果table[i]位置上没有其他元素，则key1-value1封装的entry1直接添加成功。
 *      如果table[i]位置上有其他元素，比如只有一对key2-value2封装的entry2。此时需要继续比较：
 *          3.  比较key1和key2的哈希值，判断此哈希值是否相等：
 *                 3.1 两个哈希值不相等，则认为key1和key2就不相同。则key1-value1封装的entry1添加成功。此时entry1和entry2以链表方式存储。
 *                      jdk7中将entry1放到table[i]中，通过单向链表指向entry2
 *                 3.2 两个哈希值相等，则需要继续调用key1所在类的equals()。
 *                      3.2.1 如果equals()返回true,则认为key1和key2相同，则默认情况下，value1替换旧的value2
 *                      3.2.2 如果equals()返回false，则认为key1和key2不相同。则key1-value1封装的entry1添加成功。此时entry1和entry2以链表方式存储。
 *                         jdk7中将entry1放到table[i]中，通过单向链表指向entry2
 *
 *
 *    在不断put添加的过程中，需要考虑扩容。默认扩容为原来的2倍。
 *    什么时候扩容呢？默认情况下：数组的长度 * LOAD_FACTOR (默认值是0,75)
 *
 *
 *  jdk8相较于jdk7的区别：
 *  1. HashMap map = new HashMap();//底层没有创建长度为16的数组。
 *  2. 底层数组的类型调整为Node[],而非Entry[]
 *  3. 在首次调用put()方法时，底层才开始创建长度为16的数组
 *  4. jdk7中索引i位置如果有多个元素，构成的链表的特点与jdk8中的不同。
 *    “七上八下”
 *  5. jdk8中如果数组索引i位置上的链表的长度大于8且数组的长度大于64时，此索引i位置上的元素都要调整为红黑树的数据结构进行存储。
 *
 *
 *  说明：
 *  1. 要求向HashMap中添加的key-value中key所在的类一定要重写:equals()\hashCode()
 *
 *
 *  四、LinkedHashMap在HashMap的基础上，针对于Node增加了一对指针。证明：
 *  在LinkedHashMap中定义了Entry结构如下：
 *    static class Entry<K,V> extends HashMap.Node<K,V> {
 *         Entry<K,V> before, after;
 *         Entry(int hash, K key, V value, Node<K,V> next) {
 *             super(hash, key, value, next);
 *         }
 *     }
 *
 * @author shkstart
 * @create 16:04
 */
public class MapTest {

    @Test
    public void test1(){
        HashMap map = new HashMap();

        map.put("Tom",67);
        map.put(56,"AA");
        map.put(null,"AA");
        map.put(67,null);
        map.put("Tim",78);

        System.out.println(map);
    }

    @Test
    public void test2(){
        Hashtable map = new Hashtable();
//        map.put(null,123);
//        map.put("AA",null);
    }

    @Test
    public void test3(){
        HashMap map = new LinkedHashMap();

        map.put("Tom",67);
        map.put(56,"AA");
        map.put(null,"AA");
        map.put(67,null);
        map.put("Tim",78);

        System.out.println(map);
    }

}
