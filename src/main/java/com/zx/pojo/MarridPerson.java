package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 新人信息表存储新人的基本信息,包括姓名,密码,手机号,婚期等信息
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_marrid_person")
public class MarridPerson extends Model<MarridPerson> {

    private static final long serialVersionUID=1L;

    /**
     * 新人ID
     */
    @TableId(value = "pid", type = IdType.AUTO)
    private Integer pid;

    /**
     * 新人姓名
     */
    private String pname;

    /**
     * 新人密码
     */
    private String ppwd;

    /**
     * 新人手机号
     */
    private String pphone;

    /**
     * 新人邮箱
     */
    private String pmail;

    /**
     * 婚期
     */
    private LocalDate marrydate;

    /**
     * 注册时间
     */
    private LocalDate regdate;

    /**
     * 账号状态(正常,禁用)
     */
    private String status;


    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPpwd() {
        return ppwd;
    }

    public void setPpwd(String ppwd) {
        this.ppwd = ppwd;
    }

    public String getPphone() {
        return pphone;
    }

    public void setPphone(String pphone) {
        this.pphone = pphone;
    }

    public String getPmail() {
        return pmail;
    }

    public void setPmail(String pmail) {
        this.pmail = pmail;
    }

    public LocalDate getMarrydate() {
        return marrydate;
    }

    public void setMarrydate(LocalDate marrydate) {
        this.marrydate = marrydate;
    }

    public LocalDate getRegdate() {
        return regdate;
    }

    public void setRegdate(LocalDate regdate) {
        this.regdate = regdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    protected Serializable pkVal() {
        return this.pid;
    }

    @Override
    public String toString() {
        return "MarridPerson{" +
        "pid=" + pid +
        ", pname=" + pname +
        ", ppwd=" + ppwd +
        ", pphone=" + pphone +
        ", pmail=" + pmail +
        ", marrydate=" + marrydate +
        ", regdate=" + regdate +
        ", status=" + status +
        "}";
    }
}
