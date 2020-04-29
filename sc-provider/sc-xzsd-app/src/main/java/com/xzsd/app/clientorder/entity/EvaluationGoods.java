package com.xzsd.app.clientorder.entity;

public class EvaluationGoods {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价星级
     */
    private int evaluateScore;
    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getEvaluateContent() {
        return evaluateContent;
    }

    public void setEvaluateContent(String evaluateContent) {
        this.evaluateContent = evaluateContent;
    }

    public int getEvaluateScore() {
        return evaluateScore;
    }

    public void setEvaluateScore(int evaluateScore) {
        this.evaluateScore = evaluateScore;
    }
}
