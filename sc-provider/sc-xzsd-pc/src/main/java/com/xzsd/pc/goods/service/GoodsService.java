package com.xzsd.pc.goods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.GoodsClassifyInfo;
import com.xzsd.pc.goods.entity.GoodsInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


/**
 * GoodsService
 * @author linxianghang
 * @date 2020-04-09
 */
@Service
public class GoodsService {
    @Resource
    private GoodsDao goodsDao;

    /**
     * 新增商品
     * @param goodsInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods(GoodsInfo goodsInfo){
        // 校验商品是否存在
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        goodsInfo.setGoodsId(StringUtil.getCommonCode(2));
        goodsInfo.setIsDelete(0);
        // 新增用户
        int count = goodsDao.addGoods(goodsInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询商品详情
     * @param goodsId
     * @return
     * @Author linxianghang
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getGoods(String goodsId) {
        GoodsInfo goodsInfo = goodsDao.getGoods(goodsId);
        return AppResponse.success("查询成功！",goodsInfo);
    }

    /**
     * 修改商品信息
     * @param goodsInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验商品是否存在
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        goodsInfo.setUpdateUser("1");
        int count = goodsDao.updateGoods(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * 修改商品状态
     * @param goodsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsShelfState(GoodsInfo goodsInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验商品是否存在
        /*int countUserAcct = goodsDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        goodsInfo.setUpdateUser("1");
        int count = goodsDao.updateGoodsShelfState(goodsInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除司机
     * @param goodsId
     * @param updateUser
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoods(String goodsId, String updateUser) {
        List<String> goodsCode = Arrays.asList(goodsId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = goodsDao.deleteGoods(goodsCode, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询商品列表（分页）
     * @param goodsInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listGoods(GoodsInfo goodsInfo) {
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsInfo> goodsInfoList = goodsDao.listGoodsByPage(goodsInfo);
        // 包装Page对象
        PageInfo<GoodsInfo> pageData = new PageInfo<GoodsInfo>(goodsInfoList);
        return AppResponse.success("查询成功！",pageData);
    }

    /**
     * 查询商品分类下拉框接口
     * @param classifyId
     * @return
     * @Author linxianghang
     * @Date 2020-04-11
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listGoodsClassify(String classifyId) {
        List<GoodsClassifyInfo> goodsClassifyList = goodsDao.listGoodsClassify(classifyId);
        return AppResponse.success("查询成功！",goodsClassifyList);
    }
}
