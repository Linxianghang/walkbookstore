package com.xzsd.app.clienthome.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clienthome.dao.ClientHomeDao;
import com.xzsd.app.clienthome.entity.HotGoodsInfo;
import com.xzsd.app.clienthome.entity.HotGoodsVO;
import com.xzsd.app.clienthome.entity.SlideShowInfo;
import com.xzsd.app.clienthome.entity.SlideShowList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClientHomeService
 * @author linxianghang
 * @date 2020-04-22
 */
@Service
public class ClientHomeService {

    @Resource
    private ClientHomeDao clientHomeDao;

    /**
     * 查询首页轮播图
     * @return
     * @author linxianghang
     * @date 2020-4-22
     */
    public AppResponse listRotationCharHome(){
        List<SlideShowInfo> listSlideshow = clientHomeDao.listRotationCharHome();
        if(listSlideshow.size() == 0){
            return AppResponse.versionError("查询首页轮播图失败");
        }
        SlideShowList slideshowList = new SlideShowList();
        slideshowList.setSlideshowList(listSlideshow);
        return AppResponse.success("查询首页轮播图成功", slideshowList);
    }

    /**
     * 查询首页热门位商品
     *
     * @param hotGoodsInfo
     * @return
     * @author linxianghang
     * @date 2020-4-22
     */
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo){
        //获取热门位商品展示数量
        int number = clientHomeDao.getSlideShowNumber();
        if(0 == number){
            return AppResponse.success("查询热门位商品数量成功", null);
        }
        hotGoodsInfo.setShowNumber(number);
        //分页
        PageHelper.startPage(hotGoodsInfo.getPageNum(), hotGoodsInfo.getPageSize());
        List<HotGoodsVO> listHotGoods = clientHomeDao.listHotGoods(hotGoodsInfo);
        PageInfo<HotGoodsVO> pageData = new PageInfo<>(listHotGoods);
        return AppResponse.success("查询热门位商品成功", pageData);
    }

}
