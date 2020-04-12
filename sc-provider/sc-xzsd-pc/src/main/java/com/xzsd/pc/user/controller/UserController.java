package com.xzsd.pc.user.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.driver.controller.DriverController;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description UserController
 * @Author linxianghang
 * @Date 2020-04-09
 */

@RestController
@RequestMapping("user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    /**
     * 新增司机
     *
     * @param userInfo
     * @return AppResponse
     * @author dingning
     * @Date 2020-03-21
     */
    @PostMapping("addUser")
    public AppResponse addDriver(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setCreateUser(userId);
            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     *查询用户
     *
     * @param userId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("getUser")
    public AppResponse getUser(String userId){
        try{
            return userService.getUser(userId);
        } catch (Exception e){
            logger.error("查询用户失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     *
     * @param userInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            userInfo.setUpdateUser(userId);
            return userService.updateUser(userInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除用户
     *
     * @param userId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("deleteUser")
    public AppResponse deleteUser(String userId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return userService.deleteUser(userId,updateUser);
        } catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  用户列表(分页)
     *
     * @param userInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @RequestMapping(value = "listUsers")
    public AppResponse listUsers(UserInfo userInfo) {
        try {
            return userService.listUsers(userInfo);
        } catch (Exception e) {
            logger.error("查询用户列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }


}
