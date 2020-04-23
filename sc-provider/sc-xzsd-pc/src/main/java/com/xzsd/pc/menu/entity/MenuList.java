package com.xzsd.pc.menu.entity;

import java.util.List;

/**
 * 解决前端访问不到菜单 MenuList
 * @author linxianghang
 * @date 2020-04-22
 */
public class MenuList {

    List<MenuInfo> menuList;

    public List<MenuInfo> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuInfo> menuList) {
        this.menuList = menuList;
    }
}
