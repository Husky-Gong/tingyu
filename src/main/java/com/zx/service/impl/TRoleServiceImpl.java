package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TRoleMapper;
import com.zx.domain.TRole;
import com.zx.service.TRoleService;
@Service
public class TRoleServiceImpl implements TRoleService{

    @Resource
    private TRoleMapper tRoleMapper;

    @Override
    public int deleteByPrimaryKey(Integer rid) {
        return tRoleMapper.deleteByPrimaryKey(rid);
    }

    @Override
    public int insert(TRole record) {
        return tRoleMapper.insert(record);
    }

    @Override
    public int insertSelective(TRole record) {
        return tRoleMapper.insertSelective(record);
    }

    @Override
    public TRole selectByPrimaryKey(Integer rid) {
        return tRoleMapper.selectByPrimaryKey(rid);
    }

    @Override
    public int updateByPrimaryKeySelective(TRole record) {
        return tRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TRole record) {
        return tRoleMapper.updateByPrimaryKey(record);
    }

}
