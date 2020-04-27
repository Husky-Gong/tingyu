package com.zx.service.impl;

import com.zx.pojo.Role;
import com.zx.mapper.RoleMapper;
import com.zx.service.IRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

}
