package com.xzsd.pc.goodsclassify.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsclassify.service.GoodsClassifyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * GoodsClassifyController
 * @author linxianghang
 * @date 2020-04-13
 */
@RestController
@RequestMapping("/goodsClassify")
public class GoodsClassifyController {
    private static final Logger logger = LoggerFactory.getLogger(GoodsClassifyController.class);

    @Resource
    private GoodsClassifyService goodsClassifyService;

    /**
     * 新增商品分类
     *
     * @param goodsClassifyInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @PostMapping("addGoodsClassify")
    public AppResponse addGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsClassifyInfo.setCreateUser(userId);
            AppResponse appResponse = goodsClassifyService.addGoodsClassify(goodsClassifyInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("商品分类新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询商品分类详情
     *
     * @param classifyId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @PostMapping("getGoodsClassify")
    public AppResponse getGoodsClassify(String classifyId){
        try{
            return goodsClassifyService.getGoodsClassify(classifyId);
        } catch (Exception e){
            logger.error("查询商品分类详情失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询商品分类列表
     *
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @PostMapping("listAllGoodsClassify")
    public AppResponse listAllGoodsClassify(){
        try{
            return goodsClassifyService.listAllGoodsClassify();
        } catch (Exception e){
            logger.error("查询商品分类列表失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改商品分类
     *
     * @param goodsClassifyInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @PostMapping("updateGoodsClassify")
    public AppResponse updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            goodsClassifyInfo.setUpdateUser(userId);
            return goodsClassifyService.updateGoodsClassify(goodsClassifyInfo);
        } catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除商品分类
     *
     * @param classifyId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @PostMapping("deleteGoodsClassify")
    public AppResponse deleteGoodsClassify(String classifyId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return goodsClassifyService.deleteGoodsClassify(classifyId,updateUser);
        } catch (Exception e) {
            logger.error("商品分类删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
