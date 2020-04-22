package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.THostPowerMapper;
import com.zx.domain.THostPower;
import com.zx.service.THostPowerService;
@Service
public class THostPowerServiceImpl implements THostPowerService{

    @Resource
    private THostPowerMapper tHostPowerMapper;

    @Override
    public int deleteByPrimaryKey(Integer hpid) {
        return tHostPowerMapper.deleteByPrimaryKey(hpid);
    }

    @Override
    public int insert(THostPower record) {
        return tHostPowerMapper.insert(record);
    }

    @Override
    public int insertSelective(THostPower record) {
        return tHostPowerMapper.insertSelective(record);
    }

    @Override
    public THostPower selectByPrimaryKey(Integer hpid) {
        return tHostPowerMapper.selectByPrimaryKey(hpid);
    }

    @Override
    public int updateByPrimaryKeySelective(THostPower record) {
        return tHostPowerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(THostPower record) {
        return tHostPowerMapper.updateByPrimaryKey(record);
    }

}
