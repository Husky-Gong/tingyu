package com.zx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjsxt.pojo.Admin;
import com.bjsxt.pojo.Menu;
import com.bjsxt.pojo.PageA;
import com.bjsxt.pojo.Tree;
import com.bjsxt.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 菜单信息表,存储菜单信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/MenuController")
public class MenuController {

       @Autowired
       private IMenuService  menuService;

       //获得所有一级菜单
       @RequestMapping("/findPid")
       public   List<Menu>   findPid(){

           QueryWrapper  queryWrapper=new QueryWrapper();
           queryWrapper.eq("status",0);

          return menuService.list(queryWrapper);

       }

       //查询所有菜单实现
      @RequestMapping("/findAllMenus")
       public   List<Tree>  findAllMenus(){

           return   menuService.findAllMenus();
       }



    //查询指定角色下的所有菜单
  /*  @RequestMapping("/findMoreMenus2")
    public List<Tree>   findMoreMenus2(@RequestParam(defaultValue = "0") int id){
        //调用查询菜单方法
        return   menuService.findMoreMenus(1,id);
    }
*/

        //查询指定角色下的所有菜单
       @RequestMapping("/findMoreMenus")
       public List<Tree>   findMoreMenus(@RequestParam(defaultValue = "0") int id, HttpSession  session){

             //获得当前登录用户aid
           Admin admin = (Admin) session.getAttribute("admin");

           //调用查询菜单方法
           return   menuService.findMoreMenus(admin.getAid(),id);
       }


       //查询所有菜单的操作
      @RequestMapping("/findPageMenus")
       public PageA<Menu>   findPageMenus(int page,int  rows){

           Page<Menu>  p=new Page<>(page,rows);

           Page<Menu> page1 = menuService.page(p);

           PageA<Menu>   pageA=new PageA<>(page1.getRecords(),p.getTotal());

           return   pageA;
       }

       //添加菜单操作
       @RequestMapping("/saveMenus")
       public   boolean   saveMenus(Menu  menu){
            //给定默认值
            menu.setIsparent(0);
            //添加菜单的操作
           boolean insert = menu.insert();
           //修改添加节点的父节点
           Menu menu1=new Menu();
           menu1.setMid(menu.getPid());
           menu1.setUrl("");
           menu1.setStatus(0);
           boolean update = menu1.updateById();
           return  insert&&update ;
       }

       //修改菜单操作
       @RequestMapping("/changeMenus")
       public   boolean changeMenus(Menu  menu){

           return  menu.updateById();
       }

       //删除菜单操作
       @RequestMapping("/removeMenus")
       public Map<String,String> removeMenus(Menu  menu){

           Map<String,String>  map =new HashMap<>();

              //查询指定节点下是否有子节点

              QueryWrapper  queryWrapper=new QueryWrapper();
              queryWrapper.eq("pid",menu.getMid());

              List list = menu.selectList(queryWrapper);

              if(list.size()>0){
                  map.put("ErrorMsg","该菜单下有子菜单,无法删除");
              }else{
                  map.put("SuccessMsg","删除成功");
                  menu.deleteById();
              }

           return map;

       }



}

