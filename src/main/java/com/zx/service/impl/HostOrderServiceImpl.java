package com.zx.service.impl;

import com.zx.pojo.HostOrder;
import com.zx.mapper.HostOrderMapper;
import com.zx.service.IHostOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class HostOrderServiceImpl extends ServiceImpl<HostOrderMapper, HostOrder> implements IHostOrderService {

}
