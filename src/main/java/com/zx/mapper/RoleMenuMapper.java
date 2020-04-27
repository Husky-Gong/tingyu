package com.zx.mapper;

import com.zx.pojo.RoleMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色菜单信息表存储角色和菜单的映射关系,中间表 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
public interface RoleMenuMapper extends BaseMapper<RoleMenu> {

    //通过rid查找所有的mid
    List<Integer>  selectMids(int  rid);

}
