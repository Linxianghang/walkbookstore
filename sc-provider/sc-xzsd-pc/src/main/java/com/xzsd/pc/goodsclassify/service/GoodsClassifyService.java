package com.xzsd.pc.goodsclassify.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goodsclassify.dao.GoodsClassifyDao;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * GoodsClassifyService
 * @author linxianghang
 * @date 2020-04-13
 */
@Service
public class GoodsClassifyService {
    @Resource
    private GoodsClassifyDao goodsClassifyDao;

    /**
     * 新增商品分类
     * @param goodsClassifyInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoodsClassify(GoodsClassifyInfo goodsClassifyInfo){
        // 校验账号是否存在
        /*int countUserAcct = userDao.countUserAcct(userInfo);
        if(0 != countUserAcct) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        goodsClassifyInfo.setClassifyId(StringUtil.getCommonCode(2));
        goodsClassifyInfo.setIsDelete(0);
        // 新增用户
        int count = goodsClassifyDao.addGoodsClassify(goodsClassifyInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询商品分类详情
     * @param classifyId
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getGoodsClassify(String classifyId) {
        GoodsClassifyInfo goodsClassifyInfo = goodsClassifyDao.getGoodsClassify(classifyId);
        return AppResponse.success("查询成功！",goodsClassifyInfo);
    }

    /**
     * 查询商品分类列表
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listAllGoodsClassify() {
        List<GoodsClassifyInfo> goodsClassifyInfo = goodsClassifyDao.listAllGoodsClassify();
        return AppResponse.success("查询成功！",goodsClassifyInfo);
    }

    /**
     * 修改商品分类信息
     * @param goodsClassifyInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-13
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoodsClassify(GoodsClassifyInfo goodsClassifyInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验账号是否存在
       /* int countUserAcct = userDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        goodsClassifyInfo.setUpdateUser("1");
        int count = goodsClassifyDao.updateGoodsClassify(goodsClassifyInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除商品分类
     * @param classifyId
     * @param updateUser
     * @return
     * @Author dingning
     * @Date 2020-03-21
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteGoodsClassify(String classifyId, String updateUser) {
        List<String> classifyCode = Arrays.asList(classifyId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = goodsClassifyDao.deleteGoodsClassify(classifyCode, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
