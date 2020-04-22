package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.domain.TPlanner;
import com.zx.mapper.TPlannerMapper;
import com.zx.service.TPlannerService;
@Service
public class TPlannerServiceImpl implements TPlannerService{

    @Resource
    private TPlannerMapper tPlannerMapper;

    @Override
    public int deleteByPrimaryKey(Integer nid) {
        return tPlannerMapper.deleteByPrimaryKey(nid);
    }

    @Override
    public int insert(TPlanner record) {
        return tPlannerMapper.insert(record);
    }

    @Override
    public int insertSelective(TPlanner record) {
        return tPlannerMapper.insertSelective(record);
    }

    @Override
    public TPlanner selectByPrimaryKey(Integer nid) {
        return tPlannerMapper.selectByPrimaryKey(nid);
    }

    @Override
    public int updateByPrimaryKeySelective(TPlanner record) {
        return tPlannerMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TPlanner record) {
        return tPlannerMapper.updateByPrimaryKey(record);
    }

}
