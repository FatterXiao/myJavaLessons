package com.atguigu.bookstore.beans;

import java.util.List;

/**
 * 封装分页时所用的信息
 * @author Mr.Helianthus
 * @create 2021-04-25 9:40 AM
 */
public class Page<T> {
    /**
     * 每页信息显示的条数
     */
    public static final int PAGE_SIZE = 5;
    /**
     * 该页面所需要显示的所有信息
     */
    private List<T> dataList;

    /**
     * 查询的记录总数
     */
    private long totalRecords;

    /**
     * 当前页码
     */
    private  int pageNo;

    /**
     * 总页数
     */
    private long totalNos;

    public static int getPageSize() {
        return PAGE_SIZE;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public long getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(long totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getPageNo() {
        if(pageNo < 1){
            return 1;
        }

        if(pageNo > this.getTotalNos()){
            return (int) this.getTotalNos();
        }

        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public long getTotalNos() {
        long total = this.totalRecords / PAGE_SIZE;
        if(this.totalRecords % PAGE_SIZE != 0){
            total++;
        }
        return total;
    }


}
