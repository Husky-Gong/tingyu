package com.zx.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zx.pojo.Host;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 主持人信息表,存储主持人信息. Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
public interface HostMapper extends BaseMapper<Host> {

    List<Host> selectMore(Page<Host>  page,Host host);


}
