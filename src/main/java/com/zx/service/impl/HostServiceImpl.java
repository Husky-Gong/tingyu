package com.zx.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.pojo.Host;
import com.zx.mapper.HostMapper;
import com.zx.pojo.PageA;
import com.zx.service.IHostService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HostServiceImpl extends ServiceImpl<HostMapper, Host> implements IHostService {

    @Autowired
    private   HostMapper  hostMapper;

    @Override
    public PageA<Host> findMore(int page, int rows,Host host) {

        //创建分页插件对象
        Page<Host>  p=new Page<>(page,rows);

        List<Host> list = hostMapper.selectMore(p,host);

        //把查询出的集合保存到PageA
        PageA<Host>  pg=new PageA<>(list,p.getTotal());

        return pg;
    }
}
