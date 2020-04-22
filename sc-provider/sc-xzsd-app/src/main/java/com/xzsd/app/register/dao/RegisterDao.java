package com.xzsd.app.register.dao;

import com.xzsd.app.register.entity.RegisterInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * RegisterDao
 * @author linxianghang
 * @date 2020-04-22
 */
@Mapper
public interface RegisterDao {

    /**
     * 注册用户
     * @param registerInfo
     * @return
     */
    int registerUser(RegisterInfo registerInfo);

    /**
     * 新增邀请码
     * @param registerInfo
     * @return
     */
    int addInviteCode(RegisterInfo registerInfo);

    /**
     * 统计用户账号
     * @param registerInfo
     * @return
     */
    int countUserAcctAndPhone(RegisterInfo registerInfo);
}
