package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色菜单信息表存储角色和菜单的映射关系,中间表
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_role_menu")
public class RoleMenu extends Model<RoleMenu> {

    private static final long serialVersionUID=1L;

    /**
     * 角色编号
     */
    private Integer rid;

    /**
     * 菜单编号
     */
    private Integer mid;

    public RoleMenu(Integer rid, Integer mid) {
        this.rid = rid;
        this.mid = mid;
    }

    public RoleMenu() {
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        "rid=" + rid +
        ", mid=" + mid +
        "}";
    }
}
