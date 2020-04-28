package com.xzsd.app.driver.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * DriverController
 * @author linxianghang
 * @date 2020-04-27
 */
@RestController
@RequestMapping("/driverHome")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * 查询负责送货的门店
     * @param driverInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    @PostMapping("listDriverStores")
    public AppResponse listDriverStores(DriverInfo driverInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUserId(userId);
            return driverService.listDriverStores(driverInfo);
        }catch (Exception e){
            logger.error("查询司机送货的门店失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
