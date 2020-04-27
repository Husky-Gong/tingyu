package com.zx.service;

import com.zx.pojo.Company;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.pojo.PageA;

import java.util.List;


public interface ICompanyService extends IService<Company> {

    PageA<Company> findMore(int page, int rows, Company  company);


}
