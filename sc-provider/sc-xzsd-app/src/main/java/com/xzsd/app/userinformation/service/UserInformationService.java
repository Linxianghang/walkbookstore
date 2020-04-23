package com.xzsd.app.userinformation.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.userinformation.dao.UserInformationDao;
import com.xzsd.app.userinformation.entity.UserInfo;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;

/**
 * UserInformationService
 * @author linxianghang
 * @date 2020-04-22
 */
@Service
public class UserInformationService {
    @Resource
    private UserInformationDao userInformationDao;

    /**
     * 查询用户个人信息
     *
     * @param userId
     * @return
     * @author linxianghang
     * @date 2020/4/22
     */
    public AppResponse getUserInfo(String userId){
        //获取用户角色
        String loginUserRole = userInformationDao.getUserRole(userId);
        UserInfo userInfo = null;
        if("2".equals(loginUserRole)){
            userInfo = userInformationDao.getStoreInfo(userId);
            userInfo.setAddress(userInfo.getProvinceName() + userInfo.getCityName() + userInfo.getAreaName() + userInfo.getAddress());
        }else if("3".equals(loginUserRole)){
            userInfo = userInformationDao.getDriverInfo(userId);
        }else if("4".equals(loginUserRole)){
            String inviteCode = userInformationDao.getUserInviteCode(userId);
            userInfo = userInformationDao.getCustomerInfo(userId, inviteCode);
        }
        if(userInfo == null){
            return AppResponse.versionError("查询用户个人信息失败！");
        }
        return AppResponse.success("查询用户个人信息成功", userInfo);
    }

    /**
     * 修改用户密码
     *
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserPassword(UserInfo userInfo){
        //获取用户存在数据库的密码
        String userPassword = userInformationDao.getUserPasswordById(userInfo.getUserId());
        //判断原密码和数据库存的密码是否相同
        boolean flag = PasswordUtils.equalPassword(userInfo.getUserPassword(), userPassword);
        if(!flag){
            return AppResponse.versionError("输入的原密码不正确，请重新输入");
        }
        //密码加密
        String userNewPassword = userInfo.getUserNewPassword();
        String pwd = PasswordUtils.generatePassword(userNewPassword);
        userInfo.setUserNewPassword(pwd);
        int count = userInformationDao.updateUserPassword(userInfo);
        if(0 == count){
            return AppResponse.versionError("修改密码失败");
        }
        return AppResponse.success("修改密码成功");
    }

}
