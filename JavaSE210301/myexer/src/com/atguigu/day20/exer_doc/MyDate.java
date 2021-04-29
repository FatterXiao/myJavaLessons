package com.atguigu.day20.exer_doc;

import java.util.Objects;

/**
 * @author Mr.Helianthus
 * @create 2021-03-29 4:59 PM
 */
public class MyDate implements Comparable{
    private int year;
    private int month;
    private int day;

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MyDate myDate = (MyDate) o;
        return year == myDate.year &&
                month == myDate.month &&
                day == myDate.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(year, month, day);
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }
        if(this.getClass() != o.getClass() || o == null){
            return -1;
        }
        MyDate emp = (MyDate)o;
        if((this.getYear()-emp.getYear() == 0)&&(this.getMonth()-emp.getMonth()==0)&&(this.getDay()-emp.getDay()==0)){
            return -1;
        }
        return 1;
    }
}
