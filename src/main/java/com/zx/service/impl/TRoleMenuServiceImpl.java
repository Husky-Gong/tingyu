package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TRoleMenuMapper;
import com.zx.domain.TRoleMenu;
import com.zx.service.TRoleMenuService;
@Service
public class TRoleMenuServiceImpl implements TRoleMenuService{

    @Resource
    private TRoleMenuMapper tRoleMenuMapper;

    @Override
    public int insert(TRoleMenu record) {
        return tRoleMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(TRoleMenu record) {
        return tRoleMenuMapper.insertSelective(record);
    }

}
