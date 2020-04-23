package com.xzsd.pc.order.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * OrderController
 * @author linxianghang
 * @date 2020-04-14
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private OrderService orderService;

    /**
     *查询订单详情
     *
     * @param orderId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-11
     */
    @PostMapping("getListOrder")
    public AppResponse getListOrder(String orderId){
        try{
            return orderService.getListOrder(orderId);
        } catch (Exception e){
            logger.error("查询订单详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     *
     * @param orderInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-14
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            orderInfo.setUpdateUser(userId);
            return orderService.updateOrderState(orderInfo);
        } catch (Exception e) {
            logger.error("修改订单状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  分页查询订单
     *
     * @param orderInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @RequestMapping(value = "listOrders")
    public AppResponse listOrders(OrderInfo orderInfo) {
        try {
            return orderService.listOrders(orderInfo);
        } catch (Exception e) {
            logger.error("查询订单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
