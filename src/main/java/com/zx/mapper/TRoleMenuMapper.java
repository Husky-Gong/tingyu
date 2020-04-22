package com.zx.mapper;

import com.zx.domain.TRoleMenu;

public interface TRoleMenuMapper {
    int insert(TRoleMenu record);

    int insertSelective(TRoleMenu record);
}