package com.xzsd.app.clientgoods.entity;

/**
 * app用户评价实体类
 * @author linxianghang
 * @date 2020-04-24
 */
public class GoodsEvaluationInfo {
    /**
     * 商品id
     */
    private String goodsId;
    /**
     * 评价用户账号
     */
    private String userAcct;
    /**
     * 评价内容
     */
    private String evaluateContent;
    /**
     * 评价等级
     */
    private int evaluateScore;
    /**
     * 评价时间
     */
    private String createTime;
    /**
     * 一页多少条
     */
    private int pageSize;
    /**
     * 第几页
     */
    private int pageNum;
    /**
     * 用户id
     */
    private String userId;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getUserAcct() {
        return userAcct;
    }

    public void setUserAcct(String userAcct) {
        this.userAcct = userAcct;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
