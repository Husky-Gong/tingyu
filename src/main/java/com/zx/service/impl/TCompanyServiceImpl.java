package com.zx.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.zx.mapper.TCompanyMapper;
import com.zx.domain.TCompany;
import com.zx.service.TCompanyService;
@Service
public class TCompanyServiceImpl implements TCompanyService{

    @Resource
    private TCompanyMapper tCompanyMapper;

    @Override
    public int deleteByPrimaryKey(Integer cid) {
        return tCompanyMapper.deleteByPrimaryKey(cid);
    }

    @Override
    public int insert(TCompany record) {
        return tCompanyMapper.insert(record);
    }

    @Override
    public int insertSelective(TCompany record) {
        return tCompanyMapper.insertSelective(record);
    }

    @Override
    public TCompany selectByPrimaryKey(Integer cid) {
        return tCompanyMapper.selectByPrimaryKey(cid);
    }

    @Override
    public int updateByPrimaryKeySelective(TCompany record) {
        return tCompanyMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TCompany record) {
        return tCompanyMapper.updateByPrimaryKey(record);
    }

}
