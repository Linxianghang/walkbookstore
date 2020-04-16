package com.xzsd.pc.hotgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotgoods.dao.HotGoodsDao;
import com.xzsd.pc.hotgoods.entity.HotGoodsInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsShowNumberInfo;
import com.xzsd.pc.hotgoods.entity.HotGoodsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * HotGoodsService
 * @author linxianghang
 * @date 2020-04-16
 */
@Service
public class HotGoodsService {
    @Resource
    private HotGoodsDao hotGoodsDao;

    /**
     * 新增热门商品
     * @param hotGoodsInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotGoods(HotGoodsInfo hotGoodsInfo){
        // 校验商品是否存在
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        hotGoodsInfo.setHotGoodsId(StringUtil.getCommonCode(2));
        hotGoodsInfo.setIsDelete(0);
        // 新增用户
        int count = hotGoodsDao.addHotGoods(hotGoodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询商品详情
     * @param hotGoodsId
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getHotGoods(String hotGoodsId) {
        HotGoodsVO hotGoodsVO = hotGoodsDao.getHotGoods(hotGoodsId);
        return AppResponse.success("查询成功！",hotGoodsVO);
    }

    /**
     * 查询商品列表（分页）
     * @param hotGoodsInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listHotGoods(HotGoodsInfo hotGoodsInfo) {
        PageHelper.startPage(hotGoodsInfo.getPageNum(), hotGoodsInfo.getPageSize());
        List<HotGoodsVO> hotGoodsVOList = hotGoodsDao.listHotGoodsByPage(hotGoodsInfo);
        // 包装Page对象
        PageInfo<HotGoodsVO> pageData = new PageInfo<HotGoodsVO>(hotGoodsVOList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 修改热门商品信息
     * @param hotGoodsInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoods(HotGoodsInfo hotGoodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验热门商品是否存在 待写！！！！
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        hotGoodsInfo.setUpdateUser("1");
        int count = hotGoodsDao.updateHotGoods(hotGoodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 查询热门位商品展示数量
     * @param
     * @return
     * @Author linxianghang
     * @Date 2020-04-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getHotGoodsShowNum() {
        HotGoodsShowNumberInfo hotGoodsShowNumberInfo = hotGoodsDao.getHotGoodsShowNum();
        return AppResponse.success("查询成功！",hotGoodsShowNumberInfo);
    }

    /**
     * 修改热门位商品展示数量
     * @param
     * @return
     * @Author linxianghang
     * @Date 2020-04-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotGoodsShowNum(HotGoodsShowNumberInfo hotGoodsShowNumberInfo) {
        AppResponse appResponse = AppResponse.success("修改热门位商品展示数量成功！");
        int count = hotGoodsDao.updateHotGoodsShowNum(hotGoodsShowNumberInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改热门位商品展示数量失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除热门商品
     * @param hotGoodsId
     * @param updateUser
     * @return
     * @Author linxianghang
     * @Date 2020-04-16
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteHotGoods(String hotGoodsId, String updateUser) {
        List<String> deleteHotGoodList = Arrays.asList(hotGoodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = hotGoodsDao.deleteHotGoods(deleteHotGoodList, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
