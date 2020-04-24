package com.xzsd.app.clientgoods.entity;

import java.util.List;

/**
 * 封装一级分类数据类
 * @author linxianghang
 * @date 2020-04-23
 */
public class OneClassifyList {
    private List<GoodsCategory> oneClassifyList;

    public List<GoodsCategory> getOneClassifyList() {
        return oneClassifyList;
    }

    public void setOneClassifyList(List<GoodsCategory> oneClassifyList) {
        this.oneClassifyList = oneClassifyList;
    }
}
