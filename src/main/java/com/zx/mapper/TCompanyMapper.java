package com.zx.mapper;

import com.zx.domain.TCompany;

public interface TCompanyMapper {
    int deleteByPrimaryKey(Integer cid);

    int insert(TCompany record);

    int insertSelective(TCompany record);

    TCompany selectByPrimaryKey(Integer cid);

    int updateByPrimaryKeySelective(TCompany record);

    int updateByPrimaryKey(TCompany record);
}