package com.zx.service;

import com.zx.pojo.RoleMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


public interface IRoleMenuService extends IService<RoleMenu> {

    //查询指定角色下的菜单id
    List<Integer>  findMoreIds(int  rid);


}
