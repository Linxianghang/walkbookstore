package com.xzsd.app.managerinformation.dao;

import com.xzsd.app.managerinformation.entity.ManagerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ManagerInfomationDao
 * @author linxianghang
 * @date 2020-04-27
 */
@Mapper
public interface ManagerInfomationDao {
    /**
     * 查询负责给店长送货的所有司机
     * @param userId
     * @return
     */
    List<ManagerInfo> listManagerDrivers(@Param("userId") String userId);

}
