package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TAdminRoleMapper;
import com.zx.domain.TAdminRole;
import com.zx.service.TAdminRoleService;
@Service
public class TAdminRoleServiceImpl implements TAdminRoleService{

    @Resource
    private TAdminRoleMapper tAdminRoleMapper;

    @Override
    public int insert(TAdminRole record) {
        return tAdminRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(TAdminRole record) {
        return tAdminRoleMapper.insertSelective(record);
    }

}
