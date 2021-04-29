package com.atguigu.bookstore.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * 购物车类<br></>
 * 使用BigDecimal来出来金额；<br></>
 * 使用BigDecimal中的（String）构造器
 * @author Mr.Helianthus
 * @create 2021-04-27 2:09 PM
 */
public class Cart implements Serializable {
    private Map<String,CartItem> goods = new LinkedHashMap<>();// 购物车中加入的商品的集合
    private Integer goodsCount;// 购物车中商品的总类型数
    private double totalPrice;// 商品的总价格

    /**
     * 向购物车中添加商品
     * @param book
     */
    public void addGoods(Book book){
        // 1. 按照商品id，从购物车中查找商品
        CartItem cartItem = goods.get(book.getId()+"");
        // - 1.1 购物车中不存在该商品
        if(cartItem == null){
            //创建该图书对应的购物项
            cartItem = new CartItem();
            //将book设置到购物项中
            cartItem.setBook(book);
            //设置该购物项中图书的数量为1
            cartItem.setCount(1);
            //将该购物项添加到购物车中
            goods.put(book.getId()+"",cartItem);
            return;
        }
        // - 1.2 购物车中存在该商品
        int count = cartItem.getCount();
        cartItem.setCount(++count);
    }

    /**
     * 更新购物车中某一类型商品的购买数量
     * @param goodId 商品Id
     * @param number 商品数量
     */
    public void updateGoodsNums(String goodId,String number){
        CartItem cartItem = goods.get(goodId);

        // 转换成功时，更新商品的数量；
        // 失败时，直接异常；防止传入非法参数
        try {
            int i = Integer.parseInt(number);
            cartItem.setCount(i);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }

    /**
     * 移除购物车中某一类型的商品
     * @param goodsId 商品的id
     */
    public void removeGoods(String goodsId){
        goods.remove(goodsId);
    }

    /**
     * 清空购物车
     */
    public void clearCart(){
        goods.clear();
    }


    //获取所有的购物项
    public List<CartItem> getCartItems(){
        Collection<CartItem> values = goods.values();
        return new ArrayList<>(values);
    }

    public Cart() {
    }

    public Cart(Map<String, CartItem> goods, Integer goodsCount, double totalPrice) {
        this.goods = goods;
        this.goodsCount = goodsCount;
        this.totalPrice = totalPrice;
    }

    public Map<String, CartItem> getGoods() {
        return goods;
    }

    public void setGoods(Map<String, CartItem> goods) {
        this.goods = goods;
    }

    /**
     * 获取商品的总数
     * @return
     */
    public Integer getGoodsCount() {
        int total = 0;
        Collection<CartItem> values = goods.values();
        for(CartItem value:values){
            total += value.getCount();
        }
        return total;
    }


    /**
     * 计算购物车的总金额
     * @return
     */
    public double getTotalPrice() {
        BigDecimal goodsPrice = new BigDecimal(0 + "");
        Collection<CartItem> values = goods.values();
        for(CartItem value:values){
            BigDecimal price = new BigDecimal(value.getAmount() + "");// 购买某类图书的总价格
            goodsPrice = goodsPrice.add(price);
        }
        return goodsPrice.doubleValue();
    }



    @Override
    public String toString() {
        return "Cart{" +
                "goods=" + goods +
                ", goodsCount=" + getGoodsCount() +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
