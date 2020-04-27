package com.zx.service;

import com.zx.pojo.Menu;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.pojo.Tree;

import java.util.List;

public interface IMenuService extends IService<Menu> {

    List<Tree>  findMoreMenus(int aid,int pid);

    //查询所有菜单操作
    List<Tree>  findAllMenus();

}
