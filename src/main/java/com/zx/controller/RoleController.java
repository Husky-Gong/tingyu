package com.zx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bjsxt.pojo.Admin;
import com.bjsxt.pojo.PageA;
import com.bjsxt.pojo.Role;
import com.bjsxt.pojo.RoleMenu;
import com.bjsxt.service.IRoleMenuService;
import com.bjsxt.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 存储角色信息 前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@RestController
@RequestMapping("/RoleController")
public class RoleController {

       @Autowired
       private IRoleService  iRoleService;

       @Autowired
       private IRoleMenuService iRoleMenuService;


       @RequestMapping("/findAllRole")
       public List<Role> findAllRole(){

           return iRoleService.list();
       }


       //删除角色的操作
       @RequestMapping("/roleRemove")
       public   boolean   roleRemove(Role role){

           return   role.deleteById();
       }


       //修改角色的操作
         @RequestMapping("/roleUpdate")
        public    boolean   roleUpdate(Role  role,Integer[] mmids){

            boolean  flag=false;
            try {
                //[a]修改角色操作
                role.updateById();
                //[b]删除指定角色下的菜单
                iRoleMenuService.remove(new QueryWrapper<RoleMenu>().eq("rid",role.getRid()));
                //[c]把新的菜单复制给当前角色
                for(Integer  mmid:mmids){
                    iRoleMenuService.save(new RoleMenu(role.getRid(),mmid));
                }

                flag=true;
            } catch (Exception e) {
                throw  e;
            }

           return flag;
        }



       //添加角色操作
        @RequestMapping("/roleSave")
        public   boolean  roleSave(Role  role,Integer[] mmids) {

            boolean  flag=false;
            try {
                //进行角色的添加
                role.insert();
                //进行角色_菜单的添加
                for (Integer  mmid:mmids) {
                    iRoleMenuService.save(new RoleMenu(role.getRid(),mmid));
                }
                flag=true;
            } catch (Exception e) {
                throw   e;
            }
            return  flag;
        }

        //查询所有角色处理
       @RequestMapping("/findPageRole")
       public PageA<Role>  findPageRole(int page,int  rows){

           Page<Role>  p=new Page<>(page,rows);

           Page<Role> page1 = iRoleService.page(p);

           PageA<Role>  pageA=new PageA<>(page1.getRecords(),p.getTotal());

           return   pageA;
       }


}

