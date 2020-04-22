package com.zx.mapper;

import com.zx.domain.TMarriedPerson;

public interface TMarriedPersonMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(TMarriedPerson record);

    int insertSelective(TMarriedPerson record);

    TMarriedPerson selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(TMarriedPerson record);

    int updateByPrimaryKey(TMarriedPerson record);
}