package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.domain.TAdmin;
import com.zx.mapper.TAdminMapper;
import com.zx.service.TAdminService;
@Service
public class TAdminServiceImpl implements TAdminService{

    @Resource
    private TAdminMapper tAdminMapper;

    @Override
    public int deleteByPrimaryKey(Integer aid) {
        return tAdminMapper.deleteByPrimaryKey(aid);
    }

    @Override
    public int insert(TAdmin record) {
        return tAdminMapper.insert(record);
    }

    @Override
    public int insertSelective(TAdmin record) {
        return tAdminMapper.insertSelective(record);
    }

    @Override
    public TAdmin selectByPrimaryKey(Integer aid) {
        return tAdminMapper.selectByPrimaryKey(aid);
    }

    @Override
    public int updateByPrimaryKeySelective(TAdmin record) {
        return tAdminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TAdmin record) {
        return tAdminMapper.updateByPrimaryKey(record);
    }

}
