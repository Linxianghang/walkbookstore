package com.xzsd.pc.client.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.client.dao.ClientDao;
import com.xzsd.pc.client.entity.ClientInfo;
import org.omg.PortableInterceptor.ClientRequestInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClientService
 * @author linxianghang
 * @date 2020-04-12
 */
@Service
public class ClientService {


    @Resource
    private ClientDao clientDao;

    /**
     * demo 查询客户列表（分页）
     * @param clientInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listClients(ClientInfo clientInfo) {
        List<ClientInfo> listCustomers = null;
        PageHelper.startPage(clientInfo.getPageNum(), clientInfo.getPageSize());
        //判断是不是管理员,管理员查全部，店长查自己的客户
        if("2".equals(clientInfo.getRole())){
            listCustomers = clientDao.getListCustomers(clientInfo);
        }else if("0".equals(clientInfo.getRole()) || "1".equals(clientInfo.getRole())){
            listCustomers = clientDao.getListCustomersByAdmin(clientInfo);
        }
        PageInfo<ClientInfo> pageData = new PageInfo<>(listCustomers);
        return AppResponse.success("查询成功！", pageData);
    }

}
