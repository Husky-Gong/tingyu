package com.zx.mapper;

import com.zx.domain.THost;

public interface THostMapper {
    int deleteByPrimaryKey(Integer hid);

    int insert(THost record);

    int insertSelective(THost record);

    THost selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(THost record);

    int updateByPrimaryKey(THost record);
}