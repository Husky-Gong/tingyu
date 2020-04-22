package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.domain.TMarriedPerson;
import com.zx.mapper.TMarriedPersonMapper;
import com.zx.service.TMarriedPersonService;
@Service
public class TMarriedPersonServiceImpl implements TMarriedPersonService{

    @Resource
    private TMarriedPersonMapper tMarriedPersonMapper;

    @Override
    public int deleteByPrimaryKey(Integer pid) {
        return tMarriedPersonMapper.deleteByPrimaryKey(pid);
    }

    @Override
    public int insert(TMarriedPerson record) {
        return tMarriedPersonMapper.insert(record);
    }

    @Override
    public int insertSelective(TMarriedPerson record) {
        return tMarriedPersonMapper.insertSelective(record);
    }

    @Override
    public TMarriedPerson selectByPrimaryKey(Integer pid) {
        return tMarriedPersonMapper.selectByPrimaryKey(pid);
    }

    @Override
    public int updateByPrimaryKeySelective(TMarriedPerson record) {
        return tMarriedPersonMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TMarriedPerson record) {
        return tMarriedPersonMapper.updateByPrimaryKey(record);
    }

}
