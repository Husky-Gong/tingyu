package com.zx.domain;

import java.io.Serializable;
import java.util.Date;

public class TMarriedPerson implements Serializable {
    private Integer pid;

    private String ppwd;

    private String pname;

    private String phone;

    private String pmail;

    private Date marrydate;

    private Date regdate;

    private String status;

    private static final long serialVersionUID = 1L;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPpwd() {
        return ppwd;
    }

    public void setPpwd(String ppwd) {
        this.ppwd = ppwd;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPmail() {
        return pmail;
    }

    public void setPmail(String pmail) {
        this.pmail = pmail;
    }

    public Date getMarrydate() {
        return marrydate;
    }

    public void setMarrydate(Date marrydate) {
        this.marrydate = marrydate;
    }

    public Date getRegdate() {
        return regdate;
    }

    public void setRegdate(Date regdate) {
        this.regdate = regdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pid=").append(pid);
        sb.append(", ppwd=").append(ppwd);
        sb.append(", pname=").append(pname);
        sb.append(", phone=").append(phone);
        sb.append(", pmail=").append(pmail);
        sb.append(", marrydate=").append(marrydate);
        sb.append(", regdate=").append(regdate);
        sb.append(", status=").append(status);
        sb.append("]");
        return sb.toString();
    }
}