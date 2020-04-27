package com.zx.service.impl;

import com.zx.pojo.MarridPerson;
import com.zx.mapper.MarridPersonMapper;
import com.zx.service.IMarridPersonService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;


@Service
public class MarridPersonServiceImpl extends ServiceImpl<MarridPersonMapper, MarridPerson> implements IMarridPersonService {

}
