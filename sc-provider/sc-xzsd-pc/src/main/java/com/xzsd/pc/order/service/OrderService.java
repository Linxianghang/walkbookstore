package com.xzsd.pc.order.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * OrderService
 * @author linxianghang
 * @date 2020-04-14
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getListOrder(String orderId){
        List<OrderDetails> orderDetails = orderDao.getListOrder(orderId);
        if(orderDetails.size() == 0){
            return AppResponse.versionError("查询订单详情失败！");
        }
        //封装成接口文档需要的名称
        OrderDetailsList orderDetailsList = new OrderDetailsList();
        orderDetailsList.setOrderDeepenList(orderDetails);
        return AppResponse.success("查询订单详情成功！", orderDetailsList);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-14
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验订单是否存在 待写
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        orderInfo.setUpdateUser("1");
        int count = orderDao.updateOrderState(orderInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 分页查询订单
     * @param
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listOrders(OrderInfo orderInfo) {
        PageHelper.startPage(orderInfo.getPageNum(), orderInfo.getPageSize());
        List<OrderSearchVO> orderSearchVOList = orderDao.listOrdersByPage(orderInfo);
        // 包装Page对象
        PageInfo<OrderSearchVO> pageData = new PageInfo<OrderSearchVO>(orderSearchVOList);
        return AppResponse.success("查询成功！",pageData);
    }
}
