package com.xzsd.pc.menu.controller;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * MenuController
 * @author linxianghang
 * @date 2020-04-09
 */
@RestController
@RequestMapping("/menu")
public class MenuController {
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @Resource
    private MenuService menuService;

    /**
     *  新增菜单
     *
     * @param menuInfo
     * @return AppResponse
     * @author dingning
     * @Date 2020-03-21
     */
    @PostMapping("addMenu")
    public AppResponse addDriver(MenuInfo menuInfo) {
        try {
            //获取用户id
            String userId = AuthUtils.getCurrentUserId();
            menuInfo.setCreateUser(userId);
            AppResponse appResponse = menuService.addMenu(menuInfo);
            return appResponse;
        } catch (Exception e) {
            logger.error("菜单新增失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *查询菜单
     *
     * @param menuId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("getMenu")
    public AppResponse getMenu(String menuId){
        try{
            return menuService.getMenu(menuId);
        } catch (Exception e){
            logger.error("查询菜单失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户
     *
     * @param menuInfo
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            menuInfo.setUpdateUser(userId);
            return menuService.updateMenu(menuInfo);
        } catch (Exception e) {
            logger.error("修改菜单信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除菜单
     *
     * @param menuId
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-09
     */
    @PostMapping("deleteMenu")
    public AppResponse deleteMenu(String menuId) {
        try {
            //获取用户id
            String updateUser = AuthUtils.getCurrentUserId();
            return menuService.deleteMenu(menuId,updateUser);
        } catch (Exception e) {
            logger.error("菜单删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *  菜单列表
     *
     * @param
     * @return AppResponse
     * @author linxianghang
     * @Date 2020-04-10
     */
    @RequestMapping(value = "listMenu")
    public AppResponse listMenu() {
        try {
            return menuService.listMenu();
        } catch (Exception e) {
            logger.error("查询菜单列表异常", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 根据角色查询菜单
     * @param role
     * @return
     * @author linxianghang
     * @date 2020-4-22
     */
    @PostMapping("listMenuHome")
    public AppResponse listMenuHome(String role){
        try {
            return menuService.listMenuHome(role);
        }catch (Exception e){
            logger.error("根据角色查询菜单失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
