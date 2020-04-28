package com.xzsd.app.clientinformation.dao;

import com.xzsd.app.clientinformation.entity.ClientInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * ClientDao
 * @author linxianghang
 * @date 2020-04-27
 */
@Mapper
public interface ClientDao {


    /**
     * 查询门店邀请码是否存在
     * @param clientInfo
     * @return
     */
    int countStoreInviteCode(ClientInfo clientInfo);

    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     */
    int updateClientInvite(ClientInfo clientInfo);
}
