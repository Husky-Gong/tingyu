package com.zx.service;

import com.zx.domain.TMenu;
public interface TMenuService{


    int deleteByPrimaryKey(Integer mid);

    int insert(TMenu record);

    int insertSelective(TMenu record);

    TMenu selectByPrimaryKey(Integer mid);

    int updateByPrimaryKeySelective(TMenu record);

    int updateByPrimaryKey(TMenu record);

}
