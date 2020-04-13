package com.xzsd.pc.slideshow.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.slideshow.dao.SlideShowDao;
import com.xzsd.pc.slideshow.entity.SlideShowInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

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

    /**
     * 修改首页轮播图状态
     * @param slideShowInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSlideshowHomeState(SlideShowInfo slideShowInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
        /*int countUserAcct = userDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改首页轮播图
        slideShowInfo.setUpdateUser("1");
        int count = slideShowDao.updateSlideshowHomeState(slideShowInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除首页轮播图
     * @param slideshowId
     * @param updateUser
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSlideshowHome(String slideshowId, String updateUser) {
        List<String> listCode = Arrays.asList(slideshowId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = slideShowDao.deleteSlideshowHome(listCode, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询商品列表（分页）
     * @param slideShowInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listGoods(SlideShowInfo slideShowInfo) {
        PageHelper.startPage(slideShowInfo.getPageNum(), slideShowInfo.getPageSize());
        List<SlideShowInfo> goodsInfoList = slideShowDao.listGoodsByPage(slideShowInfo);
        // 包装Page对象
        PageInfo<SlideShowInfo> pageData = new PageInfo<SlideShowInfo>(goodsInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * demo 分页查询首页轮播图
     * @param slideShowInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listSlideshowHome(SlideShowInfo slideShowInfo) {
        PageHelper.startPage(slideShowInfo.getPageNum(), slideShowInfo.getPageSize());
        List<SlideShowInfo> slideshowInfoList = slideShowDao.listSlideshowHomeByPage(slideShowInfo);
        // 包装Page对象
        PageInfo<SlideShowInfo> pageData = new PageInfo<SlideShowInfo>(slideshowInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

}
