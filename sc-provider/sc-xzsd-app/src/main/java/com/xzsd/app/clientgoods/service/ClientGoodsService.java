package com.xzsd.app.clientgoods.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.clientgoods.dao.ClientGoodsDao;
import com.xzsd.app.clientgoods.entity.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ClientGoodsService
 * @author linxianghang
 * @date 2020-04-23
 */
@Service
public class ClientGoodsService {
    @Resource
    private ClientGoodsDao clientGoodsDao;

    /**
     * 查询商品详情
     *
     * @param goodsId
     * @return
     * @author linxianghang
     * @data 2020-04-23
     */
    public AppResponse getGoods(String goodsId){
        GoodsInfo goodsInfo = clientGoodsDao.getGoods(goodsId);
        if(null == goodsInfo){
            return AppResponse.versionError("查询商品详情失败");
        }
        return AppResponse.success("查询商品详情成功", goodsInfo);
    }

    /**
     * 查询商品评价
     * @param goodsEvaluationInfo
     * @return
     * @author linxianghang
     * @data 2020-04-24
     *
     */
    public AppResponse listGoodsEvaluates(GoodsEvaluationInfo goodsEvaluationInfo){
        //分页
        PageHelper.startPage(goodsEvaluationInfo.getPageNum(), goodsEvaluationInfo.getPageSize());
        //查询当前商品的所有评价
        List<GoodsEvaluationInfo> listGoodsEvaluation = clientGoodsDao.listGoodsEvaluates(goodsEvaluationInfo);
        PageInfo<GoodsEvaluationInfo> pageData = new PageInfo<>(listGoodsEvaluation);
        return AppResponse.success("查询商品评价成功",pageData);
    }

    /**
     * 获取商品一级分类
     * @return
     * @author linxianghang
     * @data 2020-04-23
     */
    public AppResponse listOneGoodsClassify(){
        List<GoodsCategory> firstGoodsCategory = clientGoodsDao.listOneGoodsClassify();
        if(0 == firstGoodsCategory.size()){
            return AppResponse.versionError("获取商品一级分类失败");
        }
        //封装数据
        OneClassifyList oneClassifyList = new OneClassifyList();
        oneClassifyList.setOneClassifyList(firstGoodsCategory);
        return AppResponse.success("获取商品一级分类成功", oneClassifyList);
    }

    /**
     * 获取商品二级分类及商品
     * @param classifyId
     * @return
     * @author linxianghang
     * @data 2020-04-23
     */
    public AppResponse listGetClassGoods(String classifyId){
        List<GoodsCategory> secondGoodsCategory = clientGoodsDao.listGetClassGoods(classifyId);
        if(0 == secondGoodsCategory.size()){
            return AppResponse.versionError("获取商品二级分类及商品失败");
        }
        //封装数据
        TwoClassifyList twoClassifyList = new TwoClassifyList();
        twoClassifyList.setTwoClassifyList(secondGoodsCategory);
        return AppResponse.success("获取商品二级分类及商品成功", twoClassifyList);
    }

}
