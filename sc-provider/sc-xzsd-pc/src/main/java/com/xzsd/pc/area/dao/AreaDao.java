package com.xzsd.pc.area.dao;

import com.xzsd.pc.area.entity.AreaInfo;
import com.xzsd.pc.area.entity.AreaVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * AreaDao
 * @author linxianghang
 * @date 2020-04-16
 */
@Mapper
public interface AreaDao {
    /**
     * 查询省市区
     * @param areaInfo
     * @return
     */
    List<AreaVO> getListArea(AreaInfo areaInfo);
}
