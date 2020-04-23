package com.xzsd.app.clienthome.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clienthome.entity.HotGoodsInfo;
import com.xzsd.app.clienthome.service.ClientHomeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClientHomeController
 * @author linxianghang
 * @date 2020-04-22
 */
@RestController
@RequestMapping("clientHome")
public class ClientHomeController {
    private static final Logger logger = LoggerFactory.getLogger(ClientHomeController.class);

    @Resource
    private ClientHomeService clientHomeService;

    /**
     * 查询首页轮播图
     * @return
     * @author linxianghang
     * @date 2020-04-22
     */
    @PostMapping("listRotationCharHome")
    public AppResponse listRotationCharHome(){
        try {
            return clientHomeService.listRotationCharHome();
        }catch (Exception e){
            logger.error("查询首页轮播图失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询首页热门位商品
     *
     * @param hotGoodsInfo
     * @return
     * @author linxianghang
     * @date 2020-04-22
     */
    @PostMapping("listHotGoods")
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        try {
            return clientHomeService.listHotGoods(hotGoodsInfo);
        }catch (Exception e){
            logger.error("查询首页热门位商品失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
