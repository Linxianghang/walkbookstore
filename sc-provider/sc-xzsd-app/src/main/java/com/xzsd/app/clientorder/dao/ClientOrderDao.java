package com.xzsd.app.clientorder.dao;

import com.xzsd.app.clientorder.entity.ClientOrderInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClientOrderDao
 * @author linxianghang
 * @date 2020-04-25
 */
@Mapper
public interface ClientOrderDao {
    /**
     * 新增订单
     * @param clientOrderInfo
     * @return
     */
    int addOrder(ClientOrderInfo clientOrderInfo);

}
