package com.zx.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.domain.TAdmin;
public interface TAdminService extends IService<TAdmin> {


    int deleteByPrimaryKey(Integer aid);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    TAdmin selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);

}
