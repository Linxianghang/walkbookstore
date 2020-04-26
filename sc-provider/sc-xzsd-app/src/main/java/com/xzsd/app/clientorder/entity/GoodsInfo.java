package com.xzsd.app.clientorder.entity;

/**
 * 返回值中goodsList类
 */
public class GoodsInfo {
    /**
     * 商品名称
     */
    private String  goodsName;
    /**
     * 商品图片路径
     */
    private String goodsImagePath;
    /**
     * 商品介绍
     */
    private String goodsDescribe;
    /**
     * 商品价格
     */
    private String goodsPrice;
    /**
     * 商品数量（至少为1）
     */
     private int cartGoodsCount;

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsImagePath() {
        return goodsImagePath;
    }

    public void setGoodsImagePath(String goodsImagePath) {
        this.goodsImagePath = goodsImagePath;
    }

    public String getGoodsDescribe() {
        return goodsDescribe;
    }

    public void setGoodsDescribe(String goodsDescribe) {
        this.goodsDescribe = goodsDescribe;
    }

    public String getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(String goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public int getCartGoodsCount() {
        return cartGoodsCount;
    }

    public void setCartGoodsCount(int cartGoodsCount) {
        this.cartGoodsCount = cartGoodsCount;
    }
}
