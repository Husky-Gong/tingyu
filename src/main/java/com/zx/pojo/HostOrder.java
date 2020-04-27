package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 主持人的订单信息表
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_host_order")
public class HostOrder extends Model<HostOrder> {

    private static final long serialVersionUID=1L;

    /**
     * 订单编号
     */
    private Integer oid;

    /**
     * 新人编号
     */
    private Integer pid;

    /**
     * 婚庆公司编号
     */
    private Integer cid;

    /**
     * 主持人编号
     */
    private Integer hid;

    /**
     * 酒店名称
     */
    private String hotelname;

    /**
     * 酒店地址
     */
    private String hoteladdress;

    /**
     * 订单时间
     */
    private LocalDateTime ordertime;

    /**
     * 婚礼时间
     */
    private LocalDateTime weddingTime;

    /**
     * 婚礼时间2(1.上午,2.下午)
     */
    private String weddingSplit;

    /**
     * 订金
     */
    private Double deposit;

    /**
     * 订单金额
     */
    private Double money;

    /**
     * 订单状态(1.待主持,2.已主持,3.已删除)
     */
    private String status;

    /**
     * 订单备注
     */
    private String comment;


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

    public LocalDateTime getOrdertime() {
        return ordertime;
    }

    public void setOrdertime(LocalDateTime ordertime) {
        this.ordertime = ordertime;
    }

    public LocalDateTime getWeddingTime() {
        return weddingTime;
    }

    public void setWeddingTime(LocalDateTime weddingTime) {
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
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "HostOrder{" +
        "oid=" + oid +
        ", pid=" + pid +
        ", cid=" + cid +
        ", hid=" + hid +
        ", hotelname=" + hotelname +
        ", hoteladdress=" + hoteladdress +
        ", ordertime=" + ordertime +
        ", weddingTime=" + weddingTime +
        ", weddingSplit=" + weddingSplit +
        ", deposit=" + deposit +
        ", money=" + money +
        ", status=" + status +
        ", comment=" + comment +
        "}";
    }
}
