package com.atguigu.day17.exer;

public class Goods implements Comparable{
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    /**
     * 按照商品的价格排序
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        }

        if(this.getClass() != o.getClass()){
            throw new RuntimeException("输入类型错误");
        }
        Goods g1 = (Goods)o;
        return Double.compare(this.getPrice(),g1.getPrice());
    }
}
