package com.xzsd.pc.user.dao;


import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {
    /**
     * 统计用户账号数量
     * @param userInfo 用户信息
     * @return
     */
    int countUserAcct(UserInfo userInfo);


    /**
     * 新增用户
     * @param userInfo
     * @return
     */
    int addUser(UserInfo userInfo);

    /**
     * 修改用户详情
     * @param userInfo
     * @return
     */
    int updateUser(UserInfo userInfo);

    /**
     * 查询用户详情
     * @param userId
     * @return UserInfo
     */
    UserInfo getUser(@Param("userId") String userId);


    /**
     * 删除司机用户表
     * @param userId
     * @return
     */
    int deleteUser(@Param("listcode") List<String> listcode,@Param("userId") String userId);

    /**
     * 分页查询接口
     * @param userInfo
     * @return
     */
    List<UserInfo> listUsersByPage(UserInfo userInfo);


}
