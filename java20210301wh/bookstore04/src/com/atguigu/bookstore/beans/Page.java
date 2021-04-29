package com.atguigu.bookstore.beans;

import java.util.List;
//分页的类
public class Page<T> {
    private List<T> list; //每页中查询到的数据存放的集合
    private static final int PAGE_SIZE = 5; //每页显示的记录数
    private int pageNo; //当前页，需要用户提交
    private int totalPageNo; //总页数，通过计算得到
    private int totalRecord; //总记录数，通过查询数据库得到

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public static int getPageSize() {
        return PAGE_SIZE;
    }

    public int getPageNo() {
        //如果当前页码小于1，则返回1
        if(pageNo < 1){
            return 1;
        //如果当前页码大于总页数，则返回总页数
        }else if(pageNo > getTotalPageNo()){
            return getTotalPageNo();
        }else{
            //如果当前页码大于等于1，小于等于总页数，则返回当前页码
            return pageNo;
        }
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    //总页数由总记录数和每页显示的条数计算得到
    public int getTotalPageNo() {
        //如果总记录数能除尽PAGESIZE，则总页数是它们的商
        if(totalRecord % PAGE_SIZE == 0){
            return totalRecord / PAGE_SIZE;
        }else{
            //如果总记录数不能除尽PAGESIZE，则总页数是它们的商加一
            return totalRecord / PAGE_SIZE + 1;
        }
    }

      //总页数是通过计算得到，不需要我们手动设置
//    public void setTotalPageNo(int totalPageNo) {
//        this.totalPageNo = totalPageNo;
//    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    @Override
    public String toString() {
        return "Page{" +
                "list=" + list +
                ", pageNo=" + pageNo +
                ", totalPageNo=" + totalPageNo +
                ", totalRecord=" + totalRecord +
                '}';
    }
}
