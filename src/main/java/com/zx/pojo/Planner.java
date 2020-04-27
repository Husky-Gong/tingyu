package com.zx.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 策划师信息表,存储婚庆公司的策划师信息
 * </p>
 *
 * @author ${author}
 * @since 2020-04-21
 */
@TableName("t_planner")
public class Planner extends Model<Planner> {

    private static final long serialVersionUID=1L;

    /**
     * 策划师编号
     */
    @TableId(value = "nid", type = IdType.AUTO)
    private Integer nid;

    /**
     * 策划师姓名
     */
    private String nname;

    /**
     * 策划师手机号
     */
    private String nphone;

    /**
     * 添加时间
     */
    private LocalDate addtime;

    /**
     * 账号状态(1.正常,2.禁用)
     */
    private String status;

    /**
     * 公司编号
     */
    private Integer cid;

    /**
     * 策划师订单量
     */
    private Integer pnum;


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

    public LocalDate getAddtime() {
        return addtime;
    }

    public void setAddtime(LocalDate addtime) {
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

    public Integer getPnum() {
        return pnum;
    }

    public void setPnum(Integer pnum) {
        this.pnum = pnum;
    }

    @Override
    protected Serializable pkVal() {
        return this.nid;
    }

    @Override
    public String toString() {
        return "Planner{" +
        "nid=" + nid +
        ", nname=" + nname +
        ", nphone=" + nphone +
        ", addtime=" + addtime +
        ", status=" + status +
        ", cid=" + cid +
        ", pnum=" + pnum +
        "}";
    }
}
