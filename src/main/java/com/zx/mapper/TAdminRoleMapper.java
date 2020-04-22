package com.zx.mapper;

import com.zx.domain.TAdminRole;

public interface TAdminRoleMapper {
    int insert(TAdminRole record);

    int insertSelective(TAdminRole record);
}