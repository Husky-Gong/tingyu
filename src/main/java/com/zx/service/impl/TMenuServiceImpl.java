package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TMenuMapper;
import com.zx.domain.TMenu;
import com.zx.service.TMenuService;
@Service
public class TMenuServiceImpl implements TMenuService{

    @Resource
    private TMenuMapper tMenuMapper;

    @Override
    public int deleteByPrimaryKey(Integer mid) {
        return tMenuMapper.deleteByPrimaryKey(mid);
    }

    @Override
    public int insert(TMenu record) {
        return tMenuMapper.insert(record);
    }

    @Override
    public int insertSelective(TMenu record) {
        return tMenuMapper.insertSelective(record);
    }

    @Override
    public TMenu selectByPrimaryKey(Integer mid) {
        return tMenuMapper.selectByPrimaryKey(mid);
    }

    @Override
    public int updateByPrimaryKeySelective(TMenu record) {
        return tMenuMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TMenu record) {
        return tMenuMapper.updateByPrimaryKey(record);
    }

}
