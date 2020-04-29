package com.xzsd.app.clientorder.dao;

import com.xzsd.app.clientorder.entity.EvaluationOrder;
import com.xzsd.app.clientorder.entity.GoodsInfo;
import com.xzsd.app.clientorder.entity.OrderInfo;
import com.xzsd.app.clientorder.entity.OrderInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 *ClientOrderDao
 * @author linxianghang
 * @date 2020-04-27
 */
@Mapper
public interface ClientOrderDao {
    /**
     * 新增客户订单的订单信息
     * @param orderInfo
     * @return
     */
    int addCustomerOrder(OrderInfo orderInfo);

    /**
     * 新增客户订单的商品信息
     * @param orderInfoList
     * @return
     */
    int addCustomerOrderGoodsInfo(@Param("orderInfoList") List<OrderInfo> orderInfoList);

    /**
     * 查询新增订单中的商品库存数量
     * @param listGoodsId
     * @return
     */
    List<GoodsInfo> getListGoodsInventory(@Param("listGoodsId") List<String> listGoodsId);

    /**
     * 更新商品的库存数量
     * @param goodsInfoList
     * @return
     */
    int updateGoodsInventory(@Param("goodsInfoList") List<GoodsInfo> goodsInfoList);

    /**
     * 删除购物车
     * @param shopCartIdList
     * @param userId
     * @return
     */
    int deleteShoppingCard(@Param("shopCartIdList") List<String> shopCartIdList, @Param("userId") String userId);

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @return
     */
    List<OrderInfoVO> getListCustomerOrder(OrderInfo orderInfo);

    /**
     * 查询订单列表下的商品
     * @param orderInfo
     * @return
     */
    List<GoodsInfo> getListOrderGoods(OrderInfo orderInfo);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderStatus(OrderInfo orderInfo);



    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    OrderInfoVO getCustomerOrderById(@Param("orderId") String orderId);

    /**
     * 查询订单评价列表
     * @param orderId
     * @return
     */
    List<GoodsInfo> getListOrderEvaluation(@Param("orderId") String orderId);

    /**
     * 新增订单商品评价
     * @param evaluationOrders
     * @return
     */
    int addEvaluateOrder(@Param("evaluationOrders") List<EvaluationOrder> evaluationOrders);

    /**
     * 查询每个商品的评价等级的平均数
     * @param listGoodsId
     * @return
     */
    List<GoodsInfo> getEvaluationGoodsRank(@Param("listGoodsId") List<String> listGoodsId);

    /**
     * 更新商品星级
     * @param listGoods
     * @return
     */
    int updateGoodsRank(@Param("listGoods") List<GoodsInfo> listGoods);
}
