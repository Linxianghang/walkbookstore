package com.xzsd.pc.slideshow.dao;

import com.xzsd.pc.slideshow.entity.SlideShowInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * SlideShowDao
 * @author linxianghang
 * @date 2020-04-12
 */
@Mapper
public interface SlideShowDao {
    /**
     * 新增首页轮播图
     * @param slideShowInfo
     * @return
     */
    int addSlideshowHome(SlideShowInfo slideShowInfo);

    /**
     * 修改轮播图状态
     * @param slideInfoList
     * @return
     */
    int updateSlideshowHomeState(@Param("slideInfoList") List<SlideShowInfo> slideInfoList);

    /**
     * 删除首页轮播图
     * @param userId
     * @return
     */
    int deleteSlideshowHome(@Param("listcode") List<String> listcode, @Param("userId") String userId);

    /**
     * 分页查询商品
     * @param slideShowInfo
     * @return
     */
    List<SlideShowInfo> listGoodsByPage(SlideShowInfo slideShowInfo);

    /**
     * 分页查询首页轮播图
     * @param slideShowInfo
     * @return
     */
    List<SlideShowInfo> listSlideshowHomeByPage(SlideShowInfo slideShowInfo);




}
