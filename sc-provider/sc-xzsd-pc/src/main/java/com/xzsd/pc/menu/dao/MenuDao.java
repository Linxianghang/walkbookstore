package com.xzsd.pc.menu.dao;


import com.xzsd.pc.menu.entity.MenuInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {
    /**
     * 验证是否存在相同菜单
     */
    int isMenuExist(MenuInfo menuInfo);

    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    int addMenu(MenuInfo menuInfo);

    /**
     * 查询菜单
     * @param menuId
     * @return
     */
    MenuInfo getMenu(@Param("menuId") String menuId);

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    int updateMenu(MenuInfo menuInfo);

    /**
     * 删除菜单表
     * @param userId
     * @return
     */
    int deleteMenu(@Param("listcode") List<String> listcode, @Param("userId") String userId);

    /**
     * 查询菜单列表
     * @return
     */
    List<MenuInfo> listMenus();


}
