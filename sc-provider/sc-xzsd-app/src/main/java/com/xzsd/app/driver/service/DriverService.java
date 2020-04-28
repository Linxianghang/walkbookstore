package com.xzsd.app.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.DriverInfo;
import com.xzsd.app.driver.entity.DriverInfoList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * DriverService
 * @author linxianghang
 * @date 2020-04-27
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 查询当前司机负责送货的门店信息
     * @param driverInfo
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    public AppResponse listDriverStores(DriverInfo driverInfo){
        List<DriverInfo> listStoreInfo = driverDao.listDriverStores(driverInfo);
        if(listStoreInfo.size() == 0){
            return AppResponse.versionError("当前司机账号没有绑定门店");
        }
        for (int i = 0; i < listStoreInfo.size(); i++) {
            listStoreInfo.get(i).setAddress(listStoreInfo.get(i).getProvinceName()
                    + listStoreInfo.get(i).getCityName() + listStoreInfo.get(i).getAreaName()
                    + listStoreInfo.get(i).getAddress());
        }
        DriverInfoList driverInfoList = new DriverInfoList();
        driverInfoList.setList(listStoreInfo);
        return AppResponse.success("查询门店信息成功", driverInfoList);
    }
}
