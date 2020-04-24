package com.xzsd.app.clientgoods.entity;

import java.util.List;

/**
 * 封装二级分类数据类
 * @author linxianghang
 * @date 2020-04-23
 */
public class TwoClassifyList {
    private List<GoodsCategory> twoClassifyList;

    public List<GoodsCategory> getTwoClassifyList() {
        return twoClassifyList;
    }

    public void setTwoClassifyList(List<GoodsCategory> twoClassifyList) {
        this.twoClassifyList = twoClassifyList;
    }
}
