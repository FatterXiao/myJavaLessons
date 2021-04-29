package com.atguigu.bookstore.beans;

import jdk.nashorn.internal.ir.CatchNode;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

//购物车类
public class Cart implements Serializable {
    //map的key是图书的id，map的value是每个购物项
    private Map<String , CartItem> map = new LinkedHashMap<>();
    private int totalCount; //购物车中图书的总数量，通过计算得到
    private double totalAmount; //购物车中图书的总金额，通过计算得到


    //添加图书到购物车的方法
    public void addBook2Cart(Book book){
        //根据图书的id从购物车中查询对应的购物项
        CartItem cartItem = map.get(book.getId() + "");
        //判断cartItem是否为null
        if(cartItem == null){
            //证明购物车中还没有该购物项
            //创建该图书对应的购物项
            cartItem = new CartItem();
            //将book设置到购物项中
            cartItem.setBook(book);
            //设置该购物项中图书的数量为1
            cartItem.setCount(1);
            //将该购物项添加到购物车中
            map.put(book.getId()+"",cartItem);
        }else{
            //证明购物车中已经有该购物项，此时只需要将该购物项中图书的数量加1即可
            //获取当前购物项中图书的数量
            int count = cartItem.getCount();
            //将数量加1
            cartItem.setCount(count+1);
        }
    }

    //更新购物项的方法
    public void updateCartItem(String bookId , String bookCount){
        //根据图书的id获取对应的购物项
        CartItem cartItem = map.get(bookId);
        try {
            //转换成功则设置购物项中图书的数量
            int intCount = Integer.parseInt(bookCount);
            if(intCount > 0){
                //更新购物项中图书的数量
                cartItem.setCount(intCount);
            }
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }

    //删除购物项的方法
    public void deleteCartItem(String bookId){
        map.remove(bookId);
    }

    //清空购物车的方法
    public void clearCart(){
        map.clear();
    }

    //获取所以的购物项的方法
    public List<CartItem> getCartItems(){
        Collection<CartItem> values = map.values();
        return new ArrayList<>(values);
    }

    public Cart() {
    }

    public Cart(Map<String, CartItem> map, int totalCount, double totalAmount) {
        this.map = map;
        this.totalCount = totalCount;
        this.totalAmount = totalAmount;
    }

    public Map<String, CartItem> getMap() {
        return map;
    }

    public void setMap(Map<String, CartItem> map) {
        this.map = map;
    }

    //购物车中图书的总数量是每个购物项的数量之和
    public int getTotalCount() {
        int totalCount = 0;
        //获取所有的购物项
        List<CartItem> cartItems = getCartItems();
        for (CartItem cartItem : cartItems) {
            //获取购物项中的图书的数量
            int count = cartItem.getCount();
            totalCount = totalCount + count;
        }
        return totalCount;
    }

//    public void setTotalCount(int totalCount) {
//        this.totalCount = totalCount;
//    }

    //购物车中图书的总金额是每个购物项的金额小计之和
    public double getTotalAmount() {
//        double totalAmount = 0;
        BigDecimal bigTotalAmount = new BigDecimal("0");
        //获取所有的购物项
        List<CartItem> cartItems = getCartItems();
        for (CartItem cartItem : cartItems) {
            //获取购物项中的图书的金额小计
            double amount = cartItem.getAmount();
            BigDecimal bigAmount= new BigDecimal(amount + "");
//            totalAmount = totalAmount + amount;
            bigTotalAmount = bigTotalAmount.add(bigAmount);
        }
        return bigTotalAmount.doubleValue();
    }

//    public void setTotalAmount(double totalAmount) {
//        this.totalAmount = totalAmount;
//    }

    @Override
    public String toString() {
        return "Cart{" +
                "map=" + map +
                ", totalCount=" + totalCount +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
