package com.xzsd.pc.menu.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class MenuService {

    @Resource
    private MenuDao menuDao;

    /**
     * 新增菜单
     *
     * @param menuInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo) {
        //验证菜单是否存在
        menuInfo.setMenuId(StringUtil.getCommonCode(2));
        menuInfo.setIsDelete(0);
        // 新增用户
        int count = menuDao.addMenu(menuInfo);
        if (0 == count) {
            return AppResponse.bizError("新增失败，请重试！");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询菜单详情
     *
     * @param menuId
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse getMenu(String menuId) {
        MenuInfo menuInfo = menuDao.getMenu(menuId);
        return AppResponse.success("查询成功！", menuInfo);
    }

    /**
     * 修改菜单信息
     * @param menuInfo
     * @return
     * @Author linxianghang
     * @Date 2020-04-09
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        // 校验菜单是否存在
        /*int countUserAcct = userDao.countUserAcct(userInfo);
        if(countUserAcct > 1 || countUserAcct == 0) {
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }*/
        // 修改用户信息
        menuInfo.setUpdateUser("1");
        int count = menuDao.updateMenu(menuInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("修改失败");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 删除司机
     * @param menuId
     * @param updateUser
     * @return
     * @Author linxianghang
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu(String menuId, String updateUser) {
        List<String> listCode = Arrays.asList(menuId.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除用户
        int count = menuDao.deleteMenu(listCode, updateUser);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * demo 查询菜单
     * @param
     * @return
     * @Author linxianghang
     * @Date 2020-04-10
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse listMenus() {
        List<MenuInfo> menuInfo = menuDao.listMenus();
        return AppResponse.success("查询成功！",menuInfo);
    }


}
