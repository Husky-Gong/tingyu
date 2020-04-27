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
 * 主持人权限信息表,存储主持人的星推荐,折扣等信息
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_host_power")
public class HostPower extends Model<HostPower> {

    private static final long serialVersionUID=1L;

    /**
     * 权限编号
     */
    @TableId(value = "hpid", type = IdType.AUTO)
    private Integer hpid;

    /**
     * 是否星推荐(1.是,2.否)
     */
    private String hpstart;

    /**
     * 星推荐开始日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hpstartBeigindate;

    /**
     * 星推荐结束日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hpstartEnddate;

    /**
     * 是否允许自添订单(1.是,2.否)
     */
    private String hpOrderPower;

    /**
     * 每日星推荐开始时间
     */
    private String hpstartBegintime;

    /**
     * 每日星推荐结束时间
     */
    private String hpstartEndtime;

    /**
     * 折扣值(1,2,3,4,5,6,7,8,9)
     */
    private Integer hpdiscount;

    /**
     * 折扣开始时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hpDisStarttime;

    /**
     * 折扣结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hpDisEndtime;

    /**
     * 价格
     */
    private Double hpprice;

    /**
     * 管理费
     */
    private Double hcosts;

    /**
     * 主持人编号
     */
    private Integer hostid;


    public Integer getHpid() {
        return hpid;
    }

    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    public String getHpstart() {
        return hpstart;
    }

    public void setHpstart(String hpstart) {
        this.hpstart = hpstart;
    }

    public LocalDate getHpstartBeigindate() {
        return hpstartBeigindate;
    }

    public void setHpstartBeigindate(LocalDate hpstartBeigindate) {
        this.hpstartBeigindate = hpstartBeigindate;
    }

    public LocalDate getHpstartEnddate() {
        return hpstartEnddate;
    }

    public void setHpstartEnddate(LocalDate hpstartEnddate) {
        this.hpstartEnddate = hpstartEnddate;
    }

    public String getHpOrderPower() {
        return hpOrderPower;
    }

    public void setHpOrderPower(String hpOrderPower) {
        this.hpOrderPower = hpOrderPower;
    }

    public String getHpstartBegintime() {
        return hpstartBegintime;
    }

    public void setHpstartBegintime(String hpstartBegintime) {
        this.hpstartBegintime = hpstartBegintime;
    }

    public String getHpstartEndtime() {
        return hpstartEndtime;
    }

    public void setHpstartEndtime(String hpstartEndtime) {
        this.hpstartEndtime = hpstartEndtime;
    }

    public Integer getHpdiscount() {
        return hpdiscount;
    }

    public void setHpdiscount(Integer hpdiscount) {
        this.hpdiscount = hpdiscount;
    }

    public LocalDate getHpDisStarttime() {
        return hpDisStarttime;
    }

    public void setHpDisStarttime(LocalDate hpDisStarttime) {
        this.hpDisStarttime = hpDisStarttime;
    }

    public LocalDate getHpDisEndtime() {
        return hpDisEndtime;
    }

    public void setHpDisEndtime(LocalDate hpDisEndtime) {
        this.hpDisEndtime = hpDisEndtime;
    }

    public Double getHpprice() {
        return hpprice;
    }

    public void setHpprice(Double hpprice) {
        this.hpprice = hpprice;
    }

    public Double getHcosts() {
        return hcosts;
    }

    public void setHcosts(Double hcosts) {
        this.hcosts = hcosts;
    }

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    @Override
    protected Serializable pkVal() {
        return this.hpid;
    }

    @Override
    public String toString() {
        return "HostPower{" +
        "hpid=" + hpid +
        ", hpstart=" + hpstart +
        ", hpstartBeigindate=" + hpstartBeigindate +
        ", hpstartEnddate=" + hpstartEnddate +
        ", hpOrderPower=" + hpOrderPower +
        ", hpstartBegintime=" + hpstartBegintime +
        ", hpstartEndtime=" + hpstartEndtime +
        ", hpdiscount=" + hpdiscount +
        ", hpDisStarttime=" + hpDisStarttime +
        ", hpDisEndtime=" + hpDisEndtime +
        ", hpprice=" + hpprice +
        ", hcosts=" + hcosts +
        ", hid=" + hostid +
        "}";
    }
}
