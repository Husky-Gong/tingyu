package com.zx.mapper;

import com.zx.pojo.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zx.pojo.Tree;

import java.util.List;

/**
 * <p>
 * 菜单信息表,存储菜单信息 Mapper 接口
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
public interface MenuMapper extends BaseMapper<Menu> {


    //查询指定角色下的菜单
    List<Menu>  selectMoreMenus(int  aid ,int  pid);

    //查询所有菜单操作
    List<Tree>  selectAllMenus(int pid);


}
