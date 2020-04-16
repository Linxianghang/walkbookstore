package com.xzsd.pc.hotgoods.dao;

import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsShowNumberInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    /**
     * 查询热门商品详情
     * @param hotGoodsId
     * @return
     */
    HotGoodsVO getHotGoods(@Param("hotGoodsId") String hotGoodsId);

    /**
     * 查询热门商品列表（分页）
     * @param hotGoodsInfo
     * @return
     */
    List<HotGoodsVO> listHotGoodsByPage(HotGoodsInfo hotGoodsInfo);

    /**
     * 修改热门商品接口
     * @param hotGoodsInfo
     * @return
     */
    int updateHotGoods(HotGoodsInfo hotGoodsInfo);

    /**
     * 查询热门位商品展示数量
     * @return
     */
    HotGoodsShowNumberInfo getHotGoodsShowNum();

    /**
     * 修改热门商品数量展示接口
     * @param hotGoodsShowNumberInfo
     * @return
     */
    int updateHotGoodsShowNum(HotGoodsShowNumberInfo hotGoodsShowNumberInfo);

    /**
     * 删除热门商品
     * @param userId
     * @param listcode
     * @return
     */
    int deleteHotGoods(@Param("listcode") List<String> listcode, @Param("userId") String userId);
}
