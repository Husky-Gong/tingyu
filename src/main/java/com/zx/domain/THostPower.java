package com.zx.domain;

import java.io.Serializable;
import java.util.Date;

public class THostPower implements Serializable {
    private Integer hpid;

    private String hpstar;

    private Date hpstartBegindate;

    private Date hpstarEnddate;

    private String hpOrderPower;

    private Date hpstarBegintime;

    private Date hpstarEndtime;

    private Integer hpdiscount;

    private Date hpDisStarttime;

    private Date hpDisEndtime;

    private Double hpprice;

    private Double hpcosts;

    private Integer hostid;

    private static final long serialVersionUID = 1L;

    public Integer getHpid() {
        return hpid;
    }

    public void setHpid(Integer hpid) {
        this.hpid = hpid;
    }

    public String getHpstar() {
        return hpstar;
    }

    public void setHpstar(String hpstar) {
        this.hpstar = hpstar;
    }

    public Date getHpstartBegindate() {
        return hpstartBegindate;
    }

    public void setHpstartBegindate(Date hpstartBegindate) {
        this.hpstartBegindate = hpstartBegindate;
    }

    public Date getHpstarEnddate() {
        return hpstarEnddate;
    }

    public void setHpstarEnddate(Date hpstarEnddate) {
        this.hpstarEnddate = hpstarEnddate;
    }

    public String getHpOrderPower() {
        return hpOrderPower;
    }

    public void setHpOrderPower(String hpOrderPower) {
        this.hpOrderPower = hpOrderPower;
    }

    public Date getHpstarBegintime() {
        return hpstarBegintime;
    }

    public void setHpstarBegintime(Date hpstarBegintime) {
        this.hpstarBegintime = hpstarBegintime;
    }

    public Date getHpstarEndtime() {
        return hpstarEndtime;
    }

    public void setHpstarEndtime(Date hpstarEndtime) {
        this.hpstarEndtime = hpstarEndtime;
    }

    public Integer getHpdiscount() {
        return hpdiscount;
    }

    public void setHpdiscount(Integer hpdiscount) {
        this.hpdiscount = hpdiscount;
    }

    public Date getHpDisStarttime() {
        return hpDisStarttime;
    }

    public void setHpDisStarttime(Date hpDisStarttime) {
        this.hpDisStarttime = hpDisStarttime;
    }

    public Date getHpDisEndtime() {
        return hpDisEndtime;
    }

    public void setHpDisEndtime(Date hpDisEndtime) {
        this.hpDisEndtime = hpDisEndtime;
    }

    public Double getHpprice() {
        return hpprice;
    }

    public void setHpprice(Double hpprice) {
        this.hpprice = hpprice;
    }

    public Double getHpcosts() {
        return hpcosts;
    }

    public void setHpcosts(Double hpcosts) {
        this.hpcosts = hpcosts;
    }

    public Integer getHostid() {
        return hostid;
    }

    public void setHostid(Integer hostid) {
        this.hostid = hostid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hpid=").append(hpid);
        sb.append(", hpstar=").append(hpstar);
        sb.append(", hpstartBegindate=").append(hpstartBegindate);
        sb.append(", hpstarEnddate=").append(hpstarEnddate);
        sb.append(", hpOrderPower=").append(hpOrderPower);
        sb.append(", hpstarBegintime=").append(hpstarBegintime);
        sb.append(", hpstarEndtime=").append(hpstarEndtime);
        sb.append(", hpdiscount=").append(hpdiscount);
        sb.append(", hpDisStarttime=").append(hpDisStarttime);
        sb.append(", hpDisEndtime=").append(hpDisEndtime);
        sb.append(", hpprice=").append(hpprice);
        sb.append(", hpcosts=").append(hpcosts);
        sb.append(", hostid=").append(hostid);
        sb.append("]");
        return sb.toString();
    }
}