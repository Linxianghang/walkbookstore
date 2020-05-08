package com.xzsd.pc.goodsclassify.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goodsclassify.dao.GoodsClassifyDao;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyInfo;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyList;
import com.xzsd.pc.goodsclassify.entity.GoodsClassifyVO;
import com.xzsd.pc.goodsclassify.entity.SecondGoodsClassifyVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        goodsClassifyInfo.setClassifyId(StringUtil.getCommonCode(2));
        // 新增分类
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
        List<GoodsClassifyVO> listGoodsCategory = goodsClassifyDao.getListFirstAndSecondGoodsCategory();
        List<GoodsClassifyVO> goodsCategoryList = new ArrayList<>();
        //把二级分类拼接到一级分类上
        for (int i = 0; i < listGoodsCategory.size(); i++) {
            List<GoodsClassifyVO> secondCategoryList = new ArrayList<>();
            for (int j = 0; j < listGoodsCategory.size(); j++){
                if(listGoodsCategory.get(i).getClassifyId().equals(listGoodsCategory.get(j).getClassifyParent())){
                    secondCategoryList.add(listGoodsCategory.get(j));
                }
            }
            listGoodsCategory.get(i).setTwoClassifyList(secondCategoryList);
            //父级id为0就添加到集合里
            if("0".equals(listGoodsCategory.get(i).getClassifyParent())){
                goodsCategoryList.add(listGoodsCategory.get(i));
            }
        }
        GoodsClassifyList categoryList = new GoodsClassifyList();
        categoryList.setOneClassifyList(goodsCategoryList);
        return AppResponse.success("查询商品分类列表成功！", categoryList);
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
