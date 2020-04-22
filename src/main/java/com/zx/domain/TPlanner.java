package com.zx.domain;

import java.io.Serializable;
import java.util.Date;

public class TPlanner implements Serializable {
    private Integer nid;

    private String nname;

    private String nphone;

    private Date addtime;

    private String status;

    private Integer cid;

    private Integer ordernumber;

    private static final long serialVersionUID = 1L;

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getNphone() {
        return nphone;
    }

    public void setNphone(String nphone) {
        this.nphone = nphone;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
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
        sb.append(", nid=").append(nid);
        sb.append(", nname=").append(nname);
        sb.append(", nphone=").append(nphone);
        sb.append(", addtime=").append(addtime);
        sb.append(", status=").append(status);
        sb.append(", cid=").append(cid);
        sb.append(", ordernumber=").append(ordernumber);
        sb.append("]");
        return sb.toString();
    }
}