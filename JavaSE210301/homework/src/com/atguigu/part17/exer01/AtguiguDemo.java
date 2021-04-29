package com.atguigu.part17.exer01;

import java.io.Serializable;

/**
 * @author Mr.Helianthus
 * @create 2021-04-12 8:53 PM
 */
public class AtguiguDemo implements Serializable,Comparable {
    private static String school = "尚硅谷";
    public String className;

    public AtguiguDemo() {
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        if( o==null || o.getClass() != this.getClass()){
            return -1;
        }
        AtguiguDemo temp = (AtguiguDemo) o;
        return this.getClassName().compareTo(temp.getClassName());
    }
}
