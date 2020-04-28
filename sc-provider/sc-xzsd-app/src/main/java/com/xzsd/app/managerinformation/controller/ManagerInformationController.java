package com.xzsd.app.managerinformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.managerinformation.service.ManagerInfomationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/managerInformation")
public class ManagerInformationController {
    private static final Logger logger = LoggerFactory.getLogger(ManagerInformationController.class);

    @Resource
    private ManagerInfomationService managerInfomationService;

    /**
     * 查询司机信息列表
     * @author linxianghang
     * @date 2020-04-27
     * @return
     */
    @PostMapping("listManagerDrivers")
    public AppResponse getListDriver(){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return managerInfomationService.listManagerDrivers(userId);
        }catch (Exception e){
            logger.error("查询司机信息列表失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
