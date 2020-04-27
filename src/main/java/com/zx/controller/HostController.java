package com.zx.controller;


import com.bjsxt.pojo.Host;
import com.bjsxt.pojo.HostPower;
import com.bjsxt.pojo.PageA;
import com.bjsxt.service.IHostPowerService;
import com.bjsxt.service.IHostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 * 主持人信息表,存储主持人信息. 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/HostController")
public class HostController {

    @Autowired
    private IHostService  iHostService;

    //查询所有的主持人信息
    @RequestMapping("/findMoreHost")
    public PageA<Host>  findMoreHost(int page,int rows,Host  host){

        return    iHostService.findMore(page, rows,host);
    }

    //修改主持人权重操作
    @RequestMapping("/updateStrong")
    public   Boolean   updateStrong(Host   host){

        return host.updateById();
    }

    //添加主持人操作
    @RequestMapping("/saveHost")
    public    Boolean    saveHost(Host  host){
        host.setStatus("正常");
        host.setStrong("10");
        //保存主持人信息
        boolean insert = host.insert();

        //保存主持人的权限初始权限
        HostPower hostPower = new HostPower();
        hostPower.setHostid(host.getHid());
        hostPower.insert();
        return  insert;

    }

    //批量操作账号状态
    @RequestMapping("/updateStatus")
    public   Boolean   updateStatus(Host  host,Integer[] hids){

        boolean  flag=false;
        try {
            for(Integer  hid:hids){

                host.setHid(hid);

                host.updateById();
            }
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  flag;

    }


}

