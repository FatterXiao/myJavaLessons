package com.atguigu.day12.part07ppt.exer02;

import java.util.Objects;

public class Order {
    private int orderId;
    private String orderName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        Order order = (Order) obj;
        return orderId == order.orderId &&
                this.orderName.equals(order.orderName);
    }
}
