
package com.zx.mapper;

import com.zx.domain.TPlanner;

public interface TPlannerMapper {
    int deleteByPrimaryKey(Integer nid);

    int insert(TPlanner record);

    int insertSelective(TPlanner record);

    TPlanner selectByPrimaryKey(Integer nid);

    int updateByPrimaryKeySelective(TPlanner record);

    int updateByPrimaryKey(TPlanner record);
}