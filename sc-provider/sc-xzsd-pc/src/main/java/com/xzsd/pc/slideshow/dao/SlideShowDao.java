package com.xzsd.pc.slideshow.dao;

import com.xzsd.pc.slideshow.entity.SlideShowInfo;
import org.apache.ibatis.annotations.Mapper;

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



}
