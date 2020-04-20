package com.xzsd.pc.topofcolumn.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topofcolumn.service.TopOfColumnService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TopOfColumnController
 * @author linxianghang
 * @date 2020-04-19
 */
@RestController
@RequestMapping("topOfColumn")
public class TopOfColumnController {


    private static final Logger logger = LoggerFactory.getLogger(TopOfColumnController.class);

    @Resource
    private TopOfColumnService topOfColumnService;

    /**
     *查询顶部栏
     *
     * @param
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-19
     */
    @PostMapping("getTopOfColumn")
    public AppResponse getTopOfColumn(){
            try {
                String loginUserId = SecurityUtils.getCurrentUserId();
                return topOfColumnService.getTopOfColumn(loginUserId);
            }catch (Exception e){
                logger.error("查询顶部栏失败");
                System.out.println(e.toString());
                throw e;
            }
        }

}
