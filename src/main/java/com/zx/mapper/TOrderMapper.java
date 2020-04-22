package com.zx.mapper;

import com.zx.domain.TOrder;

public interface TOrderMapper {
    int deleteByPrimaryKey(Integer oid);

    int insert(TOrder record);

    int insertSelective(TOrder record);

    TOrder selectByPrimaryKey(Integer oid);

    int updateByPrimaryKeySelective(TOrder record);

    int updateByPrimaryKey(TOrder record);
}