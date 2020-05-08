package com.xzsd.pc.goodsclassify.entity;

import java.util.List;

/**
 * 商品分类返回实体类
 * @author linxianghang
 * @Date 2020-04-13
 */
public class GoodsClassifyVO {
    /**
     * 分类id
     */
    private String classifyId;
    /**
     * 分类名称
     */
    private String classifyName;
    /**
     * 等级
     */
    private int rank;
    /**
     * 父级id
     */
    private String classifyParent;
    /**
     * 备注
     */
    private String classifyComment;
    /**
     * 版本号
     */
    private String version;
    /**
     * 二级分类
     */
    private List<GoodsClassifyVO> twoClassifyList;

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getClassifyParent() {
        return classifyParent;
    }

    public void setClassifyParent(String classifyParent) {
        this.classifyParent = classifyParent;
    }

    public String getClassifyComment() {
        return classifyComment;
    }

    public void setClassifyComment(String classifyComment) {
        this.classifyComment = classifyComment;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public List<GoodsClassifyVO> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<GoodsClassifyVO> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }
}
