package com.zx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.pojo.Company;
import com.zx.mapper.CompanyMapper;
import com.zx.pojo.PageA;
import com.zx.service.ICompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CompanyServiceImpl extends ServiceImpl<CompanyMapper, Company> implements ICompanyService {

    @Autowired
    private  CompanyMapper  companyMapper;

    @Override
    public PageA<Company> findMore(int page, int rows, Company company) {

        Page<Company>  p=new Page<>(page,rows);

        List<Company> list = companyMapper.selectMore(p, company);

        PageA<Company>  pageA=new PageA<>(list,p.getTotal());

        return pageA;
    }
}
