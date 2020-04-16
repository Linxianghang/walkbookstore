package com.xzsd.pc.area.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.area.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * AreaController
 * @author linxianghang
 * @date 2020-04-16
 */
@RestController
@RequestMapping("/selectCombox")
public class AreaController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Resource
    private AreaService areaService;

    /**
     * 查询省市区信息
     * @param areaInfo
     * @return
     * @author zhaorujie
     * @Date 2020-03-25
     */
    @PostMapping("listArea")
    public AppResponse getListArea(AreaInfo areaInfo){
        try {
            return areaService.getListArea(areaInfo);
        }catch (Exception e){
            logger.error("查询省市区信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}