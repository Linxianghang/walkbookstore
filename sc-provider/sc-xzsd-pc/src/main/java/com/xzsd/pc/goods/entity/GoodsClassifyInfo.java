package com.xzsd.pc.goods.entity;

import java.io.Serializable;

/**
 * 商品分类实体类
 */

public class GoodsClassifyInfo implements Serializable {
    /**
     * 商品分类编号
     */
    private String classifyId;
    /**
     * 商品分类名称
     */
    private String classifyName;

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
}
