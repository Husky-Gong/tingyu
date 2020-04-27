package com.zx.service.impl;

import com.zx.pojo.AdminRole;
import com.zx.mapper.AdminRoleMapper;
import com.zx.service.IAdminRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AdminRoleServiceImpl extends ServiceImpl<AdminRoleMapper, AdminRole> implements IAdminRoleService {

}
