package com.zx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.pojo.MarridPerson;
import com.zx.pojo.PageA;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 新人信息表存储新人的基本信息,包括姓名,密码,手机号,婚期等信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/MarridPersonController")
public class MarridPersonController {



    @RequestMapping("/findMoreMarridPerson")
    public PageA<MarridPerson>  findMoreMarridPerson(int page,int rows,MarridPerson marridPerson){

        //定义分页的对象
        Page<MarridPerson>  p=new Page<>(page,rows);

        //定义分页查询的条件
        QueryWrapper  queryWrapper=new QueryWrapper();

        if(marridPerson.getPname()!=null &&!"".equals(marridPerson.getPname())){
            queryWrapper.like("pname",marridPerson.getPname());
        }

        if(marridPerson.getPphone()!=null &&!"".equals(marridPerson.getPphone())){
            queryWrapper.eq("pphone",marridPerson.getPphone());
        }

        //分页返回的对象
        Page page1 = marridPerson.selectPage(p, queryWrapper);

        //把分页的对象保存到自定义对象中
        PageA<MarridPerson>  personPageA=new PageA<>(page1.getRecords(),page1.getTotal());

        return  personPageA;
    }

}

