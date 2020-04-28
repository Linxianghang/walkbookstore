package com.xzsd.app.managerorder.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerorder.entity.ManagerOrder;
import com.xzsd.app.managerorder.service.ManagerOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/managerOrder")
public class ManagerOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerOrderController.class);

    @Resource
    private ManagerOrderService managerOrderService;

    /**
     * 查询店长订单列表
     * @param managerOrder
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("listManagerOrders")
    public AppResponse listManagerOrders(ManagerOrder managerOrder){
        try {
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            managerOrder.setUserId(userId);
            return managerOrderService.listManagerOrders(managerOrder);
        }catch (Exception e){
            logger.error("查询店长订单列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param managerOrder
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("updateManagerOrderState")
    public AppResponse updateManagerOrderState(ManagerOrder managerOrder){
        try {
            //获取登录用户id
            String userId = SecurityUtils.getCurrentUserId();
            managerOrder.setUserId(userId);
            return managerOrderService.updateManagerOrderState(managerOrder);
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
    @PostMapping("listManagerOrderDeepen")
    public AppResponse listManagerOrderDeepen(String orderId){
        try {
            return managerOrderService.listManagerOrderDeepen(orderId);
        }catch (Exception e){
            logger.error("查询订单详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
