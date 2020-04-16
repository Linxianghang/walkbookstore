package com.xzsd.pc.hotgoods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
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
}
