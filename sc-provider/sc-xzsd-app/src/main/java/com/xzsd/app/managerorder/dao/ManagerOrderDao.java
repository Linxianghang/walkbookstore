package com.xzsd.app.managerorder.dao;

import com.xzsd.app.managerorder.entity.GoodsInfo;
import com.xzsd.app.managerorder.entity.ManagerOrder;
import com.xzsd.app.managerorder.entity.ManagerOrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ManagerOrderDao
 * @author linxianghang
 * @date 2020-04-27
 */
@Mapper
public interface ManagerOrderDao {
    /**
     * 查询店长订单列表
     * @param managerOrder
     * @return
     */
    List<ManagerOrderVO> listManagerOrders(ManagerOrder managerOrder);

    /**
     * 查询订单下的所有商品
     * @param managerOrder
     * @return
     */
    List<GoodsInfo> getListOrderGoods(ManagerOrder managerOrder);

    /**
     * 更新订单状态
     * @param managerOrder
     * @return
     */
    int updateManagerOrderState(ManagerOrder managerOrder);

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    ManagerOrderVO listManagerOrderDeepen(@Param("orderId") String orderId);
}
