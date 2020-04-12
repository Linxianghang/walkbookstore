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
     * 分页查询接口
     * @param clientInfo
     * @return
     */
    List<ClientInfo> listClientsByPage(ClientInfo clientInfo);

}
