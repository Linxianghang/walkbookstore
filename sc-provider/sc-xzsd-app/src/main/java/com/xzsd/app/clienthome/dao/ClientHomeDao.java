package com.xzsd.app.clienthome.dao;

import com.xzsd.app.clienthome.entity.HotGoodsInfo;
import com.xzsd.app.clienthome.entity.HotGoodsVO;
import com.xzsd.app.clienthome.entity.SlideShowInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * ClientHomeDao
 * @author linxianghang
 * @date 2020-04-22
 */
@Mapper
public interface ClientHomeDao {
    /**
     * 查询首页轮播图
     *
     * @return
     */
    List<SlideShowInfo> listRotationCharHome();

    /**
     * 查询热门位商品
     *
     * @param hotGoodsInfo
     * @return
     */
    List<HotGoodsVO> listHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询首页轮播图展示的数量
     * @return
     */
    int getSlideShowNumber();
}
