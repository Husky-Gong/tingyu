package com.zx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.pojo.Company;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 存储婚庆公司的基本信息 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
public interface CompanyMapper extends BaseMapper<Company> {

    List<Company>  selectMore(Page<Company> page,Company company);


}
