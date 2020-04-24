package com.xzsd.app.clientgoods.dao;


import com.xzsd.app.clientgoods.entity.GoodsCategory;
import com.xzsd.app.clientgoods.entity.GoodsEvaluationInfo;
import com.xzsd.app.clientgoods.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * ClientGoodsDao
 * @author linxianghang
 * @date 2020-04-23
 */
@Mapper
public interface ClientGoodsDao {
    /**
     * 查询商品信息详情
     * @param goodsId
     * @return
     */
    GoodsInfo getGoods(@Param("goodsId") String goodsId);

    /**
     * 查询商品评价列表
     * @param goodsEvaluationInfo
     * @return
     */
    List<GoodsEvaluationInfo> listGoodsEvaluates(GoodsEvaluationInfo goodsEvaluationInfo);

    /**
     * 查询商品一级分类
     * @return
     */
    List<GoodsCategory> listOneGoodsClassify();

    /**
     * 查询商品二级分类级商品信息
     * @param classifyId
     * @return
     */
    List<GoodsCategory> listGetClassGoods(@Param("classifyId") String classifyId);


}
