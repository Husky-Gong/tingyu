package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 菜单信息表,存储菜单信息
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_menu")
public class Menu extends Model<Menu> {

    private static final long serialVersionUID=1L;

    /**
     * 菜单编号
     */
    @TableId(value = "mid", type = IdType.AUTO)
    private Integer mid;

    /**
     * 菜单名称
     */
    private String mname;

    /**
     * 父菜单编号
     */
    private Integer pid;

    /**
     * 是否为父级菜单(1.是,0.否)
     */
    private Integer isparent;

    /**
     * 打开状态(1.展开,0.不展开)
     */
    private Integer status;

    /**
     * url地址
     */
    private String url;

    /**
     * 菜单描述
     */
    private String mdesc;


    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getIsparent() {
        return isparent;
    }

    public void setIsparent(Integer isparent) {
        this.isparent = isparent;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMdesc() {
        return mdesc;
    }

    public void setMdesc(String mdesc) {
        this.mdesc = mdesc;
    }

    @Override
    protected Serializable pkVal() {
        return this.mid;
    }

    @Override
    public String toString() {
        return "Menu{" +
        "mid=" + mid +
        ", mname=" + mname +
        ", pid=" + pid +
        ", isparent=" + isparent +
        ", status=" + status +
        ", url=" + url +
        ", mdesc=" + mdesc +
        "}";
    }
}
