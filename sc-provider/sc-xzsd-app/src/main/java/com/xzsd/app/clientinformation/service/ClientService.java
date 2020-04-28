package com.xzsd.app.clientinformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientinformation.dao.ClientDao;
import com.xzsd.app.clientinformation.entity.ClientInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * ClientService
 * @author linxianghang
 * @date 2020-04-27
 */
@Service
public class ClientService {
    @Resource
    private ClientDao clientDao;

    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        //判断输入的邀请码是否存在
        int inviteCode = clientDao.countStoreInviteCode(clientInfo);
        if(0 == inviteCode){
            return AppResponse.versionError("你输入的门店邀请码不存在，请输入正确的邀请码");
        }
        int count = clientDao.updateClientInvite(clientInfo);
        if(0 == count){
            return AppResponse.versionError("修改邀请码失败");
        }
        return AppResponse.success("修改邀请码成功");
    }
}
