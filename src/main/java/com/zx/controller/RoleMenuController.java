package com.zx.controller;


import com.zx.service.IRoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 角色菜单信息表存储角色和菜单的映射关系,中间表 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/RoleMenuController")
public class RoleMenuController {


    @Autowired
    private IRoleMenuService  iRoleMenuService;

    @RequestMapping("/findMoreMids")
    public List<Integer>  findMoreMids(int rid){

        return  iRoleMenuService.findMoreIds(rid);
    }


}

