package com.xzsd.app.register.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.register.dao.RegisterDao;
import com.xzsd.app.register.entity.RegisterInfo;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * RegisterService
 * @author linxianghang
 * @date 2020-04-22
 */
@Service
public class RegisterService {
    @Resource
    private RegisterDao registerDao;

    /**
     * 注册用户
     *
     * @param registerInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse registerUser(RegisterInfo registerInfo){
        int count = registerDao.countUserAcctAndPhone(registerInfo);
        if(0 != count){
            return AppResponse.versionError("存在相同的账号或手机号，请重新输入！");
        }
        registerInfo.setUserId(StringUtil.getCommonCode(2));
        registerInfo.setCustomerId(StringUtil.getCommonCode(2));
        //把用户密码加密
        String userPassword = registerInfo.getUserPassword();
        String pwd = PasswordUtils.generatePassword(userPassword);
        registerInfo.setUserPassword(pwd);
        int registerCount = registerDao.registerUser(registerInfo);
        int num = registerDao.addInviteCode(registerInfo);
        if(0 == registerCount || 0 == num){
            return AppResponse.versionError("注册用户失败，请重新注册！");
        }
        return AppResponse.success("注册用户成功！");
    }
}