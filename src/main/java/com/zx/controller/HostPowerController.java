package com.zx.controller;


import com.bjsxt.pojo.HostPower;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 主持人权限信息表,存储主持人的星推荐,折扣等信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/HostPowerController")
public class HostPowerController {


    //批量修改权限的操作
    @RequestMapping("/changeHostPower")
    public   boolean   changeHostPower(HostPower  hostPower,Integer[] hpids){

        //  try    ctrl+alt+t
     boolean  flag=false;
        try {
            for(Integer  hpid :hpids){
                //把指定的hpid保存到HostPower
                hostPower.setHpid(hpid);
                //根据phid修改指定的数据
                hostPower.updateById();
            }
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return   flag;
    }



}

