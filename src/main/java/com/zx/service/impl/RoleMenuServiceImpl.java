package com.zx.service.impl;

import com.zx.pojo.RoleMenu;
import com.zx.mapper.RoleMenuMapper;
import com.zx.service.IRoleMenuService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu> implements IRoleMenuService {


    @Autowired
    private  RoleMenuMapper  roleMenuMapper;

    @Override
    public List<Integer> findMoreIds(int rid) {
        return roleMenuMapper.selectMids(rid);
    }
}
