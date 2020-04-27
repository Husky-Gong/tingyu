package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_admin")
public class Admin extends Model<Admin> {

    private static final long serialVersionUID=1L;

    /**
     * 管理员编号
     */
    @TableId(value = "aid", type = IdType.AUTO)
    private Integer aid;

    /**
     * 管理员姓名
     */
    private String aname;

    /**
     * 管理员密码
     */
    private String apwd;

    /**
     * 管理员手机号
     */
    private String aphone;

    /**
     * 添加时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate starttime;


    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getApwd() {
        return apwd;
    }

    public void setApwd(String apwd) {
        this.apwd = apwd;
    }

    public String getAphone() {
        return aphone;
    }

    public void setAphone(String aphone) {
        this.aphone = aphone;
    }

    public LocalDate getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDate starttime) {
        this.starttime = starttime;
    }

    @Override
    protected Serializable pkVal() {
        return this.aid;
    }

    @Override
    public String toString() {
        return "Admin{" +
        "aid=" + aid +
        ", aname=" + aname +
        ", apwd=" + apwd +
        ", aphone=" + aphone +
        ", starttime=" + starttime +
        "}";
    }
}
