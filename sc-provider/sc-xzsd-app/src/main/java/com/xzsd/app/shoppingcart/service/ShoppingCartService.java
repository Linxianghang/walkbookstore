package com.xzsd.app.shoppingcart.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.shoppingcart.dao.ShoppingCartDao;
import com.xzsd.app.shoppingcart.entity.ShoppingCartInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * ShoppingCartService
 * @author linxianghang
 * @date 2020-04-24
 */
@Service
public class ShoppingCartService {
    @Resource
    private ShoppingCartDao shoppingCartDao;

    /**
     * 新增购物车
     * @param shoppingCartInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addShoppingCart(ShoppingCartInfo shoppingCartInfo){
        // 新增购物车时检查要添加的商品是否存库足够
        int goodsCount = shoppingCartDao.countGoodsCount(shoppingCartInfo);
        int goodsNeedCount = shoppingCartInfo.getCartGoodsCount();
        if(goodsNeedCount > goodsCount){
            return AppResponse.versionError("要添加的商品库存不足，请重试！");
        }
        shoppingCartInfo.setShopCartId(StringUtil.getCommonCode(3));
        // 新增用户
        int count = shoppingCartDao.addShoppingCart(shoppingCartInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询购物车(分页)
     * @param
     * @return
     * @author linxianghang
     * @data 2020-04-24
     *
     */
    public AppResponse listShoppingCarts(ShoppingCartInfo shoppingCartInfo){
        //分页
        PageHelper.startPage(shoppingCartInfo.getPageNum(), shoppingCartInfo.getPageSize());
        List<ShoppingCartInfo> listGoodsEvaluation = shoppingCartDao.listShoppingCarts(shoppingCartInfo);
        PageInfo<ShoppingCartInfo> pageData = new PageInfo<>(listGoodsEvaluation);
        return AppResponse.success("查询购物车成功",pageData);
    }

    /**
     * 修改购物车
     * @param shoppingCartInfo
     * @return
     * @author linxianghang
     * @data 2020-04-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateShoppingCart(ShoppingCartInfo shoppingCartInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        int count = shoppingCartDao.updateShoppingCart(shoppingCartInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除购物车
     * @param shopCartId
     * @param userId
     * @return
     * @Author linxianghang
     * @Date 2020-04-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteShoppingCart(String shopCartId, String userId) {
        List<String> shopCartIdList = Arrays.asList(shopCartId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店
        int count = shoppingCartDao.deleteShoppingCart(shopCartIdList, userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

}
