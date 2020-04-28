package com.xzsd.app.clientinformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.clientinformation.entity.ClientInfo;
import com.xzsd.app.clientinformation.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClientController
 * @author linxianghang
 * @date 2020-04-27
 */
@RestController
@RequestMapping("/clientInformation")
public class ClientController {
    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

    @Resource
    private ClientService clientService;

    /**
     * 修改邀请码
     * @param clientInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("updateClientInvite")
    public AppResponse updateClientInvite(ClientInfo clientInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            clientInfo.setUserId(userId);
            return clientService.updateClientInvite(clientInfo);
        }catch (Exception e){
            logger.error("修改邀请码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
