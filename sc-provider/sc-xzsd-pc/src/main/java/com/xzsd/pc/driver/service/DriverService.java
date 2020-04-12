package com.xzsd.pc.driver.service;


import com.github.pagehelper.PageHelper;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import com.github.pagehelper.PageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author linxianghang
 * @Date 2020-03-21
 */
@Service
public class DriverService {

    @Resource
    private DriverDao driverDao;

    /**
     * 新增司机
     * @param driverInfo
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo) {
        // 校验账号是否存在
        int countDriverAcct = driverDao.countDriverAcct(driverInfo);
        if(0 != countDriverAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        driverInfo.setDriverId(StringUtil.getCommonCode(2));
        driverInfo.setIsDeleted(0);
        // 新增用户
        int count = driverDao.addDriver(driverInfo);
        int usercount = driverDao.addDriverToUser(driverInfo);
        if(0 == count &&  0 == usercount) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询司机详情
     * @param driverId
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse findDriverById(String driverId) {
        DriverInfo driverInfo = driverDao.findDriverById(driverId);
        return AppResponse.success("查询成功！",driverInfo);
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        int countDriverAcct = driverDao.countDriverAcct(driverInfo);
        if(countDriverAcct > 1 || countDriverAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        // 修改用户信息
        driverInfo.setLastModifiedBy("1");
        int count = driverDao.updateDriver(driverInfo);
        int usercount = driverDao.updateDriverToUser(driverInfo);
        if (0 == count && 0 == usercount) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询司机列表（分页）
     * @param driverInfo
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listDrivers(DriverInfo driverInfo) {
        PageHelper.startPage(driverInfo.getPageNum(), driverInfo.getPageSize());
        List<DriverInfo> driverInfoList = driverDao.listDriversByPage(driverInfo);
        // 包装Page对象
        PageInfo<DriverInfo> pageData = new PageInfo<DriverInfo>(driverInfoList);
        return AppResponse.success("查询成功！",pageData);
    }


    /**
     * demo 删除司机
     * @param userId
     * @param userCode
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String userCode,String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = driverDao.deleteDriver(listCode,userId);
        int usercount = driverDao.deleteDriverToUser(listCode,userId);
        if(0 == count && 0 == usercount) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}


