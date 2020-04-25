package com.xzsd.app.shoppingcart.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.app.shoppingcart.entity.ShoppingCartInfo;
import com.xzsd.app.shoppingcart.service.ShoppingCartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ShoppingCartController
 * @author linxianghang
 * @date 2020-04-24
 */
@RestController
@RequestMapping("/clientShopCart")
public class ShoppingCartController {
    private static final Logger logger = LoggerFactory.getLogger(ShoppingCartController.class);

    @Resource
    private ShoppingCartService shoppingCartService;

    /**
     * 新增购物车
     *
     * @param shoppingCartInfo
     * @return
     * @author linxianghang
     * @date 2020-04-24
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShoppingCartInfo shoppingCartInfo){
        try {
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCartInfo.setUserId(userId);
            return shoppingCartService.addShoppingCart(shoppingCartInfo);
        }catch (Exception e){
            logger.error("新增购物车失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询购物车
     *
     * @param shoppingCartInfo
     * @return
     * @author linxianghang
     * @date 2020-04-24
     */
    @PostMapping("listShoppingCarts")
    public AppResponse listShoppingCarts(ShoppingCartInfo shoppingCartInfo){
        try {
            //获取登录人身份
            String userId = SecurityUtils.getCurrentUserId();
            shoppingCartInfo.setUserId(userId);
            return shoppingCartService.listShoppingCarts(shoppingCartInfo);
        }catch (Exception e){
            logger.error("查询购物车失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车
     *
     * @param shoppingCartInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-24
     */
    @PostMapping("updateShoppingCart")
    public AppResponse updateShoppingCart(ShoppingCartInfo shoppingCartInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            shoppingCartInfo.setUserId(userId);
            return shoppingCartService.updateShoppingCart(shoppingCartInfo);
        } catch (Exception e) {
            logger.error("修改商品信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车
     *
     * @param shopCartId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-24
     */
    @PostMapping("deleteShoppingCart")
    public AppResponse deleteShoppingCart(String shopCartId) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            return shoppingCartService.deleteShoppingCart(shopCartId,userId);
        } catch (Exception e) {
            logger.error("购物车删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
