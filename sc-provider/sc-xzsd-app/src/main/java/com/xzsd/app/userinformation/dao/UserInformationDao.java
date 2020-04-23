package com.xzsd.app.userinformation.dao;

import com.xzsd.app.userinformation.entity.UserInfo;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * UserInformationDao
 * @author linxianghang
 * @date 2020-04-22
 */
@Mapper
public interface UserInformationDao {
    /**
     * 查询登录用户角色
     * @param userId
     * @return
     */
    String getUserRole(@Param("userId") String userId);

    /**
     * 修改个人密码
     * @param userInfo
     * @return
     */
    int updateUserPassword(UserInfo userInfo);

    /**
     * 查询店长个人信息
     *
     * @param userId
     * @return
     */
    UserInfo getStoreInfo(@Param("userId") String userId);

    /**
     * 查询司机个人信息
     *
     * @param userId
     * @return
     */
    UserInfo getDriverInfo(@Param("userId") String userId);

    /**
     * 查询客户个人信息
     *
     * @param userId
     * @param inviteCode
     * @return
     */
    UserInfo getCustomerInfo(@Param("userId") String userId, @Param("inviteCode") String inviteCode);

    /**
     * 获取客户的邀请码
     * @param userId
     * @return
     */
    String getUserInviteCode(@Param("userId") String userId);

    /**
     * 获取登录用户的密码
     *
     * @param userId
     * @return
     */
    String getUserPasswordById(@Param("userId") String userId);
}
