package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.THostMapper;
import com.zx.domain.THost;
import com.zx.service.THostService;
@Service
public class THostServiceImpl implements THostService{

    @Resource
    private THostMapper tHostMapper;

    @Override
    public int deleteByPrimaryKey(Integer hid) {
        return tHostMapper.deleteByPrimaryKey(hid);
    }

    @Override
    public int insert(THost record) {
        return tHostMapper.insert(record);
    }

    @Override
    public int insertSelective(THost record) {
        return tHostMapper.insertSelective(record);
    }

    @Override
    public THost selectByPrimaryKey(Integer hid) {
        return tHostMapper.selectByPrimaryKey(hid);
    }

    @Override
    public int updateByPrimaryKeySelective(THost record) {
        return tHostMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(THost record) {
        return tHostMapper.updateByPrimaryKey(record);
    }

}
