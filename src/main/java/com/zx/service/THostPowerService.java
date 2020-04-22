package com.zx.service;

import com.zx.domain.THostPower;
public interface THostPowerService{


    int deleteByPrimaryKey(Integer hpid);

    int insert(THostPower record);

    int insertSelective(THostPower record);

    THostPower selectByPrimaryKey(Integer hpid);

    int updateByPrimaryKeySelective(THostPower record);

    int updateByPrimaryKey(THostPower record);

}
