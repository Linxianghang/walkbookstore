package com.xzsd.app.managerinformation.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.managerinformation.dao.ManagerInfomationDao;
import com.xzsd.app.managerinformation.entity.ManagerInfo;
import com.xzsd.app.managerinformation.entity.ManagerInfoList;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * ManagerInfomationService
 * @author linxianghang
 * @date 2020-04-27
 */
@Service
public class ManagerInfomationService {
    @Resource
    private ManagerInfomationDao managerInfomationDao;

    /**
     * 查询店长门下的司机信息
     * @param userId
     * @return
     * @author linxianghang
     * @date 2020-04-27
     */
    public AppResponse listManagerDrivers(String userId){
        List<ManagerInfo> listDriver = managerInfomationDao.listManagerDrivers(userId);
        if(0 == listDriver.size()){
            return AppResponse.versionError("此店长所管门店下没有司机");
        }
        //封装数据
        ManagerInfoList list = new ManagerInfoList();
        list.setList(listDriver);
        return AppResponse.success("查询司机信息列表成功", list);
    }
}
