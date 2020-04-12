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
     * 新增司机
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
            logger.error("用户新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
