package com.xzsd.app.clientorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientorder.entity.OrderInfo;
import com.xzsd.app.clientorder.service.ClientOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClientOrderController
 * @author linxianghang
 * @date 2020-04-27
 */
@RestController
@RequestMapping("/clientOrder")
public class ClientOrderController {

    private static final Logger logger = LoggerFactory.getLogger(ClientOrderController.class);

    @Resource
    private ClientOrderService clientOrderService;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("addOrder")
    public AppResponse addCustomerOrder(OrderInfo orderInfo){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return clientOrderService.addCustomerOrder(orderInfo);
        }catch (Exception e){
            logger.error("新增订单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("listOrder")
    public AppResponse getListCustomerOrder(OrderInfo orderInfo){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return clientOrderService.getListCustomerOrder(orderInfo);
        }catch (Exception e){
            logger.error("查询订单列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            orderInfo.setUserId(userId);
            return clientOrderService.updateOrderStatus(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("listOrderDeepen")
    public AppResponse getCustomerOrderById(String orderId){
        try {
            return clientOrderService.getCustomerOrderById(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单评价列表
     * @param orderId
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("listGoodsForEvaluate")
    public AppResponse getListOrderEvaluation(String orderId){
        try {
            return clientOrderService.getListOrderEvaluation(orderId);
        }catch (Exception e){
            logger.error("查询订单评价列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 新增订单评价
     * @param
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("addGoodsEvaluate")
    public AppResponse addEvaluateOrder(@RequestBody JSONObject obj){
        try {
            //获取登录id
            String userId = SecurityUtils.getCurrentUserId();
            return clientOrderService.addEvaluateOrder(obj, userId);
        }catch (Exception e){
            logger.error("新增订单评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
