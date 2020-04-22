package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.domain.TOrder;
import com.zx.mapper.TOrderMapper;
import com.zx.service.TOrderService;
@Service
public class TOrderServiceImpl implements TOrderService{

    @Resource
    private TOrderMapper tOrderMapper;

    @Override
    public int deleteByPrimaryKey(Integer oid) {
        return tOrderMapper.deleteByPrimaryKey(oid);
    }

    @Override
    public int insert(TOrder record) {
        return tOrderMapper.insert(record);
    }

    @Override
    public int insertSelective(TOrder record) {
        return tOrderMapper.insertSelective(record);
    }

    @Override
    public TOrder selectByPrimaryKey(Integer oid) {
        return tOrderMapper.selectByPrimaryKey(oid);
    }

    @Override
    public int updateByPrimaryKeySelective(TOrder record) {
        return tOrderMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TOrder record) {
        return tOrderMapper.updateByPrimaryKey(record);
    }

}
