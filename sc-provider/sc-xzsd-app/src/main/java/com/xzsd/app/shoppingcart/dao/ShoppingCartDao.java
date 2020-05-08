package com.xzsd.app.shoppingcart.dao;

import com.xzsd.app.shoppingcart.entity.ShoppingCartInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ShoppingCartDao
 * @author linxianghang
 * @date 2020-04-24
 */
@Mapper
public interface ShoppingCartDao {
    /**
     * 新增购物车
     * @param shoppingCartInfo
     * @return
     */
    int addShoppingCart(ShoppingCartInfo shoppingCartInfo);

    /**
     * 查询购物车接口
     * @param shoppingCartInfo
     * @return
     */
    List<ShoppingCartInfo> listShoppingCarts(ShoppingCartInfo shoppingCartInfo);

    /**
     * 修改购物车
     * @param shoppingCartInfo
     * @return
     */
    int updateShoppingCart(ShoppingCartInfo shoppingCartInfo);

    /**
     * 删除购物车
     * @param listcode
     * @param userId
     * @return
     */
    int deleteShoppingCart(@Param("listcode") List<String> listcode, @Param("userId") String userId);

}
