package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * <p>
 * 存储婚庆公司的基本信息
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_company")
public class Company extends Model<Company> {

    private static final long serialVersionUID=1L;

    /**
     * 公司编号
     */
    @TableId(value = "cid", type = IdType.AUTO)
    private Integer cid;

    /**
     * 公司账户密码
     */
    private String cpwd;

    /**
     * 公司名称
     */
    private String cname;

    /**
     * 公司法人
     */
    private String ceo;

    /**
     * 公司手机号
     */
    private String cphone;

    /**
     * 公司常用邮箱
     */
    private String cmail;

    /**
     * 开通时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate starttime;

    /**
     * 账号状态(1.正常,2.禁用,3.未审核)
     */
    private String status;

    /**
     * 公司总订单量
     */
    private Integer cnum;


    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCpwd() {
        return cpwd;
    }

    public void setCpwd(String cpwd) {
        this.cpwd = cpwd;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCeo() {
        return ceo;
    }

    public void setCeo(String ceo) {
        this.ceo = ceo;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCmail() {
        return cmail;
    }

    public void setCmail(String cmail) {
        this.cmail = cmail;
    }

    public LocalDate getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalDate starttime) {
        this.starttime = starttime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCnum() {
        return cnum;
    }

    public void setCnum(Integer cnum) {
        this.cnum = cnum;
    }

    @Override
    protected Serializable pkVal() {
        return this.cid;
    }

    @Override
    public String toString() {
        return "Company{" +
        "cid=" + cid +
        ", cpwd=" + cpwd +
        ", cname=" + cname +
        ", ceo=" + ceo +
        ", cphone=" + cphone +
        ", cmail=" + cmail +
        ", starttime=" + starttime +
        ", status=" + status +
        ", cnum=" + cnum +
        "}";
    }
}
