package com.xzsd.pc.goodsclassify.dao;

import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * GoodsClassifyDao
 * @author linxianghang
 * @date 2020-04-13
 */
@Mapper
public interface GoodsClassifyDao {
    /**
     * 新增商品分类
     * @param goodsClassifyInfo
     * @return
     */
    int addGoodsClassify(GoodsClassifyInfo goodsClassifyInfo);

    /**
     * 查询商品分类详情
     * @param classifyId
     * @return GoodsClassifyInfo
     */
    GoodsClassifyInfo getGoodsClassify(@Param("classifyId") String classifyId);

    /**
     * 查询商品分类列表
     * @return
     */
    List<GoodsClassifyInfo> listAllGoodsClassify();

    /**
     *修改商品分类
     * @param goodsClassifyInfo
     * @return
     */
    int updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo);

    /**
     * 删除商品分类表
     * @param userId
     * @param listcode
     * @return
     */
    int deleteGoodsClassify(@Param("listcode") List<String> listcode, @Param("userId") String userId);
}
