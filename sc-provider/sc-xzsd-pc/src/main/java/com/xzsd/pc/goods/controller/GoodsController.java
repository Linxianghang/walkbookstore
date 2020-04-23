package com.xzsd.pc.goods.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;

    /**
     * 新增商品
     *
     * @param goodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-10
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setCreateUser(userId);
            AppResponse appResponse = goodsService.addGoods(goodsInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询商品
     *
     * @param goodsId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-11
     */
    @PostMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try{
            return goodsService.getGoods(goodsId);
        } catch (Exception e){
            logger.error("查询商品失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品
     *
     * @param goodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-11
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setUpdateUser(userId);
            return goodsService.updateGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品状态
     *
     * @param goodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-11
     */
    @PostMapping("updateGoodsShelfState")
    public AppResponse updateGoodsShelfState(GoodsInfo goodsInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsInfo.setUpdateUser(userId);
            return goodsService.updateGoodsShelfState(goodsInfo);
        } catch (Exception e) {
            logger.error("修改商品状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品
     *
     * @param goodsId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("deleteGoods")
    public AppResponse deleteGoods(String goodsId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return goodsService.deleteGoods(goodsId,updateUser);
        } catch (Exception e) {
            logger.error("商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  商品列表(分页)
     *
     * @param goodsInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        try {
            return goodsService.listGoods(goodsInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询商品分类下拉框
     *
     * @param classifyId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-11
     */
    @PostMapping("listGoodsClassify")
    public AppResponse listGoodsClassify(String classifyId){
        try{
            return goodsService.listGoodsClassify(classifyId);
        } catch (Exception e){
            logger.error("查询商品分类下拉框",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
