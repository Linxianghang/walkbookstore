package com.xzsd.app.clientorder.dao;

import com.xzsd.app.clientorder.entity.ClientOrderInfo;
import com.xzsd.app.clientorder.entity.GoodsInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ClientOrderDao
 * @author linxianghang
 * @date 2020-04-25
 */
@Mapper
public interface ClientOrderDao {
    /**
     * 查询新增订单中的商品库存数量
     * @param listGoodsId
     * @return
     */
    List<GoodsInfo> getListGoodsInventory(@Param("listGoodsId") List<String> listGoodsId);

    /**
     * 新增订单
     * @param clientOrderInfo
     * @return
     */
    int addOrder(ClientOrderInfo clientOrderInfo);

    /**
     * 删除购物车
     * @param shopCartIdList
     * @param userId
     * @return
     */
    int deleteShoppingCard(@Param("shopCartIdList") List<String> shopCartIdList, @Param("userId") String userId);

    /**
     * 更新商品的库存数量
     * @param goodsInfoList
     * @return
     */
    int updateGoodsInventory(@Param("goodsInfoList") List<GoodsInfo> goodsInfoList);

}
