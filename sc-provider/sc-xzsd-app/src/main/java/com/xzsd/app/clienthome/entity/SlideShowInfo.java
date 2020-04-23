package com.xzsd.app.clienthome.entity;

/**
 * app首页轮播图实体类
 * @author linxianghang
 * @date 2020-04-22
 */
public class SlideShowInfo {
    /**
     * 首页轮播图的路径
     */
    private String slideshowPath;
    /**
     * 商品id
     */
    private String goodsId;

    public String getSlideshowPath() {
        return slideshowPath;
    }

    public void setSlideshowPath(String slideshowPath) {
        this.slideshowPath = slideshowPath;
    }

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }
}
