package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * StoreService
 * @author linxianghang
 * @date 2020-04-17
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 新增门店
     * @param storeInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        // 校验门店是否存在 待写！
        /*int countUserAcct = slideShowDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        storeInfo.setStoreId(StringUtil.getCommonCode(2));
        storeInfo.setIsDelete(0);
        // 新增用户
        int count = storeDao.addStore(storeInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询门店详情
     * @param storeId
     * @return
     * @Author linxianghang
     * @Date 2020-04-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getStore(String storeId) {
        StoreVO storeVO = storeDao.getStore(storeId);
        return AppResponse.success("查询成功！",storeVO);
    }

    /**
     * 查询门店列表（分页）
     * @param storeInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-17
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listStoresByPage(StoreInfo storeInfo) {
        PageHelper.startPage(storeInfo.getPageNum(), storeInfo.getPageSize());
        List<StoreVO> storeVOList = storeDao.listStoresByPage(storeInfo);
        // 包装Page对象
        PageInfo<StoreVO> pageData = new PageInfo<StoreVO>(storeVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验商品是否存在
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        storeInfo.setUpdateUser("1");
        int count = storeDao.updateStore(storeInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除门店
     * @param storeId
     * @param updateUser
     * @return
     * @Author linxianghang
     * @Date 2020-04-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeId, String updateUser) {
        List<String> storesCode = Arrays.asList(storeId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店
        int count = storeDao.deleteStore(storesCode, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
