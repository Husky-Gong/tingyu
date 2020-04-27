package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 管理员和角色之间的中间表,存储管理员的角色信息
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_admin_role")
public class AdminRole extends Model<AdminRole> {

    private static final long serialVersionUID=1L;

    /**
     * 管理员编号
     */
    private Integer aid;

    /**
     * 角色编号
     */
    private Integer rid;

    /**
     * 主键
     */
    @TableId(value = "arid", type = IdType.AUTO)
    private Integer arid;

    public AdminRole(Integer aid, Integer rid) {
        this.aid = aid;
        this.rid = rid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getArid() {
        return arid;
    }

    public void setArid(Integer arid) {
        this.arid = arid;
    }

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "AdminRole{" +
        "aid=" + aid +
        ", rid=" + rid +
        ", arid=" + arid +
        "}";
    }
}
