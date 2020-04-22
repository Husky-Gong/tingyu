package com.zx.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zx.domain.TAdmin;
import com.zx.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/AdminController")
public class AdminController {

    @Autowired
    private TAdminService tAdminService;

    //用户退出操作
    @RequestMapping("/loginOut")
    public  String  loginOut(HttpSession session){

        //注销当前的session
        session.invalidate();

        //跳转到登录页面
        return "redirect:/login.jsp";
    }


    //用户登录实现
    @RequestMapping("/adminLogin")
    @ResponseBody
    public    boolean   adminLogin(String aname, String  apwd, HttpSession  session){

        QueryWrapper<TAdmin>  queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("aname",aname).eq("apwd",apwd);

        TAdmin admin = tAdminService.getOne(queryWrapper);

        if(admin!=null){

            //用户登录成功把用户信息保存到session中
            session.setAttribute("admin",admin);

            return true;
        }
        return  false;
    }
}
