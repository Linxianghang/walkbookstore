package com.xzsd.pc.driver.dao;


import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName DriverDao
 * @Description Driver
 * @Author linxianghang
 * @Date 2020-03-26
 */
@Mapper
public interface DriverDao {

    /**
     * 统计用户账号数量
     * @param driverInfo 用户信息
     * @return
     */
    int countDriverAcct(DriverInfo driverInfo);

    /**
     * 新增司机
     * @param driverInfo 用户信息
     * @return
     */
    int addDriver(DriverInfo driverInfo);

    /**
     * 新增司机到用户表
     * @param driverInfo
     * @return
     */
    int addDriverToUser(DriverInfo driverInfo);

    /**
     * 查询司机详情
     * @param driverId
     * @return DriverInfo
     */
    DriverInfo findDriverById(@Param("driverId") String driverId);

    /**
     * 修改司机信息
     * @param driverInfo 修改的信息
     * @return
     */
    int updateDriver(DriverInfo driverInfo);

    /**
     * 修改司机信息到用户表
     * @param driverInfo
     * @return
     */
    int updateDriverToUser(DriverInfo driverInfo);


    /**
     *管理员查询所有的司机信息
     * @param driverInfo
     * @return 司机信息
     */
    List<DriverVO> getListDriverByAdmin(DriverInfo driverInfo);

    /**
     * 查询当前店长下的所有司机
     * @param driverInfo
     * @return
     */
    List<DriverVO> getListDriverByStore(DriverInfo driverInfo);

    /**
     * 删除司机列表
     * @param listcode
     * @param userId
     * @return 0成功 1失败
     */
    int deleteDriver(@Param("listcode") List<String> listcode,@Param("userId") String userId);

    /**
     * 删除司机用户表
     * @param listcode
     * @param userId
     * @return
     */
    int deleteDriverToUser(@Param("listcode") List<String> listcode, @Param("userId") String userId);

    /**
     * 分页查询接口
     * @param driverInfo
     * @return
     */
    List<DriverInfo> listDriversByPage(DriverInfo driverInfo);
}