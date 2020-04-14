package com.xzsd.pc.slideshow.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.slideshow.entity.SlideShowInfo;
import com.xzsd.pc.slideshow.service.SlideShowService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("slideshowHome")
public class SlideShowController {

    private static final Logger logger = LoggerFactory.getLogger(SlideShowController.class);

    @Resource
    private SlideShowService slideShowService;

    /**
     * 新增首页轮播图
     *
     * @param slideShowInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-12
     */
    @PostMapping("addSlideshowHome")
    public AppResponse addSlideshowHome(SlideShowInfo slideShowInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            slideShowInfo.setCreateUser(userId);
            AppResponse appResponse = slideShowService.addSlideshowHome(slideShowInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("首页轮播图新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改首页轮播图状态
     *
     * @param slideShowInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("updateSlideshowHomeState")
    public AppResponse updateSlideshowHomeState(SlideShowInfo slideShowInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            slideShowInfo.setUpdateUser(userId);
            return slideShowService.updateSlideshowHomeState(slideShowInfo);
        } catch (Exception e) {
            logger.error("修改首页轮播图状态错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除首页轮播图
     *
     * @param slideshowId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("deleteSlideshowHome")
    public AppResponse deleteSlideshowHome(String slideshowId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return slideShowService.deleteSlideshowHome(slideshowId,updateUser);
        } catch (Exception e) {
            logger.error("首页轮播图删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  商品列表(分页)
     *
     * @param slideShowInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @RequestMapping(value = "listGoods")
    public AppResponse listGoods(SlideShowInfo slideShowInfo) {
        try {
            return slideShowService.listGoods(slideShowInfo);
        } catch (Exception e) {
            logger.error("查询商品列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  分页查询首页轮播图
     *
     * @param slideShowInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-13
     */
    @RequestMapping(value = "listSlideshowHome")
    public AppResponse listSlideshowHome(SlideShowInfo slideShowInfo) {
        try {
            return slideShowService.listSlideshowHome(slideShowInfo);
        } catch (Exception e) {
            logger.error("查询首页轮播图异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
