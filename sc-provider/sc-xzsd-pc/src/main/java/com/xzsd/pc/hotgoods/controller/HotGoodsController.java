package com.xzsd.pc.hotgoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsShowNumberInfo;
import com.xzsd.pc.hotgoods.service.HotGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * HotGoodsController
 * @author linxianghang
 * @date 2020-04-16
 */
@RestController
@RequestMapping("hotGoods")
public class HotGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(HotGoodsController.class);

    @Resource
    private HotGoodsService hotGoodsService;

    /**
     * 新增热门商品
     *
     * @param hotGoodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @PostMapping("addHotGoods")
    public AppResponse addGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsInfo.setCreateUser(userId);
            AppResponse appResponse = hotGoodsService.addHotGoods(hotGoodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("热门商品新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询热门商品
     *
     * @param hotGoodsId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @PostMapping("getHotGoods")
    public AppResponse getHotGoods(String hotGoodsId){
        try{
            return hotGoodsService.getHotGoods(hotGoodsId);
        } catch (Exception e){
            logger.error("查询热门商品失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  热门商品列表(分页)
     *
     * @param hotGoodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @RequestMapping(value = "listHotGoods")
    public AppResponse listGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            return hotGoodsService.listHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("查询热门商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品详情
     *
     * @param hotGoodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @PostMapping("updateHotGoods")
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsInfo.setUpdateUser(userId);
            return hotGoodsService.updateHotGoods(hotGoodsInfo);
        } catch (Exception e) {
            logger.error("修改热门商品详情错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询热门位商品展示数量
     *
     * @param
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @PostMapping("getHotGoodsShowNum")
    public AppResponse getHotGoodsShowNum(){
        try{
            return hotGoodsService.getHotGoodsShowNum();
        } catch (Exception e){
            logger.error("热门位商品展示数量",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改热门商品数量展示
     *
     * @param hotGoodsShowNumberInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @PostMapping("updateHotGoodsShowNum")
    public AppResponse updateHotGoodsShowNum(HotGoodsShowNumberInfo hotGoodsShowNumberInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            hotGoodsShowNumberInfo.setUpdateUser(userId);
            return hotGoodsService.updateHotGoodsShowNum(hotGoodsShowNumberInfo);
        } catch (Exception e) {
            logger.error("修改热门商品数量展示错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除热门商品
     *
     * @param hotGoodsId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-16
     */
    @PostMapping("deleteHotGoods")
    public AppResponse deleteHotGoods(String hotGoodsId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return hotGoodsService.deleteHotGoods(hotGoodsId,updateUser);
        } catch (Exception e) {
            logger.error("热门商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
