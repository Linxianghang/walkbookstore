package com.xzsd.pc.user.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserVO;
import com.xzsd.pc.util.PasswordUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * UserService
 * @author linxianghang
 * @date  2020-04-09
 */

@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * 新增用户
     * @param userInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        // 校验账号是否存在
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        int countUserPhone = userDao.countUserPhone(userInfo);
        if(0 != countUserPhone) {
            return AppResponse.bizError("手机已存在，请重新输入！");
        }
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDelete(0);
        //密码加密
        String oldpwd = userInfo.getUserPassword();
        String pwd = PasswordUtil.generatePassword(oldpwd);
        userInfo.setUserPassword(pwd);
        // 新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询司机详情
     * @param userId
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getUser(String userId) {
        UserVO userInfo = userDao.getUser(userId);
        if(userInfo == null){
            return AppResponse.versionError("查询失败");
        }
        return AppResponse.success("查询成功！",userInfo);
    }

    /**
     * 修改用户信息
     * @param userInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo) {
        UserVO user = userDao.getUser(userInfo.getUserId());
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在、存在才可以修改
        int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 == countUserAcct) {
            return AppResponse.bizError("用户账号不存在，无法修改，请重新输入！");
        }
        //判断是否密码被修改、若修改进行新密码加密
        if(!(user.getUserPassword().equals(userInfo.getUserPassword()))){
            String password = userInfo.getUserPassword();
            String pwd = PasswordUtil.generatePassword(password);
            userInfo.setUserPassword(pwd);
        }
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除用户
     * @param userId
     * @param updateUser
     * @return
     * @Author linxianghang
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userId, String updateUser) {
        List<String> listCode = Arrays.asList(userId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = userDao.deleteUser(listCode, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listUsers(UserInfo userInfo) {
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        // 包装Page对象
        PageInfo<UserInfo> pageData = new PageInfo<UserInfo>(userInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

}
