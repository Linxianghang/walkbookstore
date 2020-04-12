package com.xzsd.pc.slideshow.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.slideshow.dao.SlideShowDao;
import com.xzsd.pc.slideshow.entity.SlideShowInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class SlideShowService {

    @Resource
    private SlideShowDao slideShowDao;
    /**
     * 新增用户
     * @param slideShowInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-12
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addSlideshowHome(SlideShowInfo slideShowInfo){
        // 校验账号是否存在
        /*int countUserAcct = slideShowDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        slideShowInfo.setSlideshowId(StringUtil.getCommonCode(2));
        slideShowInfo.setIsDelete(0);
        // 新增用户
        int count = slideShowDao.addSlideshowHome(slideShowInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }
}
