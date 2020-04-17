package com.xzsd.pc.store.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * StoreController
 * @author linxianghang
 * @date 2020-04-17
 */
@RestController
@RequestMapping("store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);

    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     *
     * @param storeInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-17
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            storeInfo.setCreateUser(userId);
            AppResponse appResponse = storeService.addStore(storeInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("新增门店失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询门店
     *
     * @param storeId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-17
     */
    @PostMapping("getStore")
    public AppResponse getStore(String storeId){
        try{
            return storeService.getStore(storeId);
        } catch (Exception e){
            logger.error("查询门店失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     *
     * @param storeId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("deleteStore")
    public AppResponse deleteGoods(String storeId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return storeService.deleteStore(storeId,updateUser);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  门店列表(分页)
     *
     * @param storeInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @RequestMapping(value = "listStores")
    public AppResponse listStores(StoreInfo storeInfo) {
        try {
            return storeService.listStoresByPage(storeInfo);
        } catch (Exception e) {
            logger.error("查询门店列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店
     *
     * @param storeInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-17
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            storeInfo.setUpdateUser(userId);
            return storeService.updateStore(storeInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
