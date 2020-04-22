package com.zx.domain;

import java.io.Serializable;
import java.util.Date;

public class TOrder implements Serializable {
    private Integer oid;

    private Integer pid;

    private Integer cid;

    private Integer hid;

    private String hotelname;

    private String hoteladdress;

    private Date ordertime;

    private Date weddingTime;

    private String weddingSplit;

    private Double deposit;

    private Double money;

    private String status;

    private String comment;

    private static final long serialVersionUID = 1L;

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getHoteladdress() {
        return hoteladdress;
    }

    public void setHoteladdress(String hoteladdress) {
        this.hoteladdress = hoteladdress;
    }

    public Date getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(Date ordertime) {
        this.ordertime = ordertime;
    }

    public Date getWeddingTime() {
        return weddingTime;
    }

    public void setWeddingTime(Date weddingTime) {
        this.weddingTime = weddingTime;
    }

    public String getWeddingSplit() {
        return weddingSplit;
    }

    public void setWeddingSplit(String weddingSplit) {
        this.weddingSplit = weddingSplit;
    }

    public Double getDeposit() {
        return deposit;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", oid=").append(oid);
        sb.append(", pid=").append(pid);
        sb.append(", cid=").append(cid);
        sb.append(", hid=").append(hid);
        sb.append(", hotelname=").append(hotelname);
        sb.append(", hoteladdress=").append(hoteladdress);
        sb.append(", ordertime=").append(ordertime);
        sb.append(", weddingTime=").append(weddingTime);
        sb.append(", weddingSplit=").append(weddingSplit);
        sb.append(", deposit=").append(deposit);
        sb.append(", money=").append(money);
        sb.append(", status=").append(status);
        sb.append(", comment=").append(comment);
        sb.append("]");
        return sb.toString();
    }
}