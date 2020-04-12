package com.xzsd.pc.goods.dao;


import com.xzsd.pc.goods.entity.GoodsClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * 新增商品
     * @param goodsInfo
     * @return
     */
    int addGoods(GoodsInfo goodsInfo);

    /**
     * 查询商品详情
     * @param goodsId
     * @return GoodsInfo
     */
    GoodsInfo getGoods(@Param("goodsId") String goodsId);


    /**
     * 修改商品
     * @param goodsInfo
     * @return
     */
    int updateGoods(GoodsInfo goodsInfo);

    /**
     * 修改商品状态
     * @param goodsInfo
     * @return
     */
    int updateGoodsShelfState(GoodsInfo goodsInfo);

    /**
     * 删除司机用户表
     * @param userId
     * @param listcode
     * @return
     */
    int deleteGoods(@Param("listcode") List<String> listcode, @Param("userId") String userId);

    /**
     * 分页查询接口
     * @param goodsInfo
     * @return
     */
    List<GoodsInfo> listGoodsByPage(GoodsInfo goodsInfo);

    /**
     * 查询商品分类下拉框接口
     * @param classifyId
     * @return
     */
    List<GoodsClassifyInfo> listGoodsClassify(@Param("classifyId") String classifyId);
}
