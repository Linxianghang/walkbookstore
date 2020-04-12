package com.xzsd.pc.driver.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description Driver
 * @Author linxianghang
 * @Date 2020-03-26
 */
@RestController
@RequestMapping("/driver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    /**
     * demo 新增司机
     *
     * @param driverInfo
     * @return AppResponse
     * @author dingning
     * @Date 2020-03-21
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            AppResponse appResponse = driverService.addDriver(driverInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("司机新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 查询用户详情
     *
     * @param driverId
     * @return AppResponse
     * @author dingning
     * @Date 2020-03-21
     */
    @RequestMapping(value = "findDriverById")
    public AppResponse findDriverById(String driverId) {
        try {
            return driverService.findDriverById(driverId);
        } catch (Exception e) {
            logger.error("用户查询错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 修改用户
     *
     * @param driverInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-03-26
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            driverInfo.setCreateBy(userId);
            driverInfo.setLastModifiedBy(userId);
            return driverService.updateDriver(driverInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 司机列表(分页)
     *
     * @param driverInfo
     * @return AppResponse
     * @author dingning
     * @Date 2020-03-21
     */
    @RequestMapping(value = "listDrivers")
    public AppResponse listUsers(DriverInfo driverInfo) {
        try {
            return driverService.listDrivers(driverInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * demo 删除司机
     *
     * @param userCode
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-03-26
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String userCode) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return driverService.deleteDriver(userCode, userId);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}