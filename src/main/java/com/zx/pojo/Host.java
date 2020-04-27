package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 主持人信息表,存储主持人信息.
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_host")
public class Host extends Model<Host> {

    private static final long serialVersionUID=1L;

    /**
     * 主持人编号
     */
    @TableId(value = "hid", type = IdType.AUTO)
    private Integer hid;

    /**
     * 主持人姓名
     */
    private String hname;

    /**
     * 主持人密码
     */
    private String hpwd;

    /**
     * 主持人手机号
     */
    private String hphone;

    /**
     * 注册时间
     */
    private LocalDateTime starttime;

    /**
     * 账号状态(1.正常,2.禁用)
     */
    private String status;

    /**
     * 权重,查询排序字段,按照值从大到小查询
     */
    private String strong;

    /**
     * 订单量
     */
    private Integer num;

    //主持人权限的信息
    @TableField(exist = false)
    private   HostPower  hostPower;


    public HostPower getHostPower() {
        return hostPower;
    }

    public void setHostPower(HostPower hostPower) {
        this.hostPower = hostPower;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHname() {
        return hname;
    }

    public void setHname(String hname) {
        this.hname = hname;
    }

    public String getHpwd() {
        return hpwd;
    }

    public void setHpwd(String hpwd) {
        this.hpwd = hpwd;
    }

    public String getHphone() {
        return hphone;
    }

    public void setHphone(String hphone) {
        this.hphone = hphone;
    }

    public LocalDateTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDateTime starttime) {
        this.starttime = starttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStrong() {
        return strong;
    }

    public void setStrong(String strong) {
        this.strong = strong;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    protected Serializable pkVal() {
        return this.hid;
    }

    @Override
    public String toString() {
        return "Host{" +
                "hid=" + hid +
                ", hname='" + hname + '\'' +
                ", hpwd='" + hpwd + '\'' +
                ", hphone='" + hphone + '\'' +
                ", starttime=" + starttime +
                ", status='" + status + '\'' +
                ", strong='" + strong + '\'' +
                ", num=" + num +
                ", hostPower=" + hostPower +
                '}';
    }
}
