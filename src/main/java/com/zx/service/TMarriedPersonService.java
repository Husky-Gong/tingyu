package com.zx.service;

import com.zx.domain.TMarriedPerson;
public interface TMarriedPersonService{


    int deleteByPrimaryKey(Integer pid);

    int insert(TMarriedPerson record);

    int insertSelective(TMarriedPerson record);

    TMarriedPerson selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(TMarriedPerson record);

    int updateByPrimaryKey(TMarriedPerson record);

}
