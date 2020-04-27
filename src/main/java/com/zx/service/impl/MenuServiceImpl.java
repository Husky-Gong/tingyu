package com.zx.service.impl;

import com.zx.pojo.Menu;
import com.zx.mapper.MenuMapper;
import com.zx.pojo.Tree;
import com.zx.service.IMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements IMenuService {

    @Autowired
    private   MenuMapper  menuMapper;


    @Override
    public List<Tree> findMoreMenus(int aid, int pid) {

        List<Menu> list = menuMapper.selectMoreMenus(aid, pid);

        List<Tree>  list1=new ArrayList<>();
        for(Menu  menu:list){

            Tree  tree=new Tree(menu.getMid(),menu.getMname(),menu.getStatus()==0?"closed":"open",menu.getUrl());

            list1.add(tree);
        }
        return list1;
    }

    @Override
    public List<Tree> findAllMenus() {

        //查询所有一级菜单
        List<Tree> list1 = menuMapper.selectAllMenus(0);

       //变量一级菜单
        for(Tree  tree :list1){
            //查询二级菜单
            //一级菜单id
             int id = tree.getId();
             //指定一级菜单下对应的二级菜单
            List<Tree> list2 = menuMapper.selectAllMenus(id);
            //把二级菜单保存到Children
            tree.setChildren(list2);
        }
        return list1;
    }
}
