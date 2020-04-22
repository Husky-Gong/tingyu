package com.zx.service;

import com.zx.domain.TRole;
public interface TRoleService{


    int deleteByPrimaryKey(Integer rid);

    int insert(TRole record);

    int insertSelective(TRole record);

    TRole selectByPrimaryKey(Integer rid);

    int updateByPrimaryKeySelective(TRole record);

    int updateByPrimaryKey(TRole record);

}
