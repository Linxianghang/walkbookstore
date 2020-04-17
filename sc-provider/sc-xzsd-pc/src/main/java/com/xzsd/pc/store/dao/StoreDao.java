package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * StoreDao
 * @author linxianghang
 * @date 2020-04-17
 */
@Mapper
public interface StoreDao {
    /**
     * 新增门店信息
     * @param storeInfo
     * @return
     */
    int addStore(StoreInfo storeInfo);

    /**
     *查询门店信息详情
     * @param storeId
     * @return
     */
    StoreVO getStore(@Param("storeId") String storeId);

    /**
     * 修改商品状态
     * @param storeInfo
     * @return
     */
    int updateStore(StoreInfo storeInfo);

    /**
     * 删除司机用户表
     * @param userId
     * @param listcode
     * @return
     */
    int deleteStore(@Param("listcode") List<String> listcode, @Param("userId") String userId);

    /**
     * 分页查询接口
     * @param storeInfo
     * @return
     */
    List<StoreVO> listStoresByPage(StoreInfo storeInfo);
}
