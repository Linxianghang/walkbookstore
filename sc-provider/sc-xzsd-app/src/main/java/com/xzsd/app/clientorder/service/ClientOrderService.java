package com.xzsd.app.clientorder.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.app.clientorder.dao.ClientOrderDao;
import com.xzsd.app.clientorder.entity.ClientOrderInfo;
import com.xzsd.app.clientorder.entity.GoodsInfo;
import com.xzsd.app.userinformation.dao.UserInformationDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ClientOrderService
 * @author linxianghang
 * @date 2020-04-26
 */
@Service
public class ClientOrderService {
    @Resource
    private ClientOrderDao clientOrderDao;

    @Resource
    private UserInformationDao userInformationDao;

    /**
     * 新增订单
     * @param clientOrderInfo
     * @return
     * @author linxianghang
     * @date 2020-04-26
    /*@Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(ClientOrderInfo clientOrderInfo) {
        //分割字符,获取订单要新增的每个商品的详情
        List<String> goodsIdList = Arrays.asList(clientOrderInfo.getGoodsId().split(","));
        List<String> goodsPriceList = Arrays.asList(clientOrderInfo.getGoodsPrice().split(","));
        List<String> goodsNumList = Arrays.asList(clientOrderInfo.getClientGoodsNum().split(","));
        List<String> shopCartIdList = Arrays.asList(clientOrderInfo.getShopCartId().split(","));
        //看客户是否绑定邀请码
        String userInviteCode = userInformationDao.getUserInviteCode(clientOrderInfo.getUserId());
        if("".equals(userInviteCode)){
            return AppResponse.versionError("请您先绑定店铺邀请码");
        }
        clientOrderInfo.setOrderId(StringUtil.getCommonCode(2));
        //查询商品的库存情况
        List<GoodsInfo> listGoodsInventory = clientOrderDao.getListGoodsInventory(goodsIdList);
        List<ClientOrderInfo> orderInfoList = new ArrayList<>();
        int totalGoodsNum = 0;
        double totalGoodsPrice = 0;
        //遍历每一个商品，商品价格和购买数量
        for (int i = 0; i < goodsIdList.size() && i < goodsPriceList.size() &&  i < goodsNumList.size(); i++) {
            for(int j = 0; j < listGoodsInventory.size(); j++){
                if(listGoodsId.get(i).equals(listGoodsInventory.get(j).getGoodsId())){
                    //判断当前购买商品的商品是否超过商品的库存数量
                    if(listGoodsInventory.get(j).getGoodsInventory() < Integer.valueOf(listGoodsNum.get(i))){
                        return AppResponse.versionError("当前购买的商品已超过库存，请重新选择购买数量");
                    }
                    //库存数量减去当前购买的数量
                    listGoodsInventory.get(j).setGoodsInventory(listGoodsInventory.get(j).getGoodsInventory() - Integer.valueOf(listGoodsNum.get(i)));
                    //商品的销售量
                    listGoodsInventory.get(j).setSales(listGoodsInventory.get(j).getSales() + Integer.valueOf(listGoodsNum.get(i)));
                    //判断商品的库存是否等于0，如果等于0就把商品的状态改为（0：售罄）
                    if(listGoodsInventory.get(j).getGoodsInventory() == 0){
                        listGoodsInventory.get(j).setGoodsStatus("0");
                    }
                }
            }
            //计算订单总购买数
            totalGoodsNum = totalGoodsNum + Integer.valueOf(listGoodsNum.get(i));
            //计算订单总价格
            totalGoodsPrice = totalGoodsPrice + Double.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsNum.get(i));
            OrderInfo order = new OrderInfo();
            //设置订单详情表Id
            order.setOrderDetailsId(StringUtil.getCommonCode(2));
            //设置订单id
            order.setOrderId(orderInfo.getOrderId());
            //设置商品id
            order.setGoodsId(listGoodsId.get(i));
            order.setUserId(orderInfo.getUserId());
            //设置单个商品的购买数量
            order.setClientGoodsNum(listGoodsNum.get(i));
            //计算单个商品的总金额（购买数量 * 商品价格）
            Double totalPrice = Double.valueOf(listGoodsPrice.get(i)) * Integer.valueOf(listGoodsNum.get(i));
            order.setTotalGoodsPrice(String.valueOf(totalPrice));
            orderInfoList.add(order);
        }
        //设置订单总数
        clientOrderInfo.setOrderAllGoodsCount(totalGoodsNum);
        //设置订单总价
        clientOrderInfo.setOrderAllCost(String.valueOf(totalGoodsPrice));
        int count = clientOrderDao.addCustomerOrder(orderInfo);
        int num = clientOrderDao.addCustomerOrderGoodsInfo(orderInfoList);
        if(0 == count || 0 == num){
            return AppResponse.versionError("新增订单失败");
        }
        //更新商品库存和销售量，只有库存为0时再更新商品状态
        int goodsInventory = clientOrderDao.updateGoodsInventory(listGoodsInventory);
        if(0 == goodsInventory){
            return AppResponse.versionError("更新商品库存和销售量失败");
        }
        //删除购物车,只有购物车id不为0，才删除
        if(!"0".equals(shopCartIdList.get(0))){
            int shoppingCard = clientOrderDao.deleteShoppingCard(shopCartIdList, clientOrderInfo.getUserId());
            if(0 == shoppingCard){
                return AppResponse.versionError("删除购物车失败");
            }
        }
        return AppResponse.success("新增订单成功");
    }*/





}
