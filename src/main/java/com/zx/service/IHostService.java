package com.zx.service;

import com.zx.pojo.Host;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.pojo.PageA;


public interface IHostService extends IService<Host> {


     PageA<Host>  findMore(int page,int rows,Host  host);



}
