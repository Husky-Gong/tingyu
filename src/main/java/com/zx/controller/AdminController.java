package com.zx.controller;


import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.pojo.Admin;
import com.zx.pojo.AdminRole;
import com.zx.pojo.PageA;
import com.zx.service.IAdminRoleService;
import com.zx.service.IAdminService;
import com.zx.util.AliPhoneUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@Controller
@RequestMapping("/AdminController")
public class AdminController {

    @Autowired
    private IAdminService  iAdminService;

    @Autowired
    private IAdminRoleService  iAdminRoleService;


    @PostMapping("/phone")
    @ResponseBody
    public String phoneCode(String phonenumber,HttpSession session) throws ClientException {

        AliPhoneUtil aliPhoneUtil = new AliPhoneUtil();
        //得到验证码
        aliPhoneUtil.setNewcode();
        //产生的验证码
       String newCode = Integer.toString(aliPhoneUtil.getNewcode());
        SendSmsResponse sendSmsResponse = aliPhoneUtil.sendSms(phonenumber,newCode);
        System.out.println(sendSmsResponse);

        //把产生的验证码保存到session 中
        session.setAttribute("yzm",newCode);
        return sendSmsResponse.getCode();
    }





    //添加用户实现
    @RequestMapping("/saveAdmin")
    @ResponseBody
    public   boolean   saveAdmin(Admin  admin,int roles){

        boolean  flag=false;
        try {
            //管理员用户添加
            admin.insert();

            //给管理员赋予权限
            iAdminRoleService.save(new AdminRole(admin.getAid(),roles));

            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }


        return   flag;

    }


    //查询所有用户实现
    @RequestMapping("/findAllAdmin")
    @ResponseBody
    public PageA<Admin>   findAllAdmin(int page,int rows){

        Page<Admin>  p=new Page<>(page,rows);

        Page<Admin> page1 = iAdminService.page(p);

        PageA<Admin>  pag=new PageA<>(page1.getRecords(),p.getTotal());

        return  pag;
    }


    //用户退出操作
    @RequestMapping("/loginOut")
    public  String  loginOut(HttpSession  session){

        //注销当前的session
        session.invalidate();

        //跳转到登录页面
        return "redirect:/login.jsp";
    }


    //用户登录实现
    @RequestMapping("/adminLogin")
    @ResponseBody
    public    boolean   adminLogin(String aname, String  apwd, HttpSession  session){

        QueryWrapper<Admin>  queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("aname",aname).eq("apwd",apwd);

        Admin admin = iAdminService.getOne(queryWrapper);

        if(admin!=null){

            //用户登录成功把用户信息保存到session中
            session.setAttribute("admin",admin);

            return true;
        }
        return  false;
    }


}

