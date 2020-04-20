package com.xzsd.pc.topofcolumn.service;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.topofcolumn.dao.TopOfColumnDao;
import com.xzsd.pc.topofcolumn.entity.TopOfColumnInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TopOfColumnService
 * @author linxianghang
 * @date 2020-04-19
 */
@Service
public class TopOfColumnService {
    @Resource
    private TopOfColumnDao topOfColumnDao;

    /**
     * 查询顶部栏
     * @param loginUserId
     * @return
     * @author zhaorujie
     * @date 2020/4/9
     */
    public AppResponse getTopOfColumn(String loginUserId){
        TopOfColumnInfo topColumn = topOfColumnDao.getTopOfColumn(loginUserId);
        if(null == topColumn){
            return AppResponse.versionError("查询顶部栏失败");
        }
        return AppResponse.success("查询顶部栏成功", topColumn);
    }
}
