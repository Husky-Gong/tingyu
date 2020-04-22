package com.zx.domain;

import java.io.Serializable;
import java.util.Date;

public class THost implements Serializable {
    private Integer hid;

    private String hname;

    private String hpwd;

    private String hphone;

    private Date starttime;

    private String status;

    private String strong;

    private Integer ordernumber;

    private static final long serialVersionUID = 1L;

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

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
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

    public Integer getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(Integer ordernumber) {
        this.ordernumber = ordernumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", hid=").append(hid);
        sb.append(", hname=").append(hname);
        sb.append(", hpwd=").append(hpwd);
        sb.append(", hphone=").append(hphone);
        sb.append(", starttime=").append(starttime);
        sb.append(", status=").append(status);
        sb.append(", strong=").append(strong);
        sb.append(", ordernumber=").append(ordernumber);
        sb.append("]");
        return sb.toString();
    }
}