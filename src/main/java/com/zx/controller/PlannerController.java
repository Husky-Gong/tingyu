package com.zx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.pojo.PageA;
import com.zx.pojo.Planner;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 策划师信息表,存储婚庆公司的策划师信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/PlannerController")
public class PlannerController {


    @RequestMapping("/findMorePlanner")
    public PageA<Planner>  findMorePlanner(Planner planner){

        //设置查询条件
        QueryWrapper<Planner>  queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("cid",planner.getCid());

        List<Planner> list = planner.selectList(queryWrapper);

        PageA<Planner>  pageA=new PageA<>();
        pageA.setRows(list);

        return  pageA;

    }

}

