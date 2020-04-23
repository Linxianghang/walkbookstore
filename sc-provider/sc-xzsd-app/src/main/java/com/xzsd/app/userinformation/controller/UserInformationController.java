package com.xzsd.app.userinformation.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.userinformation.entity.UserInfo;
import com.xzsd.app.userinformation.service.UserInformationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * UserInformationController
 * @author linxianghang
 * @date 2020-04-22
 */
@RestController
@RequestMapping("userInformation")
public class UserInformationController {
    private static final Logger logger = LoggerFactory.getLogger(UserInformationController.class);

    @Resource
    private UserInformationService userInformationService;

    /**
     * 查询用户个人信息
     *
     * @return
     * @author linxianghang
     * @date 2020/4/22
     */
    @PostMapping("getUser")
    public AppResponse getUserInfo(){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            return userInformationService.getUserInfo(userId);
        }catch (Exception e){
            logger.error("获取用户个人信息失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户密码
     * @param userInfo
     * @return
     * @author linxianghang
     * @date 2020/4/22
     */
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword(UserInfo userInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            userInfo.setUserId(userId);
            return userInformationService.updateUserPassword(userInfo);
        }catch (Exception e){
            logger.error("修改密码失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
