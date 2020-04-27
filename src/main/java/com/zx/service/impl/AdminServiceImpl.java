package com.zx.service.impl;

import com.zx.pojo.Admin;
import com.zx.mapper.AdminMapper;
import com.zx.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

}
