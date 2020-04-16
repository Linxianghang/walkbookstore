package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * HotGoodsDao
 * @author linxianghang
 * @date 2020-04-16
 */
@Mapper
public interface HotGoodsDao {

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     */
    int addHotGoods(HotGoodsInfo hotGoodsInfo);

}
