package com.zx.controller;


import com.zx.pojo.Company;
import com.zx.pojo.PageA;
import com.zx.service.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/CompanyController")
public class CompanyController {

    @Autowired
    private ICompanyService  iCompanyService;

    //修改公司状态操作
    @RequestMapping("/statusCompanyUpdate")
    public  Boolean  statusCompanyUpdate(Company company){

        return company.updateById();
    }


    //修改公司信息操作
    @RequestMapping("/changeCompany")
    public   Boolean  changeCompany(Company  company){

        return   company.updateById();
    }


    //添加公司信息操作
    @RequestMapping("/saveCompany")
    public   Boolean   saveCompany(Company  company){
        company.setStatus("正常");
        company.setCnum(0);
        return company.insert();
    }


    @RequestMapping("/findMoreCompany")
    public PageA<Company>  findMoreCompany(int page,int rows,Company  company){

        return  iCompanyService.findMore(page, rows, company);
    }

}

