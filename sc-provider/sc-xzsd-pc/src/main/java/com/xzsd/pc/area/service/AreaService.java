package com.xzsd.pc.area.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.area.dao.AreaDao;
import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.area.entity.AreaVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * AreaService
 * @author linxianghang
 * @date 2020-04-16
 */
@Service
public class AreaService {
    @Resource
    private AreaDao areaDao;

    /**
     * 查询省市区信息
     * @param areaInfo
     * @return
     * @Author linxianghang
     * @Date 2020-03-25
     */
    public AppResponse getListArea(AreaInfo areaInfo){
        List<AreaVO> areaList = areaDao.getListArea(areaInfo);
        if(areaList.size() == 0){
            return AppResponse.bizError("查询失败！");
        }
        return AppResponse.success("查询成功！", areaList);
    }
}
