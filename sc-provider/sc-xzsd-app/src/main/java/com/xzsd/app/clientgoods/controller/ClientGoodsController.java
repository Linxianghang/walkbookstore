package com.xzsd.app.clientgoods.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientgoods.entity.GoodsEvaluationInfo;
import com.xzsd.app.clientgoods.service.ClientGoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClientGoodsController
 * @author linxianghang
 * @date 2020-04-23
 */
@RestController
@RequestMapping("/clientGoods")
public class ClientGoodsController {
    private static final Logger logger = LoggerFactory.getLogger(ClientGoodsController.class);

    @Resource
    private ClientGoodsService clientGoodsService;

    /**
     * 查询商品信息详情
     *
     * @param goodsId
     * @return
     * @author linxianghang
     * @date 2020-04-23
     */
    @PostMapping("getGoods")
    public AppResponse getGoods(String goodsId){
        try {
            return clientGoodsService.getGoods(goodsId);
        }catch (Exception e){
            logger.error("查询商品详情失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价
     * @param goodsEvaluationInfo
     * @return
     * @author linxianghang
     * @date 2020-04-23
     */
    @PostMapping("listGoodsEvaluates")
    public AppResponse listGoodsEvaluates(GoodsEvaluationInfo goodsEvaluationInfo){
        try {
            return clientGoodsService.listGoodsEvaluates(goodsEvaluationInfo);
        }catch (Exception e){
            logger.error("查询商品评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品一级分类
     * @return
     * @author linxianghang
     * @date 2020-04-23
     */
    @PostMapping("listOneGoodsClassify")
    public AppResponse listOneGoodsClassify(){
        try {
            return clientGoodsService.listOneGoodsClassify();
        }catch (Exception e){
            logger.error("查询商品一级分类失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品二级分类及商品
     * @param classifyId
     * @return
     * @author linxianghang
     * @date 2020-04-23
     */
    @PostMapping("listGetClassGoods")
    public AppResponse listGetClassGoods(String classifyId){
        try {
            return clientGoodsService.listGetClassGoods(classifyId);
        }catch (Exception e){
            logger.error("查询商品二级分类及商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
