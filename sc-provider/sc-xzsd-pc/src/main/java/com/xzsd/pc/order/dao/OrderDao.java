package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderSearchVO;
import com.xzsd.pc.order.entity.OrderVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * OrderDao
 * @author linxianghang
 * @date 2020-04-14
 */
@Mapper
public interface OrderDao {

    /**
     * 查询订单列表（分页）
     * @param orderId
     * @return
     */
    List<OrderDetails> getListOrder(@Param("orderId") String orderId);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderState(OrderInfo orderInfo);

    /**
     * 查询订单列表（分页）
     * @param orderInfo
     * @return
     */
    List<OrderVO> listOrders(OrderInfo orderInfo);

    /**
     * 管理员查询全部订单（分页）
     * @param orderInfo
     * @return
     */
    List<OrderVO> getListOrderByAdmin(OrderInfo orderInfo);
}
