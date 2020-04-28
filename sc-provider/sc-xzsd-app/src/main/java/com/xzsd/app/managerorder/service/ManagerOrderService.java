package com.xzsd.app.managerorder.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerorder.dao.ManagerOrderDao;
import com.xzsd.app.managerorder.entity.GoodsInfo;
import com.xzsd.app.managerorder.entity.ManagerOrder;
import com.xzsd.app.managerorder.entity.ManagerOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * ManagerOrderService
 * @author linxianghang
 * @date 2020-04-27
 */
@Service
public class ManagerOrderService {
    @Resource
    private ManagerOrderDao managerOrderDao;

    /**
     * 查询店长订单列表（分页）
     * @param managerOrder
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    public AppResponse listManagerOrders(ManagerOrder managerOrder){
        PageHelper.startPage(managerOrder.getPageNum(), managerOrder.getPageSize());
        List<ManagerOrderVO> managerOrderVOList = managerOrderDao.listManagerOrders(managerOrder);
        List<GoodsInfo> orderGoodsList = managerOrderDao.getListOrderGoods(managerOrder);
        PageInfo<ManagerOrderVO> pageData = new PageInfo<>(managerOrderVOList);
        for (int i = 0; i < managerOrderVOList.size(); i++) {
            List<GoodsInfo> list = new ArrayList<>();
            for(int j = 0; j < orderGoodsList.size(); j++){
                //判断订单id是否相等,如果相等商品加入订单
                if(managerOrderVOList.get(i).getOrderId().equals(orderGoodsList.get(j).getOrderId())){
                    list.add(orderGoodsList.get(j));
                }
            }
            managerOrderVOList.get(i).setGoodsList(list);
        }
        return AppResponse.success("查询店长订单列表成功", pageData);
    }

    /**
     * 修改订单状态
     * @param managerOrder
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateManagerOrderState(ManagerOrder managerOrder){
        int count = managerOrderDao.updateManagerOrderState(managerOrder);
        if(count == 0){
            return AppResponse.versionError("修改订单状态失败");
        }
        return AppResponse.success("修改订单状态成功");
    }

    /**
     * 查询订单详情
     * @param orderId
     * @return
     */
    public AppResponse listManagerOrderDeepen(String orderId){
        ManagerOrderVO orderDetails = managerOrderDao.listManagerOrderDeepen(orderId);
        if(orderDetails == null){
            return AppResponse.versionError("查询订单详情失败");
        }
        orderDetails.setAddress(orderDetails.getProvinceName() + orderDetails.getCityName() + orderDetails.getAreaName() + orderDetails.getAddress());
        return AppResponse.success("查询订单详情成功", orderDetails);
    }

}
