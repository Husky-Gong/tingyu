package com.zx.service;

import com.zx.domain.THost;
public interface THostService{


    int deleteByPrimaryKey(Integer hid);

    int insert(THost record);

    int insertSelective(THost record);

    THost selectByPrimaryKey(Integer hid);

    int updateByPrimaryKeySelective(THost record);

    int updateByPrimaryKey(THost record);

}
