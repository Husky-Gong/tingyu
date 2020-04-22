package com.zx.service;

import com.zx.domain.TAdmin;
public interface TAdminService{


    int deleteByPrimaryKey(Integer aid);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    TAdmin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);

}
