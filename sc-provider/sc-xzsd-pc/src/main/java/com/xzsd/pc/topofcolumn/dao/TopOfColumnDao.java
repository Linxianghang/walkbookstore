package com.xzsd.pc.topofcolumn.dao;

import com.xzsd.pc.topofcolumn.entity.TopOfColumnInfo;
import org.apache.ibatis.annotations.Param;

/**
 * TopOfColumnDao
 * @author linxianghang
 * @date 2020-04-19
 */
public interface TopOfColumnDao {
    /**
     * 查询顶部栏
     * @param loginUserId
     * @return
     */
    TopOfColumnInfo getTopOfColumn(@Param("loginUserId") String loginUserId);

}
