package com.atguigu.part8.interface_exers.exer05;

public class Receptionist {
    private Filter filter;

    public Receptionist(Filter filter) {
        this.filter = filter;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public void recept(User u){
        if(u.getUserType() != null){
            return ;
        }
        filter.filterUser(u);
    }
}
