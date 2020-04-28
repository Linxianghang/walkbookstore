package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DriverDao
 * @author linxianghang
 * @date 2020-04-27
 */
@Mapper
public interface DriverDao {
    /**
     * 查店长信息列表
     * @param driverInfo
     * @return
     */
        List<DriverInfo> listDriverStores(DriverInfo driverInfo);
}
