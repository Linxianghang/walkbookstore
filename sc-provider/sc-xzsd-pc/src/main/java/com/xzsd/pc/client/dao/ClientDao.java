package com.xzsd.pc.client.dao;


import com.xzsd.pc.client.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


/**
 * ClientDao
 * @auhor linxianghang
 * @date 2020-04-12
 */
@Mapper
public interface ClientDao {
    /**
     * 查询当前登录用户是店长时的所有客户信息
     * @param clientInfo
     * @return
     */
    List<ClientInfo> getListCustomers(ClientInfo clientInfo);

    /**
     * 查询登录者为管理员时的用户列表
     * @param clientInfo
     * @return
     */
    List<ClientInfo> getListCustomersByAdmin(ClientInfo clientInfo);

}
